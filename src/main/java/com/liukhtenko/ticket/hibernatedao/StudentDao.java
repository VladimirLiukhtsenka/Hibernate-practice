package com.liukhtenko.ticket.hibernatedao;

import com.liukhtenko.ticket.entity.StudentEntity;
import com.liukhtenko.ticket.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<StudentEntity> getAllStudents() {
        Session session = null;
        List<StudentEntity> list = new ArrayList<>();
        SessionFactory sessionFactory;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            list = session.createCriteria(StudentEntity.class).list();
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

    public void addStudent(StudentEntity student) {
        Session session = null;
        SessionFactory sessionFactory;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction;
            transaction = session.beginTransaction();
            session.save(student);
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

    public void updateStudent(long studentId, String newName) {
        Session session = null;
        SessionFactory sessionFactory;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction;
            transaction = session.beginTransaction();
            StudentEntity studentEntity = session.get(StudentEntity.class, studentId);
            studentEntity.setName(newName);
            session.update(studentEntity);
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

    public void removeStudent(long studentId){
        Session session = null;
        SessionFactory sessionFactory;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction;
            transaction = session.beginTransaction();
            StudentEntity studentEntity = session.get(StudentEntity.class, studentId);
            session.delete(studentEntity);
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
