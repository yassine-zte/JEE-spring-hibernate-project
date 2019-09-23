/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.model.Sim;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abroun
 */
@Repository
public class SimDAOImpl implements SimDAO{
  @Autowired
   private SessionFactory sessionFactory;

   
  
  
    @Override
    public void addSim(Sim sim) {
        sessionFactory.getCurrentSession().save(sim);
    }

    @Override
    public void updateSim(Sim sim) {
        sessionFactory.getCurrentSession().update(sim);
    }

    @Override
    public List<Sim> listSims() {
        return  sessionFactory.getCurrentSession().createQuery("from Sim").list();
    }

    @Override
    public Sim getSimByNum(String numerotel) {
        return (Sim) sessionFactory.getCurrentSession().get(Sim.class, numerotel);
    }

    @Override
    public void removeSim(String numrtotel) {
        Sim sm = (Sim) sessionFactory.getCurrentSession().load(Sim.class, numrtotel);
              sessionFactory.getCurrentSession().delete(sm);;
    }
   
    
}
