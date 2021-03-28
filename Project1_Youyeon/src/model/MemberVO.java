package model;

public class MemberVO {
	 private String cust_name;
	 private String cust_id;
	 private String cust_pass;
	public MemberVO(String cust_name, String cust_id, String cust_pass) {
		super();
		this.cust_name = cust_name;
		this.cust_id = cust_id;
		this.cust_pass = cust_pass;
	}
	public MemberVO() {
		super();
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
	 
	
}
