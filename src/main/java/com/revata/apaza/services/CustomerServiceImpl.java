package com.revata.apaza.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revata.apaza.dao.CustomerDAO;
import com.revata.apaza.exception.DAOException;
import com.revata.apaza.exception.EmptyResultException;
import com.revata.apaza.model.Customer;


@Service("employeeService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO employeeDAO;
	
	public Customer find(int employee_id) throws DAOException{
		Customer emp = null;
		try {
			emp = employeeDAO.findCustomer(employee_id);
		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	
	public List<Customer> findAll()throws DAOException, EmptyResultException{
		List<Customer> emps = employeeDAO.findAllCustomers();
		return emps;
	}
	
}
