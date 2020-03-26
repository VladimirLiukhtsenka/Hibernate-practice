package com.liukhtenko.ticket.hibernatedao;

import com.liukhtenko.ticket.entity.TeacherEntity;
import com.liukhtenko.ticket.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * With HQL
 */
public class TeacherDao {
    public List<TeacherEntity> getAllTeachers() {
        Session session = null;
        List<TeacherEntity> list = new ArrayList<>();
        SessionFactory sessionFactory;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Query query = session.createQuery("FROM  TeacherEntity ");
            list = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Mistake", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    public void addTeacher() { // fixme
        Session session = null;
        SessionFactory sessionFactory;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Query query = session.createQuery("INSERT INTO TeacherEntity (name)    " +
                    "SELECT name FROM StudentEntity ");
            Transaction transaction;
            transaction = session.beginTransaction();
            //  session.save(teacher);
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Mistake", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<TeacherEntity> findTeacherByName(String name) {
        Session session = null;
        SessionFactory sessionFactory;
        List<TeacherEntity> teacherEntity = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Query query = session.createQuery("FROM TeacherEntity where name = :paramName");
            query.setParameter("paramName", name);
            teacherEntity = query.getResultList();
            Transaction transaction;
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Mistake", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teacherEntity;
    }

    public void updateTeacherFieldOfScience(String name, String newFieldOfScience){
        Session session = null;
        SessionFactory sessionFactory;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            Query query = session.createQuery("UPDATE TeacherEntity set fieldOfScience = :field where name = :name");
            query.setParameter("field", newFieldOfScience);
            query.setParameter("name", name);
            System.out.println(query.executeUpdate());
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Mistake", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
