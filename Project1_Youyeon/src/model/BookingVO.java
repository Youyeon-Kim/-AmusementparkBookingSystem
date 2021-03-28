package model;

import java.sql.Date;

public class BookingVO {

	private String cust_id; 
	private String ride_number;
	private String booking_time ;
	private Date d_booking_time;
	
	public BookingVO() {
		super();
	}

	




	public BookingVO(String cust_id, String ride_number, String booking_time, Date d_booking_time) {
		super();
		this.cust_id = cust_id;
		this.ride_number = ride_number;
		this.booking_time = booking_time;
		this.d_booking_time = d_booking_time;
	}






	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getRide_number() {
		return ride_number;
	}

	public void setRide_number(String ride_number) {
		this.ride_number = ride_number;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}






	public Date getD_booking_time() {
		return d_booking_time;
	}






	public void setD_booking_time(Date d_booking_time) {
		this.d_booking_time = d_booking_time;
	}






	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("고객 아이디 : ").append(cust_id).append("\n놀이기구 번호 : ").append(ride_number)
				.append("\n탑승예상시간 : ").append(booking_time);
		System.out.println("==================");
		return builder.toString();
	}



	
	
	
	 
}
