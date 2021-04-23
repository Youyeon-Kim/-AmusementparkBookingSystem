package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import util.DBUtil;
import view.AllView;

public class BookingDAO {
	Connection conn = null;
	PreparedStatement st =null;
	ResultSet rs =null;
	//test 주석
	//test2 주석
	

	//예약 -1.테이블 추가 2.탑승인원 증가(update ,trigger)
	public int booking() {
		
		AllView view = new AllView();
		RideDAO ride = new RideDAO();
		CustomerDAO customer = new CustomerDAO();
		Scanner sc = new Scanner(System.in);
		
		int result=0,no=0;
		String cust_id="";
		
		System.out.println("예약자분의 아이디를 입력해주세요. >>");
		cust_id = sc.next();
		System.out.println("예약하고싶은 놀이기구의 번호를 입력해주세요>>");
		no = sc.nextInt();
		
		if(customer.checkLogin(cust_id)==true&&customer.bookableCheck(cust_id)==true) {
			String sql = "insert into booking(cust_id,ride_number,booking_time,d_booking_time)\r\n"
					+ "select customers.cust_id,rides.ride_number,\r\n"
					+ "TO_CHAR(SYSDATE + (waiting_time+2)/(24*60),'HH:MI'),\r\n"
					+ "SYSDATE + (waiting_time+2)/(24*60)  "
					+ "from customers,rides\r\n"
					+ "where customers.bookable = '1'\r\n"
					+ "and cust_id = ?\r\n"
					+ "and ride_number = ?";
			conn= DBUtil.getConnection();
			try {
				st=conn.prepareStatement(sql);
				st.setString(1,cust_id );
				st.setInt(2, no);
				result = st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.DBClose(rs, st, conn);
			}
			return result;
		}
		else 
			return 0;
		
		
		
	}
	//예상탑승시간 Date 
	public Date calWatingTime(int wating_time) {
		
		return null;
	}
	
	
	//예약확인
	public void checkingReservation(String cust_id) {
		BookingVO bookingVO = new BookingVO();
		String sql="select * from booking where cust_id = ?";
		conn =DBUtil.getConnection();
		try {
			st= conn.prepareStatement(sql);
			st.setString(1, cust_id);
			rs = st.executeQuery();
			while(rs.next()) {
				bookingVO.setBooking_time(rs.getString("booking_time"));
				bookingVO.setCust_id(rs.getString("cust_id"));
				bookingVO.setRide_number(rs.getString("ride_number"));
				if(bookingVO.getRide_number().equals("0")) {
					System.out.println(bookingVO.getCust_id()+"님 티익스프레스 \n 예약시간 :"+bookingVO.getBooking_time());
				}
				else if(bookingVO.getRide_number().equals("1")) {
					System.out.println(bookingVO.getCust_id()+"님 후룸라이드 \n 예약시간 :"+bookingVO.getBooking_time());
				}
				else if(bookingVO.getRide_number().equals("2")) {
					System.out.println(bookingVO.getCust_id()+"님 바이킹 \n 예약시간 :"+bookingVO.getBooking_time());
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.DBClose(rs, st, conn);
		}
		
	}
	//1.예약자 삭제 2. 탑승인원 감소(타이머) 3.대기시간감소
	public void deleteBooking(String ride_number,String cust_id) {
		Timer ride_timer = new Timer();
		String sql = "delete from booking where ride_number = ? "
				+ "and cust_id =?";
		TimerTask ride_task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				conn=DBUtil.getConnection();
				try {
					st=conn.prepareStatement(sql);
					st.setString(1, ride_number);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		};
		ride_timer.schedule(ride_task, 30000);
	}
	//모든예약조회
	
	public List<BookingVO> showAllBooking() {
		List<BookingVO> rList = new ArrayList<BookingVO>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select *  "
				+ "from booking";
		conn = DBUtil.getConnection();
		try {
			st=conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BookingVO booking = makeBooking(rs);
				rList.add(booking);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.DBClose(rs, st, conn);
		}
		return rList;
	}
	private BookingVO makeBooking(ResultSet rs2)throws SQLException {
		BookingVO booking = new BookingVO();
		booking.setBooking_time(rs2.getString("booking_time"));
		booking.setCust_id(rs2.getString("cust_id"));
		booking.setD_booking_time(rs2.getDate("d_booking_time"));
		booking.setRide_number(rs2.getString("ride_number"));
		
		return booking;
		
	}
}
