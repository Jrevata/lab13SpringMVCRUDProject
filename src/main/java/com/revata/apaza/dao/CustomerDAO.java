package com.revata.apaza.dao;

import java.util.List;



import com.revata.apaza.exception.DAOException;
import com.revata.apaza.exception.EmptyResultException;
import com.revata.apaza.exception.LoginException;
import com.revata.apaza.model.Customer;

public interface CustomerDAO {
	
	Customer findCustomer(int id) throws DAOException, EmptyResultException;

	void create(String login, String password, String companyname, String contactname, String contacttitle, String address, String city) throws DAOException;

	void delete(String login) throws DAOException;

	void update(String login, String password,  String companyname, String contactname, String contacttitle, String address, String city) throws DAOException;

	Customer findCustomerByLogin(String login) throws DAOException, EmptyResultException;

	List<Customer> findAllCustomers() throws DAOException, EmptyResultException;

	List<Customer> findCustomersByName(String contactname) throws DAOException, EmptyResultException;

	Customer validate(String idCustomer, String clave) throws LoginException, DAOException;
	

}