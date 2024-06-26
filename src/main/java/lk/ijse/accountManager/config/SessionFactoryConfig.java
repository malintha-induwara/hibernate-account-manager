package lk.ijse.accountManager.config;

import lk.ijse.accountManager.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    public static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;


    private SessionFactoryConfig(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Student.class)
                .getMetadataBuilder()
                .build();
       this.sessionFactory= metadata.buildSessionFactory();

    }

    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig==null)?sessionFactoryConfig=new SessionFactoryConfig():sessionFactoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }


}

