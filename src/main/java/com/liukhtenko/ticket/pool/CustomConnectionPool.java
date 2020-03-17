package com.liukhtenko.ticket.pool;


import com.liukhtenko.ticket.exception.DaoException;
import com.liukhtenko.ticket.exception.PoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum CustomConnectionPool {
    INSTANCE;

    static Logger logger = LogManager.getLogger();
    public BlockingQueue<ProxyConnection> freeConnections; // FIXME: 13.01.2020 private
    private Queue<ProxyConnection> givenAwayConnections; //контроль целостности пула
    private static final String URL = "url";
    private static final String DRIVER_REGISTRATION = "driverRegistration";
    private final static int DEFAULT_POOL_SIZE = 32;
    //other pool params

    CustomConnectionPool() {
        PropertyLoader propertyLoader = new PropertyLoader();
        Properties property = null;
        try {
            property = propertyLoader.loadProperties();
        } catch (FileNotFoundException e) {
            // logger.log(Level.WARN,   " not transferred", e); // FIXME: 26.01.2020
        }
        String url = property.getProperty(URL);
        String regDriver = property.getProperty(DRIVER_REGISTRATION);
        try {
            Class.forName(regDriver);
        } catch (ClassNotFoundException e) {
            // FIXME: 18.01.2020 can not write log
            throw new RuntimeException("Unable to register driver");
        }

        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                Connection connection = DriverManager.getConnection(url, property);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                freeConnections.offer(proxyConnection);

            } catch (SQLException e) {
                Logger logger = LogManager.getLogger();// FIXME: 18.01.2020 can not write log
                logger.log(Level.WARN, " not transferred", e);
            }
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer((ProxyConnection) connection);
        } catch (InterruptedException e) {
            logger.log(Level.WARN, connection + " not transferred", e);
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) throws PoolException {
        if (connection.getClass() == ProxyConnection.class) {
            givenAwayConnections.remove(connection);
            freeConnections.offer((ProxyConnection) connection);
        } else {
            throw new PoolException("Trying to add alien connection");
        }
    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException | InterruptedException e) {
                logger.log(Level.ERROR, "Unable to close connection in " + freeConnections, e);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        Collections.list(DriverManager.getDrivers()).forEach(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Unable to deregister driver", e);
            }
        });
    }
}
