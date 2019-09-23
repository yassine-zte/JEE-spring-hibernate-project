/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.service;

import com.gestel.applicagestel.dao.DepartementDAO;
import com.gestel.applicagestel.model.Departement;
import com.gestel.applicagestel.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Abroun
 */
@Service("departementService")

public class DepartementServiceImpl implements DepartementService{
    @Autowired
    private DepartementDAO departementDAO;

    public void setDepartementDao(DepartementDAO departementDAO) {
        this.departementDAO = departementDAO;
    }
    

    @Override
    @Transactional
    public void addDepartement(Departement departement) {
        this.departementDAO.addDepartement(departement);
    }

    @Override
    @Transactional
    public void updateDepartement(Departement departement) {
        departementDAO.updateDepartement(departement);
    }

    @Override
    @Transactional
    public List<Departement> listDepartements() {
        return departementDAO.listDepartement();
    }

    @Override
    @Transactional
    public Departement getDepartementById(int idDepartement) {
        return departementDAO.getDepartementById(idDepartement);
    }

    @Override
    @Transactional
    public void removeDepartement(int idDepartement) {
        departementDAO.removeDepartement(idDepartement);
    }

    @Override
    public void addPersonnes(List<Employee> employees) {
        departementDAO.addPersonnes(employees);
    }
    
}
