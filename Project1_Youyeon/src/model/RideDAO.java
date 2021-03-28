package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class RideDAO {
	
	//���̵��� ��ü �ü� ��ȸ
	public List<RideVO> showAllRides(){
		List<RideVO> rList = new ArrayList<RideVO>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select *  "
				+ "from rides";
		conn = DBUtil.getConnection();
		try {
			st=conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				RideVO ride = makeRide(rs);
				rList.add(ride);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.DBClose(rs, st, conn);
		}
		return rList;
	}
	
	//���డ���� ���̱ⱸ ��ȸ
	public List<RideVO> showBookableRides(){
		List<RideVO> rList = new ArrayList<RideVO>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * \r\n"
				+ "from rides\r\n"
				+ "where waiting_time <= 60";
		conn = DBUtil.getConnection();
		try {
			st=conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				RideVO ride = makeRide(rs);
				rList.add(ride);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.DBClose(rs, st, conn);
		}
		return rList;
	}
	
	
	
	private RideVO makeRide(ResultSet rs) throws SQLException {
		RideVO ride = new RideVO();
		ride.setHeadcount(rs.getInt("headcount"));
		ride.setRide_capacity(rs.getInt("ride_capacity"));
		ride.setRide_name(rs.getString("ride_name"));
		ride.setRide_number(rs.getInt("ride_number"));
		ride.setOpen_close(rs.getString("open_close"));
		ride.setWating_time(rs.getInt("waiting_time"));
		ride.setRide_time(rs.getInt("ride_time"));
		return ride;
		
	}
}
