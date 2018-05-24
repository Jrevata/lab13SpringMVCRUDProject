package com.revata.apaza.control;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.revata.apaza.model.Customer;
import com.revata.apaza.services.CustomerService;


@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	 @Autowired
	 private CustomerService employeeService;
	 
	 @GetMapping("/admin/menu")
	 public String menu() {
		 return "/admin/inicio";
	 }
	 
	 @GetMapping("/admin/menu/list")
	 public String list(@ModelAttribute("SpringWeb") Customer employee, ModelMap model) {
		 
		 try {
			 model.addAttribute("employees" , employeeService.findAll());
		 }catch(Exception e) {
			 logger.info(e.getMessage());
			 model.addAttribute("message" , e.getMessage());
		 }
		 
		 return "admin/emp/list";
		 
	 }
	 
	 @GetMapping("/{employee_id}")
	 public ModelAndView home(@PathVariable int employee_id, ModelMap model) {
		 
		 ModelAndView modelAndView = null;
		 Customer emp = new Customer();
		 
		 try {
			 emp = employeeService.find(employee_id);
			 logger.info(emp.toString());
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 modelAndView = new ModelAndView("home" , "command" , emp);
		 return modelAndView;
		 
	 }
}
