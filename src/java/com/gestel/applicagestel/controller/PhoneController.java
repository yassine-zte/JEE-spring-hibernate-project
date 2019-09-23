package com.gestel.applicagestel.controller;

import com.gestel.applicagestel.model.Employee;
import com.gestel.applicagestel.model.Phone;
import com.gestel.applicagestel.service.EmployeeService;
import com.gestel.applicagestel.service.PhoneService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author Abroun
 */
@Controller
public class PhoneController {
    
    @Autowired
    private PhoneService phoneService;
    
    @Qualifier("phoneService")
    
     public void setPhoneservice(PhoneService phoneservice) {
        this.phoneService = phoneService;
    }
     
    @Autowired
    private EmployeeService employeeService;

   
    
    @Qualifier("employeeService")
   public void setEmployeeService(EmployeeService employeeService1) {
        this.employeeService = employeeService1;
    }
    //
    
    
    @RequestMapping(value = "/phones", method = RequestMethod.GET)
	public String listPhones(Model model1,Model model2) {
		model1.addAttribute("phone", new Phone());
		model1.addAttribute("listPhones", this.phoneService.listPhones());
                
		List<Employee> employees = employeeService.listEmployees();
                model2.addAttribute("listEmployees",employees);
		return "phone";
	}

    //ajout et update
    @RequestMapping(value="/phone/add",method= RequestMethod.POST)
    public String addPhone(@ModelAttribute("phone") Phone ph,@RequestParam("employee.idpersonne") Integer idp){
       System.out.println("Myid phone=" + ph.getIdphone()+ "nom"+ ph.getMarque());
       
       Integer idvar = ph.getIdphone();
      if(idvar==null){
           //new person, add it
			
                      Employee emp = employeeService.getEmployeeById(idp);
                        // Departement dp=emp.getDepartement();
           // Departement dp = departementService.getDepartementById(emp.getDepartement());
                       ph.setEmployee(emp);
                       this.phoneService.addPhone(ph);
                       
			
		}else{
			
                          //existing employee, call update
			this.phoneService.updatePhone(ph);
                       
		}
		
		return "redirect:/phones";
    }
    
   @RequestMapping("/edit_phone/{id}")
    public String editPerson(@PathVariable int id, Model model){
        model.addAttribute("phone", this.phoneService.getPhoneById(id));
        model.addAttribute("listPhones", this.phoneService.listPhones());
        List<Employee> employees = employeeService.listEmployees();
        model.addAttribute("listEmployees",employees);
        Phone ph = phoneService.getPhoneById(id);
        Employee emp =ph.getEmployee();
        Integer idpph=emp.getIdpersonne();
        //Departement departementSauvgarder =departementService.getDepartementById(employeeService.getEmployeeById(id)) ;
        model.addAttribute("employeeSauvagrde",emp);
       return "phone";
}
   @RequestMapping("/remove_phone/{id}")
    public String removePhone(@PathVariable Integer id){
		
        this.phoneService.removePhone(id);
        return "redirect:/phones";
    }
    
}
