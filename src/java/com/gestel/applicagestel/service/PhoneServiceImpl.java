/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.service;

import com.gestel.applicagestel.dao.PhoneDAO;
import com.gestel.applicagestel.model.Phone;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Abroun
 */
@Service("phoneService")
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    private PhoneDAO phoneDAO;

    public void setPhoneDAO(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }
    
    

    @Override
      @Transactional
    public void addPhone(Phone phone) {
        this.phoneDAO.addPhone(phone);
    }

    @Override
      @Transactional
    public void updatePhone(Phone phone) {
        this.phoneDAO.updatePhone(phone);
    }

    @Override
      @Transactional
    public List<Phone> listPhones() {
        return phoneDAO.listPhones();
    }

    @Override
      @Transactional
    public Phone getPhoneById(int idphone) {
        return phoneDAO.getPhoneById(idphone);
    }

    @Override
    @Transactional
    public void removePhone(int idphone) {
        this.phoneDAO.removePhone(idphone);
    }
    
}
