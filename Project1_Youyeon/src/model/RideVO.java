package model;

import java.sql.Date;

public class RideVO {
	private int ride_number;//놀이기구 고유번호
	private String ride_name;//놀이기구 이름
	private String open_close;//놀이기구 운영시간
	private int waiting_time;//예상대기시간
	private int headcount;//대기인원
	private int ride_capacity;//최대탑승인원
	private int ride_time;//놀이기구 1회 운행 시간
	
	
	public RideVO() {
		super();
	}



	public RideVO(int ride_number, String ride_name, String open_close, int waiting_time, int headcount,
			int ride_capacity, int ride_time) {
		super();
		this.ride_number = ride_number;
		this.ride_name = ride_name;
		this.open_close = open_close;
		this.waiting_time = waiting_time;
		this.headcount = headcount;
		this.ride_capacity = ride_capacity;
		this.ride_time = ride_time;
	}




	


	public int getRide_time() {
		return ride_time;
	}



	public void setRide_time(int ride_time) {
		this.ride_time = ride_time;
	}



	public int getRide_number() {
		return ride_number;
	}



	public void setRide_number(int ride_number) {
		this.ride_number = ride_number;
	}



	public String getRide_name() {
		return ride_name;
	}



	public void setRide_name(String ride_name) {
		this.ride_name = ride_name;
	}



	public String getOpen_close() {
		return open_close;
	}



	public void setOpen_close(String open_close) {
		this.open_close = open_close;
	}



	public int getWating_time() {
		return waiting_time;
	}



	public void setWating_time(int waiting_time) {
		this.waiting_time = waiting_time;
	}



	public int getHeadcount() {
		return headcount;
	}



	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}



	public int getRide_capacity() {
		return ride_capacity;
	}



	public void setRide_capacity(int ride_capacity) {
		this.ride_capacity = ride_capacity;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(ride_number).append("] :").append(ride_name)
				.append("\n\t"+" -운영시간 : ").append(open_close).append("까지 \n\t -예상대기시간 : ").append(waiting_time)
				.append("분 \n\t -현재 대기인원 : ").append(headcount).append("명 \n\t -최대탑승인원 : ").append(ride_capacity)
				.append("명 \n\t -탑승시간 : ").append(ride_time).append("분");
		return builder.toString();
	}
	
	
}
