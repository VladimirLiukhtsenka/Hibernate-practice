package com.liukhtenko.ticket.service;

import com.liukhtenko.ticket.dao.EntityTransaction;
import com.liukhtenko.ticket.dao.impl.UserDao;
import com.liukhtenko.ticket.entity.User;
import com.liukhtenko.ticket.exception.DaoException;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        UserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(userDao);
            users = userDao.findAll();
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        } finally {
            transaction.end();
        }
        return users;
    }

    public User findUserById(long id) throws DaoException {
        User user = new User();
        UserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(userDao);
            user = userDao.find(id);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        } finally {
            transaction.end();
        }
        if (user == null) {
            throw new DaoException(); // FIXME: 23.01.2020 
        }
        return user;
    }

    public User findUserByMailAndPassword(String mail,String password) throws DaoException {
        User user = new User();
        UserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(userDao);
            user = userDao.find( mail, password);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        } finally {
            transaction.end();
        }
        if (user == null) {
            throw new DaoException(); // FIXME: 23.01.2020
        }
        return user;
    }
    public void deleteUserById(long id) throws DaoException {
        UserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(userDao);
            boolean flag = userDao.delete(id);
            // FIXME: 23.01.2020 log+flag
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        } finally {
            transaction.end();
        }
    }

    public boolean createUser(User user) throws DaoException {
        UserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();
        boolean flag = false;
        try {
            transaction.begin(userDao);
            flag = userDao.create(user);
            // FIXME: 23.01.2020 log+flag
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        } finally {
            transaction.end();
        }
        return flag;
    }

    public void updateUser(User user) throws DaoException {
        UserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(userDao);
            boolean flag = userDao.update(user);
            // FIXME: 23.01.2020 log+flag
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        } finally {
            transaction.end();
        }
    }
}
