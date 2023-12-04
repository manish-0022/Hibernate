package org.hibernate.Controller;

import org.hibernate.Entity.Employee;
import org.hibernate.Service.HibernateService;

public class HIbernateTestController {
    public static void main(String[] args) {
        HibernateService hibernateService = new HibernateService();
        Employee employee = getemployee();
/*
        //create
        hibernateService.createEmployee(employee);

        //fetch data from database
        Employee resultemployee = hibernateService.GetEmployeeByID(1);
        System.out.println(resultemployee);

        //update operation
       /hibernateService.update(2,"Ravi");

        Employee newemployee = new Employee();
        newemployee.setContactNo("96254789");
        newemployee.setAddress("jaipur");
        newemployee.setEmail("manish.goyal0033@gmail.com");
        newemployee.setFirstname("jugnu");
        newemployee.setLastname("goyal");

        hibernateService.update(1,newemployee);

 */

        //deleting the employee

        hibernateService.delete(1);


    }
    private static Employee getemployee(){
        Employee employee = new Employee();
        employee.setFirstname("Takshvi");
        employee.setAddress("Sanganer");
        employee.setContactNo("79187653");
        employee.setLastname("Agrawal");
        employee.setEmail("taksvhi2016@gmail.com");
        return employee;
    }
}
