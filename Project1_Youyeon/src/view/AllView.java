package view;

import java.util.List;
import java.util.Scanner;

import model.BookingDAO;
import model.BookingVO;
import model.CustomerDAO;
import model.RideDAO;
import model.RideVO;

public class AllView {
	
	//메뉴화면
	public int menuDisplay() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==============놀이동산에 오신걸 환영합니다=============");
		System.out.println("1.로그인");
		System.out.println("2.예약");
		System.out.println("3.예약확인");
		System.out.println("4.놀이공원 이용시설");
		System.out.println("5.모든예약 확인");
		
		System.out.println("================================================");
		System.out.print("원하시는 항목의 번호를 입력해주세요>>");
		int no = sc.nextInt();
		return no;
		
		
		
	}
	//로그인 화면
	public void loginDisplay() {
		CustomerDAO customer = new CustomerDAO();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("=============로그인=============");
		System.out.println("ID : ");
		String id = sc.next();
		System.out.println("Password : ");
		String pass = sc.next();
		
		int result = customer.customerLogin(id,pass);
		
		printmessage(result>0 ? "로그인에 성공하였습니다.":"로그인에 실패하였습니다.\n다시 시도해주세요");
		
		
	}
	
	//예약
	public void bookingDisplay() {
		RideDAO ride = new RideDAO();
		BookingDAO booking = new BookingDAO();
		System.out.println("=========현재 예약가능한 놀이기구===========");
		facilitiesListDisplay(ride.showBookableRides());
		int result = booking.booking();
		printmessage(result>0 ? "예약에 성공하였습니다.":"예약에 실패하였습니다.\n다시 시도해주세요");
	}
	
	//예약확인
	public void yourBookingDisplay() {
		BookingDAO booking = new BookingDAO();
		Scanner sc =new Scanner(System.in);
		String cust_id="";
		System.out.println("고객님의 아이디를 입력해주세요 >>");
		cust_id =sc.next();
		System.out.println("=========="+cust_id+"님의 예약현황==========");
		booking.checkingReservation(cust_id);
		
	}
	
	//놀이공원 시설리스트
	public void facilitiesListDisplay(List<RideVO> rlist) {
		System.out.println("==========이용가능한 모든 시설을 확인해보세요===========");
		for (RideVO ride : rlist) {
			System.out.println(ride);
			System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		}
	}
	
	public void bookingListDisplay(List<BookingVO> rlist) {
		System.out.println("==========모든 예약확인===========");
		for (BookingVO ride : rlist) {
			System.out.println(ride);
			System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		}
	}
	
	//메세지 출력
	public void printmessage(String message) {
		System.out.println("=======메세지=======");
		System.out.println(message);
	}

	 
}
