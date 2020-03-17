package com.liukhtenko.ticket.service;




import com.liukhtenko.ticket.dao.EntityTransaction;
import com.liukhtenko.ticket.dao.impl.TypeOfSeatDao;
import com.liukhtenko.ticket.entity.TypeSeat;
import com.liukhtenko.ticket.exception.DaoException;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class SomeService {

    public void createTypeOfSeat(TypeSeat typeOfSeat){

        TypeOfSeatDao typeOfSeatDaoFromAbsDao = new TypeOfSeatDao();

        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(typeOfSeatDaoFromAbsDao);
            typeOfSeatDaoFromAbsDao.create(typeOfSeat);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        }finally {
            transaction.end();
        }
    }

    public void updateTypeOfSeat(TypeSeat typeOfSeat){

        TypeOfSeatDao typeOfSeatDaoFromAbsDao = new TypeOfSeatDao();

        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(typeOfSeatDaoFromAbsDao);
            typeOfSeatDaoFromAbsDao.update(typeOfSeat);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        }finally {
            transaction.end();
        }
    }
    public void updateAndCreateTypeOfSeat(TypeSeat [] typeOfSeats){

        TypeOfSeatDao typeOfSeatDaoFromAbsDao = new TypeOfSeatDao();

        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(typeOfSeatDaoFromAbsDao);
            typeOfSeatDaoFromAbsDao.update(typeOfSeats[0]);
            typeOfSeatDaoFromAbsDao.create(typeOfSeats[1]);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        }finally {
            transaction.end();
        }
    }
    public void deleteTypeOfSeatByEntity(TypeSeat typeOfSeat){

        TypeOfSeatDao typeOfSeatDaoFromAbsDao = new TypeOfSeatDao();

        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(typeOfSeatDaoFromAbsDao);
            typeOfSeatDaoFromAbsDao.delete(typeOfSeat);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        }finally {
            transaction.end();
        }
    }


    public List<TypeSeat> findAllTypeOfSeat(){
        List<TypeSeat> typeOfSeats = new ArrayList<>();
        TypeOfSeatDao typeOfSeatDaoFromAbsDao = new TypeOfSeatDao();

        EntityTransaction transaction = new EntityTransaction();
        try {
            transaction.begin(typeOfSeatDaoFromAbsDao);
          typeOfSeats =  typeOfSeatDaoFromAbsDao.findAll();
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
            e.printStackTrace();// FIXME: 12.01.2020 log
        }finally {
            transaction.end();
        }
        return typeOfSeats;
    }


//    public void doService(params){
//        TypeOfSeatDaoFromAbsDao typeOfSeatDaoFromAbsDao = new TypeOfSeatDaoFromAbsDao();
//
//        EntityTransaction transaction = new EntityTransaction();
//        try {
//            transaction.begin(typeOfSeatDaoFromAbsDao);
//            typeOfSeatDaoFromAbsDao.create(param1);
//            transaction.commit();
//        }catch (SQLException e){
//            transaction.rollback();
//            e.printStackTrace();// FIXME: 12.01.2020 log
//        }finally {
//            transaction.end();
//        }
//    }
}
