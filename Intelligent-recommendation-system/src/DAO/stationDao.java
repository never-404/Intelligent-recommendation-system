package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javabean.station;


public class stationDao {
	Connection conn = null;
	public ArrayList queryAllStudents() throws Exception {

		ArrayList stations= new ArrayList();
			//获取连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/subway_database?serverTimezone=GMT","root","123456");
			// 运行SQL语句
			String sql = "SELECT 车站,方向 from 北京地铁时刻表";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
                //实例化VO
				station station = new station();
				station.setSubwayLine(rs.getString("STUNO"));
				stations.add(station);
			}
			  closeConnection();
		return stations;
		} 

		

	public void closeConnection() throws Exception{
		  conn.close();
	}
}





