/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.service;

import com.gestel.applicagestel.model.Departement;
import com.gestel.applicagestel.model.Employee;
import java.util.List;

/**
 *
 * @author Abroun
 */
public interface DepartementService {
    public void addDepartement(Departement departement);
	public void updateDepartement(Departement departement);
	public List<Departement> listDepartements();
	public Departement getDepartementById(int idDepartement);
	public void removeDepartement(int idDepartement);
        public void addPersonnes(List<Employee> employees);
}
