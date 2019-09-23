/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.test;

import com.gestel.applicagestel.dao.EmployeeDAO;
import com.gestel.applicagestel.model.Employee;
import com.gestel.applicagestel.service.EmployeeService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Abroun
 */
public class MyTests {
    private static ClassPathXmlApplicationContext context;
    private static EmployeeService employeeService;
    public static void main(String[] args) {
   /* Resource resource = new FileSystemResource(
           //" /WEB-INF/applicationContext.xml");
            "./src/main/resources/applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);*/
        context= new ClassPathXmlApplicationContext("packageConf/applicationContext.xml");
        employeeService =(EmployeeService) context.getBean("employeeService");
        Employee employee = new Employee();
        
        employee.setMatricule("AB345");
        employee.setNom("frodo");
        employee.setPrenom("fred");
        employee.setFonction("comptable");
        employee.setCin("MM23344");
        employee.setDateaquise("13/05/15");
        /* EmployeeDAO employeeDao = (EmployeeDAO)factory.getBean(
            "employeeDao");*/
        
        employeeService.addEmployee(employee);

        Employee empResult = employeeService.getEmployeeById(1);
        System.out.println(empResult);
    }
    
}
