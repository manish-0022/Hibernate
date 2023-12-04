package org.hibernate.Service;

import org.hibernate.DataAccessOperationDAO.HibernateDao;
import org.hibernate.Entity.Employee;
import org.hibernate.Session;

public class HibernateService {
    HibernateDao hibernateDao = new HibernateDao();

    public void createEmployee(Employee employee) {

        hibernateDao.createEmployee(employee);
    }
    public Employee GetEmployeeByID(int employeeid){
        return hibernateDao.GetEmployeeByID(employeeid);
    }
    public void update(int empid,String firstname){
        hibernateDao.update(empid,firstname);
    }
    public void update(int empid,Employee newemployee){
        hibernateDao.update(empid,newemployee);
    }
    public void delete(int empid){
        hibernateDao.delete(empid);
    }

    }


