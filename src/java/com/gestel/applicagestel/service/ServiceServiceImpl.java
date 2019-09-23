/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.service;

import com.gestel.applicagestel.dao.ServiceDAO;
import com.gestel.applicagestel.model.Option;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Abroun
 */
@Service("serviceService") 
public class ServiceServiceImpl implements  ServiceService{
     @Autowired
     private ServiceDAO serviceDAO;

    public void setServiceDAO(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }
     
    @Override
    @Transactional
    public void addService(Option service) {
        this.serviceDAO.addService(service);
    }

    @Override
    @Transactional
    public void updateService(Option service) {
        this.serviceDAO.updateService(service);
    }

   @Override
    @Transactional
    public List<Option> listServices() {
        return serviceDAO.listServices();
    }

    @Override
    @Transactional
    public Option getServiceById(int idservice) {
        return serviceDAO.getServiceById(idservice);
    }

    @Override
    @Transactional
    public void removeService(int idservice) {
        serviceDAO.removeService(idservice);
    }

    @Override
    @Transactional
    public List<Option> serviceActive(String numero) {
        return serviceDAO.serviceActive( numero);
    }
    
    
}
