package city;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.management.Query;
import java.util.*;


//连接数据库
class CityDao {

	public ArrayList queryAllStudents() throws Exception {
		Connection conn = null;
		ArrayList cityflights= new ArrayList();
		try {
			//获取连接
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/project";
			conn = DriverManager.getConnection(url, "root", "123456");
			// 运行SQL语句
			String sql = 
					"SELECT *  from 北京到上海航班  WHERE 出发时 = '11:30:00'";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
                //实例化VO
				CityFlight cityflight = new CityFlight();
				cityflight.setDepartureTime(rs.getString("出发时"));
				System.out.println("输出："+cityflight.DepartureTime());
				cityflights.add(cityflight);
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {// 关闭连接
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception ex) {
			}
		}
		return cityflights;
	}
}


//航班
class CityFlight{
	
	private String Flight;
	private String DepartureTime;
	private String DepartureStation;
	private String ArrivalTime;
	private String ArrivalStation;
	private String Price;
	
	
	public String Flight() {
		return Flight;
	}
	public void setFlight(String Flight) {
		this.Flight = Flight;
	}
	
	public String DepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String DepartureTime) {
		this.DepartureTime = DepartureTime;
	}
	
	public String DepartureStation() {
		return DepartureStation;
	}
	public void setDepartureStation(String DepartureStation) {
		this.DepartureStation = DepartureStation;
	}
	
	public String ArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String ArrivalTime) {
		this.ArrivalTime = ArrivalTime;
	}
	
	public String ArrivalStation() {
		return ArrivalStation;
	}
	public void setArrivalStation(String ArrivalStation) {
		this.ArrivalStation = ArrivalStation;
	}
	
	public String Price() {
		return Price;
	}
	public void setPrice(String Price) {
		this.Price = Price;
	}
}


public class City{
	
	
	public static void main(String args[]){
		
		ArrayList cityflights= new ArrayList();
		CityDao query = new CityDao();
		
		
	}
	
}



