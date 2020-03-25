package com.liukhtenko.ticket.hibernatedao;

import com.liukhtenko.ticket.entity.CourseEntity;
import com.liukhtenko.ticket.entity.StudentEntity;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public List<StudentEntity> getAllStudents() {
        Session session = null;
        List<StudentEntity> list = new ArrayList<>();
        SessionFactory sessionFactory;
        try {
            Configuration configuration = new Configuration();
            configuration.addResource("CourseEntity.hbm.xml");
            configuration.addResource("ScheduleEntity.hbm.xml");
            configuration.addResource("StudentEntity.hbm.xml");
            configuration.addResource("TeacherEntity.hbm.xml");
            sessionFactory = configuration.configure().buildSessionFactory();
            session = sessionFactory.openSession();

            Long id =1L;
            StudentEntity  studentEntity= (StudentEntity)session.load(StudentEntity.class,id);


            list.add(studentEntity);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Mistake", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }
}
