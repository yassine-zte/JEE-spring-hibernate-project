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
public interface EmployeeDAO {
    
        public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int idpersonne);
	public void removeEmployee(int idpersonne);
        

    
}
