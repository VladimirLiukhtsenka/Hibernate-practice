package com.liukhtenko.ticket.dao;


import com.liukhtenko.ticket.pool.CustomConnectionPool;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityTransaction {
    private Connection connection;
    static Logger logger = LogManager.getLogger();

    public void begin(AbstractDao dao, AbstractDao... daos) {
        try {
            if (connection == null) {
                connection = CustomConnectionPool.INSTANCE.getConnection();
            }
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            logger.log(Level.WARN, "Impossible to establish AutoCommit to value false", e);
        }
        dao.setConnection(connection);
        logger.log(Level.DEBUG, dao + " have a connection: " + connection);
        for (AbstractDao abstractDao : daos) {
            if (abstractDao != null) {
                abstractDao.setConnection(connection);
                logger.log(Level.DEBUG, abstractDao + " have a connection: " + connection);
            }
        }
    }

    public void end() {
        try {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "impossible to return connection to pool", e);
        }
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARN, "impossible to commit " + connection, e);
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            logger.log(Level.WARN, "impossible to rollback " + connection, e);
        }
    }
}
