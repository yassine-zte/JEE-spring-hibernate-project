/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.dao.ServiceDAO;
import com.gestel.applicagestel.model.Option;
import com.gestel.applicagestel.model.Sim;
import com.gestel.applicagestel.service.ServiceService;
import com.gestel.applicagestel.service.SimService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abroun
 */
@Repository
public class ServiceDAOImpl implements ServiceDAO{
     @Autowired
    private SimService simService;
    
    @Qualifier("simService")
    
     public void setSimservice(SimService simService) {
        this.simService = simService;
    }
   
     @Autowired
     private SessionFactory sessionFactory;

    @Override
    public void addService(Option service) {
        sessionFactory.getCurrentSession().save(service);
    }

    @Override
    public void updateService(Option service) {
         sessionFactory.getCurrentSession().update(service);
    }

    @Override
    public List<Option> listServices() {
        return sessionFactory.getCurrentSession().createQuery("from Option").list();
    }

    @Override
    public Option getServiceById(int idservice) {
        return (Option) sessionFactory.getCurrentSession().get(Option.class, idservice);
    }

    @Override
    public void removeService(int idservice) {
         Option ser = (Option) sessionFactory.getCurrentSession().load(Option.class, idservice);
              sessionFactory.getCurrentSession().delete(ser);
    }
    
    @Override
    public List<Option> serviceActive(String numero){
       /* return sessionFactory.getCurrentSession().createQuery(" select op from Sim sm "+
                " join sm.services op " + "where sm.numerotel = "+numero).list();*/
        
       /*SimService smServ ;
       Sim sm = smServ.getSimByNum(numero);*/
    
    
       Sim sm= simService.getSimByNum(numero);
       ArrayList activateOp =new ArrayList();
       int idx=0;
       for( Iterator<Option> it= sm.getServices().iterator();it.hasNext();idx++){
          
          Option op = it.next() ;
          activateOp.add(op);
       }
       return activateOp ;
       
       
    }
    
}
