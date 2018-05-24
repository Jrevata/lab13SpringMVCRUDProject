package com.revata.apaza.dao;

import com.revata.apaza.exception.DAOException;
import com.revata.apaza.exception.EmptyResultException;
import com.revata.apaza.exception.LoginException;
import com.revata.apaza.mapper.CustomerMapper;
import com.revata.apaza.model.Customer;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;



	public Customer findCustomer(int idcustomer) throws DAOException, EmptyResultException {

		String query = "SELECT idcustomer, login, password, companyname, contactname, contacttitle, address,city "
				+ " FROM customers WHERE idcustomer = ?";

		Object[] params = new Object[] { idcustomer };

		try {

			Customer emp = (Customer) jdbcTemplate.queryForObject(query, params, new CustomerMapper());
			//
			return emp;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	
	public void create(String login, String password, String companyname, String contactname, String contacttitle, String address, String city) throws DAOException {

		String query = "INSERT INTO customers (login, password, companyname, contactname, contacttitle, address,city)  VALUES ( ?,?,?,?,?,?,? )";

		Object[] params = new Object[] { login, password, companyname, contactname, contacttitle, address,city };

		Customer emp = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			emp = this.findCustomerByLogin(login);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}

	
	public void delete(String login) throws DAOException {

		String query = "DELETE FROM  customers WHERE login = ? ";

		Object[] params = new Object[] { login };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	
	public void update(String login, String password, String companyname, String contactname, String contacttitle, String address, String city) throws DAOException {

		String query = "UPDATE customers SET password = ?, companyname =?, contactname = ?, contacttitle = ?, address = ?, city = ? WHERE login = ?";

		Object[] params = new Object[] { password, companyname, contactname, contacttitle, address,city, login };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	public Customer findCustomerByLogin(String login) throws DAOException, EmptyResultException {

		String query = "SELECT idcustomer, login, password, companyname, contactname, contacttitle, address, city "
				+ " FROM customers WHERE login = ? ";

		Object[] params = new Object[] { login };

		try {

			Customer customer = jdbcTemplate.queryForObject(query, params, new CustomerMapper());
			//
			return customer;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	public List<Customer> findAllCustomers() throws DAOException, EmptyResultException {

		String query = "SELECT idcustomer, login, password, companyname, contactname, contacttitle, address, city FROM customers ";

		try {

			List<Customer> customers = jdbcTemplate.query(query, new CustomerMapper());
			//
			return customers;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	public List<Customer> findCustomersByName(String contactname) throws DAOException, EmptyResultException {

		String query = "SELECT idcustomer, login, password, companyname, contactname, contacttitle, address, city "
				+ " FROM customers WHERE upper(contactname) like upper(?) ";

		Object[] params = new Object[] { "%" + contactname + "%" };

		try {

			List<Customer> customers = jdbcTemplate.query(query, params, new CustomerMapper());
			//
			return customers;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	public Customer validate(String login, String pwd) throws DAOException, LoginException {
	
		logger.info("validate(): login: " + login + ", clave: " + pwd);
	
		if ("".equals(login) && "".equals(pwd)) {
			throw new LoginException("Login and password incorrect");
		}
	
		String query = "SELECT login, password, idcustomer, companyname, contactname, contacttitle, address,city  "
				+ " FROM customers WHERE login=? AND password=?";
	
		Object[] params = new Object[] { login, pwd };
	
		try {
	
			Customer emp = (Customer) jdbcTemplate.queryForObject(query, params, new CustomerMapper());
			//
			return emp;
	
		} catch (EmptyResultDataAccessException e) {
			logger.info("Customer y/o clave incorrecto");
			throw new LoginException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	

}
