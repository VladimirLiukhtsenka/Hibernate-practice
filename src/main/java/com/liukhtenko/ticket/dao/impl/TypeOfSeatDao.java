package com.liukhtenko.ticket.dao.impl;



import com.liukhtenko.ticket.dao.AbstractDao;
import com.liukhtenko.ticket.entity.TypeSeat;
import com.liukhtenko.ticket.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class TypeOfSeatDao extends AbstractDao<String, TypeSeat> {
    private static final String SQL_SELECT_ALL_TYPE_OF_SEAT =
            "SELECT type, description FROM type_seat";
    private static final String SQL_SELECT_TYPE_OF_SEAT_BY_DESCRIPTION =
            "SELECT type, description FROM type_seat WHERE description=?";
    private static final String SQL_SELECT_TYPE_OF_SEAT_BY_TYPE =
            "SELECT type, description FROM type_seat WHERE type=?";
    private static final String SQL_DELETE_TYPE_OF_SEAT =
            "DELETE FROM type_seat WHERE type=?";
    private static final String SQL_UPDATE_TYPE_OF_SEAT =
            "UPDATE type_of_seat SET description=? WHERE type=?";
    private static final String SQL_CREATE_TYPE_OF_SEAT =
            "INSERT INTO type_seat (type, description)  VALUES(?, ?)";

    public List<TypeSeat> findTypeOfSeatByDescription(String description) throws DaoException {
        List<TypeSeat> typeOfSeats = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_TYPE_OF_SEAT_BY_DESCRIPTION);
            statement.setString(1, description);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TypeSeat typeOfSeat = new TypeSeat();
                typeOfSeat.setType(resultSet.getString("type"));
                typeOfSeat.setDescription(resultSet.getString("description"));
                typeOfSeats.add(typeOfSeat);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(resultSet);
            close(statement);
        }

        return typeOfSeats;
    }

    @Override
    public List<TypeSeat> findAll() throws DaoException {
        List<TypeSeat> typeOfSeats = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_TYPE_OF_SEAT);
            while (resultSet.next()) {
                TypeSeat typeOfSeat = new TypeSeat();
                typeOfSeat.setType(resultSet.getString("type"));
                typeOfSeat.setDescription(resultSet.getString("description"));
                typeOfSeats.add(typeOfSeat);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(resultSet);
            close(statement);
        }
        return typeOfSeats;
    }

    @Override
    public TypeSeat find(String type) throws DaoException {
        TypeSeat typeOfSeat = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_TYPE_OF_SEAT_BY_TYPE);
            statement.setString(1, type);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                typeOfSeat = new TypeSeat();
                typeOfSeat.setType(resultSet.getString("type"));
                typeOfSeat.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(resultSet); // FIXME: 18.01.2020
            close(statement);
        }
        return typeOfSeat;
    }

    @Override
    public boolean delete(String type) throws DaoException {
        boolean ret;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_TYPE_OF_SEAT);
            statement.setString(1, type);
            ret = (1 == statement.executeUpdate());
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }

        return ret;
    }

    @Override
    public boolean delete(TypeSeat entity) throws DaoException {
        boolean ret;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_TYPE_OF_SEAT);
            statement.setString(1, entity.getType());
            ret = (1 == statement.executeUpdate()); // FIXME: 12.01.2020
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }

        return ret;
    }

    @Override
    public boolean create(TypeSeat entity) throws DaoException {
        boolean ret;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CREATE_TYPE_OF_SEAT);
            statement.setString(1, entity.getType());
            statement.setString(2, entity.getDescription());
            ret = (1 == statement.executeUpdate()); // FIXME: 12.01.2020
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return ret;
    }

    @Override
    public boolean update(TypeSeat entity) throws DaoException {
        boolean ret;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_TYPE_OF_SEAT);
            statement.setString(1, entity.getDescription());
            statement.setString(2, entity.getType());
            ret = (1 == statement.executeUpdate()); // FIXME: 12.01.2020
        } catch (SQLException e) {
            throw new DaoException(e);    // TODO: 12.01.2020 если не update?
        } finally {
            close(statement);
        }
        return ret;
    }
}
