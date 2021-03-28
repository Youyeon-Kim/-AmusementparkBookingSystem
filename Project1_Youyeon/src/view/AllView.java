package view;

import java.util.List;
import java.util.Scanner;

import model.BookingDAO;
import model.BookingVO;
import model.CustomerDAO;
import model.RideDAO;
import model.RideVO;

public class AllView {
	
	//�޴�ȭ��
	public int menuDisplay() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==============���̵��꿡 ���Ű� ȯ���մϴ�=============");
		System.out.println("1.�α���");
		System.out.println("2.����");
		System.out.println("3.����Ȯ��");
		System.out.println("4.���̰��� �̿�ü�");
		System.out.println("5.��翹�� Ȯ��");
		
		System.out.println("================================================");
		System.out.print("���Ͻô� �׸��� ��ȣ�� �Է����ּ���>>");
		int no = sc.nextInt();
		return no;
		
		
		
	}
	//�α��� ȭ��
	public void loginDisplay() {
		CustomerDAO customer = new CustomerDAO();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("=============�α���=============");
		System.out.println("ID : ");
		String id = sc.next();
		System.out.println("Password : ");
		String pass = sc.next();
		
		int result = customer.customerLogin(id,pass);
		
		printmessage(result>0 ? "�α��ο� �����Ͽ����ϴ�.":"�α��ο� �����Ͽ����ϴ�.\n�ٽ� �õ����ּ���");
		
		
	}
	
	//����
	public void bookingDisplay() {
		RideDAO ride = new RideDAO();
		BookingDAO booking = new BookingDAO();
		System.out.println("=========���� ���డ���� ���̱ⱸ===========");
		facilitiesListDisplay(ride.showBookableRides());
		int result = booking.booking();
		printmessage(result>0 ? "���࿡ �����Ͽ����ϴ�.":"���࿡ �����Ͽ����ϴ�.\n�ٽ� �õ����ּ���");
	}
	
	//����Ȯ��
	public void yourBookingDisplay() {
		BookingDAO booking = new BookingDAO();
		Scanner sc =new Scanner(System.in);
		String cust_id="";
		System.out.println("������ ���̵� �Է����ּ��� >>");
		cust_id =sc.next();
		System.out.println("=========="+cust_id+"���� ������Ȳ==========");
		booking.checkingReservation(cust_id);
		
	}
	
	//���̰��� �ü�����Ʈ
	public void facilitiesListDisplay(List<RideVO> rlist) {
		System.out.println("==========�̿밡���� ��� �ü��� Ȯ���غ�����===========");
		for (RideVO ride : rlist) {
			System.out.println(ride);
			System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		}
	}
	
	public void bookingListDisplay(List<BookingVO> rlist) {
		System.out.println("==========��� ����Ȯ��===========");
		for (BookingVO ride : rlist) {
			System.out.println(ride);
			System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		}
	}
	
	//�޼��� ���
	public void printmessage(String message) {
		System.out.println("=======�޼���=======");
		System.out.println(message);
	}

	 
}
