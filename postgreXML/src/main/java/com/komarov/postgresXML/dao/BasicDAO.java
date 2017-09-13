package com.komarov.postgresXML.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;

public class BasicDAO<T> {

    private SessionFactory sessionFactory;

    public BasicDAO() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "password");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/mkyong");
        prepareProps(properties);
        sessionFactory = buildSessionFactory(properties);
    }

    public BasicDAO(Properties properties) {
        prepareProps(properties);
        sessionFactory = buildSessionFactory(properties);
    }

    private void prepareProps(Properties properties) {
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("show_sql", "true");
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

    public void shutdown() {
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
            System.out.println("Saving " + entities.size() + " entities..");
            final int[] count = {0};
            entities.forEach((T entity) -> {
                System.out.println("Saving entity: " + entity.toString());
                Transaction transaction = null;
                Session session = sessionFactory.openSession();
                try {
                    transaction = session.beginTransaction();
                    session.save(entity);
                    session.getTransaction().commit();
                    System.out.println("Entity is saved! ");
                    count[0]++;
                } catch (Exception ex) {
                    System.out.println("Entity wasn't saved. Exception: " + ex.getMessage());
                    if (transaction != null) {
                        transaction.rollback();
                    }
                } finally {
                    if (session != null) {
                        session.flush();
                        session.close();
                    }
                }
            });
            System.out.println("Saved " + count[0] + " of " + entities.size() + " entities!");
        }
    }
}
