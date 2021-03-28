package model;

public class CustomerVO {
	private String cust_name;
	private String cust_id;
	private String cust_pass;
	private String bookable;
	
	
	
	public CustomerVO() {
		super();
	}



	public CustomerVO(String cust_name, String cust_id, String cust_pass, String bookable) {
		super();
		this.cust_name = cust_name;
		this.cust_id = cust_id;
		this.cust_pass = cust_pass;
		this.bookable = bookable;
	}



	public String getCust_name() {
		return cust_name;
	}



	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}



	public String getCust_id() {
		return cust_id;
	}



	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}



	public String getCust_pass() {
		return cust_pass;
	}



	public void setCust_pass(String cust_pass) {
		this.cust_pass = cust_pass;
	}



	public String isBookable() {
		return bookable;
	}



	public void setBookable(String bookable) {
		this.bookable = bookable;
	}



	public String getBookable() {
		return bookable;
	}
	
	
}
