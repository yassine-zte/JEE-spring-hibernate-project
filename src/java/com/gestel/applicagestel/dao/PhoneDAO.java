/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.model.Phone;
import java.util.List;

/**
 *
 * @author Abroun
 */
public interface PhoneDAO {
        public void addPhone(Phone phone);
	public void updatePhone(Phone phone);
	public List<Phone> listPhones();
	public Phone getPhoneById(int idphone);
	public void removePhone(int idphone);
    
}
