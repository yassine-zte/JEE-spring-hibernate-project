/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.controller;

import com.gestel.applicagestel.model.Option;
import com.gestel.applicagestel.service.ServiceService;
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
public class OptionController {
    @Autowired
    private ServiceService serviceService;
    
    @Qualifier("serviceService")
    
     public void setServiceservice(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
     
    
   
    
    
    //
    
    
    @RequestMapping(value = "/services", method = RequestMethod.GET)
	public String listSims(Model model1,Model model2) {
		model1.addAttribute("service", new Option());
		model1.addAttribute("listServices", this.serviceService.listServices());
                
		return "option";
	}

    //ajout et update
    @RequestMapping(value="/service/add",method= RequestMethod.POST)
    public String addService(@ModelAttribute("service") Option sv){
       System.out.println("Num service=" + sv.getIdservice()+ "serie"+ sv.getNomService());
       
         Integer ids = sv.getIdservice();
        /*Service simgeted=serviceService.getServiceByNum(num);
        * System.out.println("Num sim frombase=" + simgeted.getNumerotel()+ "serie"+ simgeted.getSeriesim());
        */
        if(ids!=null){
           
                      //existing employee, call update
			this.serviceService.updateService(sv);  
			
		}else{
			//new person, add it
			
                     // Employee emp = employeeService.getEmployeeById(idp);
                        // Departement dp=emp.getDepartement();
           // Departement dp = departementService.getDepartementById(emp.getDepartement());
                      // sm.setEmployee(emp);
                       this.serviceService.addService(sv);
                         
                      
		}
		
		return "redirect:/services";
    }
    
   @RequestMapping("/edit_service/{id}")
    public String editService(@PathVariable int id, Model model){
        model.addAttribute("service", this.serviceService.getServiceById(id));
        model.addAttribute("listServices", this.serviceService.listServices());
        //List<Employee> employees = employeeService.listEmployees();
       
        //model.addAttribute("listEmployees",employees);
        //int simedit=1;
       // model.addAttribute("varedit",simedit);
        Option sv = serviceService.getServiceById(id);
        //Employee emp =sm.getEmployee();
        //Integer idpph=emp.getIdpersonne();
        //Departement departementSauvgarder =departementService.getDepartementById(employeeService.getEmployeeById(id)) ;
        model.addAttribute("employeeSauvagrde",sv);
       return "option";
}
   @RequestMapping("/remove_service/{id}")
    public String removeService(@PathVariable int id){
		
        this.serviceService.removeService(id);
        return "redirect:/services";
    }
    
    
}
