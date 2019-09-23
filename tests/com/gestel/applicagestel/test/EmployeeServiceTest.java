/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.test;

import com.gestel.applicagestel.model.Departement;
import com.gestel.applicagestel.model.Employee;
import com.gestel.applicagestel.service.DepartementService;
import com.gestel.applicagestel.service.EmployeeService;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Abroun
 */
public class EmployeeServiceTest {
    
     private static ClassPathXmlApplicationContext context;
     private static EmployeeService employeeService;
     private static DepartementService departementService;
   

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context= new ClassPathXmlApplicationContext("packageConf/applicationContext.xml");
        employeeService =(EmployeeService) context.getBean("employeeService");
       departementService =(DepartementService) context.getBean("departementService");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        context.close();
    
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
  /* @Test
    public void testFindAll(){
         List<Employee> allEmployees =employeeService.listEmployees();
         assertNotNull(allEmployees);
         assertTrue(allEmployees.size() >0);
         System.out.println(allEmployees);
    }
    @Test
    public void testFindById(){
         Employee employee=employeeService.getEmployeeById(2);
         assertNotNull(employee);
         assertTrue(employee.getIdpersonne().equals(2));
        
    }
  /* @Test
    public void testSave(){
        Departement dp = new Departement("Transport");
         
         Employee employee= new Employee("VF344","Max","Sloger","TR","E4547","16/03/15");
         employee.setDepartement(dp);
        employeeService.addEmployee(employee);
        //Departement dp = new Departement();
    	//dp.setEmployees(employee);
        assertNotNull(employee.getIdpersonne());
    }*/
   /* @Test
    public void testRemove(){
       Employee employee = new Employee();
         employeeService.removeEmployee(4);
         //assertNotNull(employee);
        assertNull(employee.getIdpersonne().equals(4));
    }*/
  /* @Test
    public void testSaveDepar(){
        Departement dp = new Departement("Pub");
         
        Employee employee3= new Employee("OP445","cindy","Sstum","TR","E4547","16/03/15");
        // employee.setDepartement(dp);
        employee3.setDepartement(dp);
        dp.getEmployees().add(employee3);
        departementService.addDepartement(dp);
        //Departement dp = new Departement();
    	//dp.setEmployees(employee);
        assertNotNull(dp.getIddepartement());
    }*/
    
    @Test
    public void testaddPerToDep(){
    
         //assertNotNull(dp);
        
         //assertTrue(employee.getIdpersonne().equals(2))
         Employee employee1= new Employee("OM335","Silva","libi","TR","E4547","16/06/15");
         //Employee employee2= new Employee("VR564","herman","","TR","E4547","16/03/15");
        
            Departement dp =departementService.getDepartementById(7);
            
             
         
        employee1.setDepartement(dp);
      
        dp.getEmployees().add(employee1);
        // departementService.addPersonnes(dp.setEmployees(employee1));
       //dp.addEmployees(employee1);
        employeeService.addEmployee(employee1);
         
         //departementService.updateDepartement(dp);
          assertTrue(dp.getIddepartement().equals(7));
          assertNotNull(employee1.getIdpersonne());
         
         
         
    }
  /*   @Test
    public void testDeparById(){
         Departement dp=departementService.getDepartementById(7);
         assertNotNull(dp);
         assertTrue(dp.getIddepartement().equals(7));
        
    }
    
  /*  @Test
    public void testUpdate(){
       
         //assertTrue(employee.getIdpersonne().equals(2))
         Employee employee1= employeeService.getEmployeeById(2);
         //Employee employee2= new Employee("VR564","herman","","TR","E4547","16/03/15");
         employee1.setCin("CC456");
        
       
       
         
         employeeService.updateEmployee(employee1);
         assertNotNull(employee1.getIdpersonne().equals(2));
         
         
         
    }*/
}

