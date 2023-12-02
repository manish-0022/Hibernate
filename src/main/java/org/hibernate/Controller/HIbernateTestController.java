package org.hibernate.Controller;

import org.hibernate.Entity.Employee;
import org.hibernate.Service.HibernateService;

public class HIbernateTestController {
    public static void main(String[] args) {
        HibernateService hibernateService = new HibernateService();
        Employee employee = getemployee();
        hibernateService.createEmployee(employee);

        //fetch data from database
        Employee resultemployee = hibernateService.GetEmployeeByID(1);
        System.out.println(resultemployee);


    }
    private static Employee getemployee(){
        Employee employee = new Employee();
        employee.setFirstname("manish");
        employee.setLastname("Gupta");
        employee.setEmail("manish.goyal03@yahoo.in");

        return employee;
    }
}
