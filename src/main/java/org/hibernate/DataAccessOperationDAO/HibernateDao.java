package org.hibernate.DataAccessOperationDAO;

import org.hibernate.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDao {
    static  SessionFactory sessionFactory = null;
    static {
        //creating configuration reading the properties from resources
        Configuration configuration = new Configuration();
        configuration.configure();

        //build the session factory and creating the database connection
         sessionFactory = configuration.buildSessionFactory();
    }
    public void createEmployee(Employee employee) {


        //creating session and perform operations on database

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();   //we have to commit the transaction in jdc transaction is auto commit.
        session.close();

    }
    public Employee GetEmployeeByID(int employeeid){
        Session session = sessionFactory.openSession();
       Employee employee =  session.get(Employee.class,employeeid);
       if(employee!=null){
           return employee;
       }
        else{
           System.out.println("record is not found: "+employeeid);
       }
        return null;
    }
}
