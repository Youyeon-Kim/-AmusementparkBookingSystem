package model;

import java.sql.Date;

public class RideVO {
	private int ride_number;//���̱ⱸ ������ȣ
	private String ride_name;//���̱ⱸ �̸�
	private String open_close;//���̱ⱸ ��ð�
	private int waiting_time;//������ð�
	private int headcount;//����ο�
	private int ride_capacity;//�ִ�ž���ο�
	private int ride_time;//���̱ⱸ 1ȸ ���� �ð�
	
	
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
				.append("\n\t"+" -��ð� : ").append(open_close).append("���� \n\t -������ð� : ").append(waiting_time)
				.append("�� \n\t -���� ����ο� : ").append(headcount).append("�� \n\t -�ִ�ž���ο� : ").append(ride_capacity)
				.append("�� \n\t -ž�½ð� : ").append(ride_time).append("��");
		return builder.toString();
	}
	
	
}
