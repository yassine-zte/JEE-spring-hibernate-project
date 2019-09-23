/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.service;

import com.gestel.applicagestel.dao.EmployeeDAO;
import com.gestel.applicagestel.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import javax.annotation.ManagedBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abroun
 */
@Service("employeeService")
//@ManagedBean("employeeService")

public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
      employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return employeeDAO.listEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int idpersonne) {
        return employeeDAO.getEmployeeById(idpersonne);
    }

    @Override
    @Transactional
    public void removeEmployee(int idpersonne) {
        employeeDAO.removeEmployee(idpersonne);
    }
    
}
