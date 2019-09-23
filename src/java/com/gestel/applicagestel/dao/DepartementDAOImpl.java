/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.model.Departement;
import com.gestel.applicagestel.model.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abroun
 */
@Repository
public class DepartementDAOImpl implements DepartementDAO{
    
private static final Logger logger =  LoggerFactory.getLogger(DepartementDAOImpl.class);
     @Autowired
     private SessionFactory sessionFactory;
     
     public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
     
    @Override
    public void addDepartement(Departement dp) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dp);
    }

    @Override
    public void updateDepartement(Departement dp) {
        /*Session session = this.sessionFactory.getCurrentSession();
		session.update(dp);*/
        sessionFactory.getCurrentSession().update(dp); 
    }

    @Override
    public List<Departement> listDepartement() {
       Session session = this.sessionFactory.getCurrentSession();
		List<Departement> departementsList = session.createQuery("from Departement").list();
		for(Departement dp : departementsList){
			//logger.info("Person List::"+emp);
		}
		return departementsList;
    }

    @Override
    public Departement getDepartementById(int iddepartement) {
        /*Session session = this.sessionFactory.getCurrentSession();		
		Departement dp = (Departement) session.load(Departement.class, new Integer(id));
		//logger.info("Person loaded successfully, Person details="+emp);
		return dp;*/
         return (Departement) sessionFactory.getCurrentSession().get(Departement.class, iddepartement);
    }

    @Override
    public void removeDepartement(int id) {
       Session session = this.sessionFactory.getCurrentSession();
		Departement dp = (Departement) session.load(Departement.class, new Integer(id));
		if(null != dp){
			session.delete(dp);
                }
    }

    @Override
    public void addPersonnes(List<Employee> employees) {
        for(Employee employee:employees){
        sessionFactory.getCurrentSession().save(employee);
       }
      
    
    }
    
    

    
}
