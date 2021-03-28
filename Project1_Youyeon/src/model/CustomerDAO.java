package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
import view.AllView;

public class CustomerDAO {

	//로그인 (memebers -> customers)
	//입력
		public int customerLogin(String cust_id,String cust_pass)  {
			int result = 0;
			Connection conn = null;
			PreparedStatement st =null;
			ResultSet rs =null;
			String sql ="insert into customers(cust_name,cust_id,cust_pass)\r\n"
					+ "select cust_name,cust_id,cust_pass\r\n"
					+ "from members\r\n"
					+ "where members.cust_id = ? \r\n"
					+ "and members.cust_pass = ?";
			conn= DBUtil.getConnection();
		
			try {
				st= conn.prepareStatement(sql);
				st.setString(1, cust_id);
				st.setString(2, cust_pass);
				result = st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.DBClose(rs, st, conn);
			}
			
			return result;
			
			
		}
		
		//로그인 확인
		public boolean checkLogin(String cust_id) {
			Connection conn=null;
			PreparedStatement st =null;
			ResultSet rs =null;
			String sql = "select count(*)\r\n"
					+ "from customers\r\n"
					+ "where cust_id = ?";
			conn =DBUtil.getConnection();
			try {
				st=conn.prepareStatement(sql);
				st.setString(1,cust_id);
				rs = st.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.DBClose(rs, st, conn);
			}
			
			if(rs==null) {
				System.out.println("로그인이 필요한 서비스입니다.");
				return false;
			}
			else return true;
		}
		
		//예약가능한지 확인
		public boolean bookableCheck(String cust_id) {
			Connection conn=null;
			PreparedStatement st =null;
			ResultSet rs =null;
			CustomerVO customerVo = new CustomerVO();
			AllView view =new AllView();
			String sql="select bookable\r\n"
					+ "from customers\r\n"
					+ "where cust_id = ?";
			String temp="";
			conn =DBUtil.getConnection();
			try {
				st=conn.prepareStatement(sql);
				st.setString(1,cust_id);
				rs = st.executeQuery();
				while(rs.next()) {
				customerVo.setBookable(rs.getString("bookable"));
				temp =customerVo.getBookable();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.DBClose(rs, st, conn);
			}
			
			if(temp.equals("1"))
				return true;
			else {
				view.printmessage("이미 예약하셨습니다.");
				return false;
			}
			
		}
}
