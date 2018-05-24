package com.revata.apaza.control;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.revata.apaza.exception.DAOException;
import com.revata.apaza.exception.LoginException;
import com.revata.apaza.model.Customer;
import com.revata.apaza.services.SecurityService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private SecurityService sercurityService;
	
	@GetMapping("/login")
	public ModelAndView preLogin() {
		Customer emp = new Customer();
		return new ModelAndView("login" , "command" , emp);
	}
	
	@PostMapping("'login")
	public ModelAndView login(@ModelAttribute("SpringWeb") Customer employee, ModelMap model) {
		logger.info("login()");
		logger.info(employee.toString());
		
		ModelAndView modelAndView = null;
		
		try {
			Customer emp = sercurityService.validate(employee.getLogin(),employee.getPassword());
			logger.info(emp.toString());
			modelAndView= new ModelAndView("redirect:/admin/inicio","command","emp");
		}catch(LoginException e) {
			model.addAttribute("message" , "Usuario y/o clave inválidos");
			modelAndView = new ModelAndView("login" , "command" , new Customer());
		}catch(DAOException e){
			model.addAttribute("message" , e.getMessage());
			modelAndView = new ModelAndView("login" , "command" , new Customer());
		}
		
		return modelAndView;
	}
	
}
