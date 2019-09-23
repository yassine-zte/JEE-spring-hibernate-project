/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.dao;

import com.gestel.applicagestel.model.Departement;
import com.gestel.applicagestel.model.Employee;
import java.util.List;

/**
 *
 * @author Abroun
 */
public interface DepartementDAO {
    public void addDepartement(Departement dp);
	public void updateDepartement(Departement dp);
	public List<Departement> listDepartement();
	public Departement getDepartementById(int id);
	public void removeDepartement(int id);
        public void addPersonnes(List<Employee> employees);
}
