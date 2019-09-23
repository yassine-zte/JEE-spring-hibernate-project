/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;



import com.gestel.applicagestel.model.Departement;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestel.applicagestel.model.Employee;
/**
 *
 * @author Abroun
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    
     //private static final Logger logger =  LoggerFactory.getLogger(EmployeeDAOImpl.class);
     @Autowired
     private SessionFactory sessionFactory;
     
    
     
    @Override
    public void addEmployee(Employee employee) {
       /* Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
       // logger.info("Person saved successfully, Person Details="+emp);
       * */
       sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
       /* Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
		logger.info("Person updated successfully, Person Details="+employee);
                * */
         sessionFactory.getCurrentSession().update(employee);      
    }
    
    //@SuppressWarnings("unchecked")
    @Override
    public List<Employee> listEmployees() {
       /* Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeesList = session.createQuery("from Employee").list();
		for(Employee emp : employeesList){
			logger.info("Person List::"+emp);
		}
		return employeesList;*/
       return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    @Override
    public Employee getEmployeeById(int idpersonne) {
       /* Session session = this.sessionFactory.getCurrentSession();		
		Employee emp = (Employee) session.load(Employee.class, new Integer(idpersonne));
		logger.info("Person loaded successfully, Person details="+emp);
		return emp;*/
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, idpersonne);
    }

    @Override
    public void removeEmployee(int idpersonne) {
        /*Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(idpersonne));
		if(null != emp){
			session.delete(emp);
		}
		logger.info("Person deleted successfully, person details="+emp);*/
      Employee emp = (Employee) sessionFactory.getCurrentSession().load(Employee.class, idpersonne);
              sessionFactory.getCurrentSession().delete(emp);
              
	}

    
    
    }
