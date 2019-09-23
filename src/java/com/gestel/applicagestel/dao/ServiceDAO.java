/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.model.Option;
import java.util.List;

/**
 *
 * @author Abroun
 */
public interface ServiceDAO {
        public void addService(Option service);
	public void updateService(Option service);
	public List<Option> listServices();
	public Option getServiceById(int idservice);
	public void removeService(int idServics);
        public List<Option> serviceActive(String numero);
}
