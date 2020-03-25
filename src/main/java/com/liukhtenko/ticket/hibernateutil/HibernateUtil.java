package com.liukhtenko.ticket.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addResource("CourseEntity.hbm.xml");
            configuration.addResource("ScheduleEntity.hbm.xml");
            configuration.addResource("StudentEntity.hbm.xml");
            configuration.addResource("TeacherEntity.hbm.xml");
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
