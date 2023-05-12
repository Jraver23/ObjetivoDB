package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory =
            buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            //Create the configuration object.
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            System.out.println("Contraseña de la BBDD: " + configuration.getProperties().getProperty("hibernate.connection.password"));
            // Get the SessionFactory object from configuration.
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (Exception e) {
            System.out.println("Error al construir SessionFactory: " + e);
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
