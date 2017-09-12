package com.komarov.postgresXML.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;

public class BasicDAO<T> {

    private SessionFactory sessionFactory;

    public BasicDAO() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "password");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/mkyong");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hbm2ddl.auto", "update");
        properties.setProperty("show_sql", "true");
        sessionFactory = buildSessionFactory(properties);
    }

    public BasicDAO(Properties properties) {
        sessionFactory = buildSessionFactory(properties);
    }

    private SessionFactory buildSessionFactory(Properties properties) {
        try {
            Configuration configuration = new Configuration().addProperties(properties);
            configuration.addAnnotatedClass(FaceInfo.class);
            configuration.addAnnotatedClass(ObjectInfo.class);
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        shutdown();
    }

    public void saveEntities(List<T> entities) {
        if (entities != null) {
            for (T entity : entities) {
                Session session = sessionFactory.openSession();
                try {
                    session.beginTransaction();
                    session.save(entity);
                    session.getTransaction().commit();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    if (session != null && session.isOpen()) {
                        session.getTransaction().rollback();
                    }
                } finally {
                    if (session != null && session.isOpen()) {
                        session.close();
                    }
                }
            }
        }
    }
}
