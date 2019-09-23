/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.controller;

import com.gestel.applicagestel.model.Employee;
import com.gestel.applicagestel.model.Option;
import com.gestel.applicagestel.model.Sim;
import com.gestel.applicagestel.service.EmployeeService;
import com.gestel.applicagestel.service.ServiceService;
import com.gestel.applicagestel.service.SimService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Abroun
 */
@Controller
public class SimController {
    @Autowired
    private SimService simService;
    
    @Qualifier("simService")
    
     public void setSimservice(SimService simService) {
        this.simService = simService;
    }
    
    @Autowired
    private ServiceService serviceService;
    
    @Qualifier("serviceService")
    
     public void setSimservice(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
     
    @Autowired
    private EmployeeService employeeService;

   
    
    @Qualifier("employeeService")
   public void setEmployeeService(EmployeeService employeeService1) {
        this.employeeService = employeeService1;
    }
    //
    
    
    @RequestMapping(value = "/sims", method = RequestMethod.GET)
	public String listSims(Model model1,Model model2) {
		model1.addAttribute("sim", new Sim());
		model1.addAttribute("listSims", this.simService.listSims());
                
		List<Employee> employees = employeeService.listEmployees();
                model2.addAttribute("listEmployees",employees);
		return "simcarte";
	}

    //ajout et update
    @RequestMapping(value="/sim/add",method= RequestMethod.POST)
    public String addSim(@ModelAttribute("sim") Sim sm,@RequestParam("employee.idpersonne") Integer idp){
       System.out.println("Num sim=" + sm.getNumerotel()+ "serie"+ sm.getSeriesim());
       
       String num = sm.getNumerotel();
        Sim simgeted=simService.getSimByNum(num);
        System.out.println("Num sim frombase=" + simgeted.getNumerotel()+ "serie"+ simgeted.getSeriesim());
      if(simgeted!=null){
           
                      //existing employee, call update
			this.simService.updateSim(sm);  
			
		}else{
			//new person, add it
			
                      Employee emp = employeeService.getEmployeeById(idp);
                        // Departement dp=emp.getDepartement();
           // Departement dp = departementService.getDepartementById(emp.getDepartement());
                       sm.setEmployee(emp);
                       this.simService.addSim(sm);
                         
                      
		}
		
		return "redirect:/sims";
    }
    
   @RequestMapping("/edit_sim/{num}")
    public String editSim(@PathVariable String num, Model model){
        model.addAttribute("sim", this.simService.getSimByNum(num));
        model.addAttribute("listSims", this.simService.listSims());
        List<Employee> employees = employeeService.listEmployees();
       
        model.addAttribute("listEmployees",employees);
        int simedit=1;
        model.addAttribute("varedit",simedit);
        Sim sm = simService.getSimByNum(num);
        Employee emp =sm.getEmployee();
        Integer idpph=emp.getIdpersonne();
        //Departement departementSauvgarder =departementService.getDepartementById(employeeService.getEmployeeById(id)) ;
        model.addAttribute("employeeSauvagrde",emp);
       return "simcarte";
}
   @RequestMapping("/remove_sim/{num}")
    public String removeSim(@PathVariable String num){
		
        this.simService.removeSim(num);
        return "redirect:/sims";
    }
   @RequestMapping(value="/service_sim", method = RequestMethod.GET)
    public String servicemenu(Model model){
       model.addAttribute("sim",new Sim());
      // model.addAttribute("option",new Option());
       
       return "service_menu";
   }
   
   @RequestMapping("/search_sim")
   public String searchSim(@RequestParam("numerotel") String numerosearch,Model model){
       model.addAttribute("simsearch",this.simService.getSimByNum(numerosearch));
       model.addAttribute("sim",this.simService.getSimByNum(numerosearch));
       //Option op=new Option();
       model.addAttribute("option",new Option());
       model.addAttribute("optionsNum",this.serviceService.serviceActive(numerosearch));
       List<Option> options = serviceService.listServices();
       model.addAttribute("optionsToActivt", options);
       return "service_menu";
       
      }
   
   @RequestMapping("/attribut_service")
   public String attribuerOpToSim(@RequestParam("idService") int idserv,Model model){
       Option op =this.serviceService.getServiceById(idserv);
       
       
     return "service_menu";  
   }
}