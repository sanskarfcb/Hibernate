package com.example.HibernateLearning.Util;

import com.example.HibernateLearning.Entity.Certificate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Certificate.class)
                    .buildSessionFactory();

        } catch (Exception e) {
            throw new RuntimeException("Error in creating session factory" + e.getMessage() );
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
