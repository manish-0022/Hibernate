package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //creating configuration reading the properties from resources
        Configuration configuration = new Configuration();
        configuration.configure();

        //build the session factory and creating the database connection
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //creating session and perform operations on database

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(getemployee());
        transaction.commit();   //we have to commit the transaction in jdc transaction is auto commit.
        session.close();

    }
    private static Employee getemployee(){
        Employee employee = new Employee();
        employee.setFirstname("Manish");
        employee.setLastname("Goyal");
        employee.setEmail("manish.goyal03@yahoo.in");

        return employee;
    }
}
