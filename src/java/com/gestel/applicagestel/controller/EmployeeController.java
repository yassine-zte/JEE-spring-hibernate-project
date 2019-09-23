/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.controller;

import com.gestel.applicagestel.model.Departement;
import com.gestel.applicagestel.model.Employee;
import com.gestel.applicagestel.service.DepartementService;
import com.gestel.applicagestel.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Abroun
 */
@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Qualifier("employeeService")

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Autowired
    private DepartementService departementService;
    
    @Qualifier("departementService")

    public void setDepartementService(DepartementService departementService) {
        this.departementService = departementService;
    }
    
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model1,Model model2) {
		model1.addAttribute("employee", new Employee());
		model1.addAttribute("listEmployees", this.employeeService.listEmployees());
                
		List<Departement> departements = departementService.listDepartements();
                model2.addAttribute("listDepartements",departements);
		return "employee";
	}
    // ajout et update
    @RequestMapping(value="/employee/add",method= RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee emp,@RequestParam("departement.iddepartement") Integer idp){
       System.out.println("Myid personne=" + emp.getIdpersonne()+ "nom"+ emp.getNom());
       
       Integer idvar = emp.getIdpersonne();
      if(idvar==null){
           //new person, add it
			
                      Departement dp = departementService.getDepartementById(idp);
                        // Departement dp=emp.getDepartement();
           // Departement dp = departementService.getDepartementById(emp.getDepartement());
                        emp.setDepartement(dp);
                       this.employeeService.addEmployee(emp);
                       
			
		}else{
			
                          //existing employee, call update
			this.employeeService.updateEmployee(emp);
                       
		}
		
		return "redirect:/employees";
    }
    
   @RequestMapping("/edit_employee/{id}")
    public String editPerson(@PathVariable int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listPersons", this.employeeService.listEmployees());
        List<Departement> departements = departementService.listDepartements();
        model.addAttribute("listDepartements",departements);
        Employee emp = employeeService.getEmployeeById(id);
        Departement demp =emp.getDepartement();
        Integer idpem=demp.getIddepartement();
        //Departement departementSauvgarder =departementService.getDepartementById(employeeService.getEmployeeById(id)) ;
        model.addAttribute("departementSauvagrde",demp);
       return "employee";
}
   @RequestMapping("/remove_employee/{id}")
    public String removeEmployee(@PathVariable Integer id){
		
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }
}
