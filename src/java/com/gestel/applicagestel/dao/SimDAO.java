/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.model.Sim;
import java.util.List;

/**
 *
 * @author Abroun
 */
public interface SimDAO {
    public void addSim(Sim sim);
	public void updateSim(Sim sim);
	public List<Sim> listSims();
	public Sim getSimByNum(String numrtotel);
	public void removeSim(String numrtotel);
    
}
