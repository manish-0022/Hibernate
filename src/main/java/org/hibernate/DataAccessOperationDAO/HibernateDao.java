package org.hibernate.DataAccessOperationDAO;

import org.hibernate.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

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
    public void update(int empid,String firstname){
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class,empid);
        if(employee!=null){
            employee.setFirstname(firstname);
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }else {
            System.out.println("Employee does not exist with empid" +empid);
        }
        session.close();
    }
    public void update(int empid,Employee newemployee){
        Session session = sessionFactory.openSession();
        //fetch Student based on employeeId

        Employee employee = session.get(Employee.class,empid);
        System.out.println("employee fetched: " +employee);

        if(employee!=null){
            employee.setAddress(newemployee.getAddress());
            employee.setContactNo(newemployee.getContactNo());

            employee.setFirstname(newemployee.getFirstname());
            employee.setEmail(newemployee.getEmail());

            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
        else {
            System.out.println("Employee does not exist with empid" +empid);
        }
       session.close();


    }

    public void delete(int empid){
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class,empid);
         if(employee!=null){
             Transaction transaction = session.beginTransaction();
             session.delete(employee);
             transaction.commit();
             System.out.println("record deleted");
         }else {
             System.out.println("record not found with address" +empid);
         }
    }

}
