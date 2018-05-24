package com.revata.apaza.model;

public class Customer {
	
	int idcustomer;
	String companyname;
	String contactname;
	String contacttitle;
	String address;
	String city;
	String login;
	String password;
	

	/**
	 * 
	 * @param idcustomer
	 * @param companyname
	 * @param contactname
	 * @param contacttitle
	 * @param address
	 * @param city
	 * @param login
	 * @param password
	 */
	
	public Customer(int idcustomer, String companyname, String contactname, String contacttitle, String address,
			String city, String login, String password) {
		super();
		this.idcustomer = idcustomer;
		this.companyname = companyname;
		this.contactname = contactname;
		this.contacttitle = contacttitle;
		this.address = address;
		this.city = city;
		this.login = login;
		this.password = password;
	}
	
	
	
	
	public Customer() {
		super();
	}




	public int getIdcustomer() {
		return idcustomer;
	}
	public void setIdcustomer(int idcustomer) {
		this.idcustomer = idcustomer;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getContacttitle() {
		return contacttitle;
	}
	public void setContacttitle(String contacttitle) {
		this.contacttitle = contacttitle;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "Employee [idcustomer=" + idcustomer + ", companyname=" + companyname + ", contactname=" + contactname
				+ ", contacttitle=" + contacttitle + ", address=" + address + ", city=" + city + ", login=" + login
				+ ", password=" + password + "]";
	}
	
	
	
	
}
