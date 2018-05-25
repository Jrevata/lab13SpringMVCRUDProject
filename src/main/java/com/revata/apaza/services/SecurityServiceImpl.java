package com.revata.apaza.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revata.apaza.dao.CustomerDAO;
import com.revata.apaza.exception.DAOException;
import com.revata.apaza.exception.LoginException;
import com.revata.apaza.model.Customer;

@Service("sercurityService")
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private CustomerDAO employeeDAO;
	
	public Customer validate(String login, String password)throws LoginException, DAOException{
		Customer emp = null;
		try {
			emp = employeeDAO.validate(login,password);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
}
