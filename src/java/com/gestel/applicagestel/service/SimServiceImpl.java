/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.service;

import com.gestel.applicagestel.dao.SimDAO;
import com.gestel.applicagestel.model.Sim;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Abroun
 */
@Service("simService") 
public class SimServiceImpl implements SimService{
    @Autowired
     private SimDAO simDAO;

    public void setSimDAO(SimDAO simDAO) {
        this.simDAO = simDAO;
    }
    

    @Override
    @Transactional
    public void addSim(Sim sim) {
        this.simDAO.addSim(sim);
    }

    @Override
    @Transactional
    public void updateSim(Sim sim) {
       this.simDAO.updateSim(sim);
    }

    @Override
    @Transactional
    public List<Sim> listSims() {
        return simDAO.listSims();
    }

    @Override
    @Transactional
    public Sim getSimByNum(String numerotel) {
        return simDAO.getSimByNum(numerotel);
    }

    @Override
    @Transactional
    public void removeSim(String numerotel) {
        this.simDAO.removeSim(numerotel);
    }
    
}
