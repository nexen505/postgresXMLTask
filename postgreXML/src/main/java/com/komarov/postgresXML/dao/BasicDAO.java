package com.komarov.postgresXML.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class BasicDAO {

    private SessionFactory sessionFactory;

    public BasicDAO() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "password");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:3306/mkyong");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("show_sql", "true");
        sessionFactory = buildSessionFactory(properties);
    }

    public BasicDAO(Properties properties) {
        sessionFactory = buildSessionFactory(properties);
    }

    private SessionFactory buildSessionFactory(Properties properties) {
        try {
            // TODO add entity classes here
            Configuration configuration = new Configuration().addProperties(properties);
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        shutdown();
    }
}
