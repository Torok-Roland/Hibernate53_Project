package org.example.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBaseConfig {

    private static SessionFactory sessionFactory;

    private DataBaseConfig(){

    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = new Configuration()
                    .configure("hibernate.config.xml")
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

}
