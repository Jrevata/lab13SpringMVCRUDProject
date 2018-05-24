package com.revata.apaza.services;



import com.revata.apaza.exception.DAOException;
import com.revata.apaza.exception.LoginException;
import com.revata.apaza.model.Customer;

public interface SecurityService {
	
	Customer validate(String idEmployee, String clave) throws LoginException, DAOException;
	
}
