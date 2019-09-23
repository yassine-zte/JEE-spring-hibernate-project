/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.model.Phone;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abroun
 */
@Repository
public class PhoneDAOImpl implements PhoneDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPhone(Phone phone) {
        sessionFactory.getCurrentSession().save(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        sessionFactory.getCurrentSession().update(phone); 
    }

    @Override
    public List<Phone> listPhones() {
        return sessionFactory.getCurrentSession().createQuery("from Phone").list();
    }

    @Override
    public Phone getPhoneById(int idphone) {
        return (Phone) sessionFactory.getCurrentSession().get(Phone.class, idphone);
    }

    @Override
    public void removePhone(int idphone) {
       Phone ph = (Phone) sessionFactory.getCurrentSession().load(Phone.class, idphone);
              sessionFactory.getCurrentSession().delete(ph);
    }
    
}
