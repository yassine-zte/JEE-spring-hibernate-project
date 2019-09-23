/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.service;

import com.gestel.applicagestel.model.Sim;
import java.util.List;

/**
 *
 * @author Abroun
 */
public interface SimService {
     public void addSim(Sim sim);
	public void updateSim(Sim sim);
	public List<Sim> listSims();
	public Sim getSimByNum(String numerotel);
	public void removeSim(String numerotel);
    
}
