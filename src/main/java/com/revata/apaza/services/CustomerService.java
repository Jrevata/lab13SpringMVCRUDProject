package com.revata.apaza.services;

import java.util.List;

import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;

import org.springframework.dao.EmptyResultDataAccessException;

import com.revata.apaza.exception.DAOException;
import com.revata.apaza.exception.EmptyResultException;
import com.revata.apaza.model.Customer;

public interface CustomerService {
	
	Customer find(int employee_id) throws DAOException, EmptyResultDataAccessException;
	
	List<Customer> findAll()throws DAOException, EmptyResultException;
}
