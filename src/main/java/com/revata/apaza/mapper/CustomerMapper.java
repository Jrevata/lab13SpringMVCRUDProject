package com.revata.apaza.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.revata.apaza.model.Customer;

public class CustomerMapper implements RowMapper<Customer>{
	
	
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer emp = new Customer();
		emp.setIdcustomer(rs.getInt("employee_id"));
		emp.setLogin(rs.getString("login"));
		emp.setPassword(rs.getString("password"));
		emp.setCompanyname(rs.getString("companyname"));
		emp.setContactname(rs.getString("contactname"));
		emp.setContacttitle(rs.getString("contacttitle"));
		emp.setAddress(rs.getString("address"));
		emp.setCity(rs.getString("city"));
		
		return emp;
	}
}