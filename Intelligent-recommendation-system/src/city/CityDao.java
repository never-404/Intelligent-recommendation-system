package city;
import java.sql.*;
import java.util.*;
import city.City;

public class CityDao {
	String datasourceName = "";
	String tableName = "";
	String SQL;
	
	public CityDao(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			System.out.print(e);
		}
	}
	
	public void setDatasourceName(String s){
		datasourceName = s.trim();
	}
	public void setTableName(String s){
		tableName = s.trim();
	}
	public void setSQL(String SQL){
		this.SQL = SQL.trim();
	}
	public String getSQL(){
		return SQL;
	}
	/*
	public void inputQueryResult(){
		City cityflight = new City();
		Connection con;
		Statement sql;
		ResultSet rs;
		try{
			String url = "jdbc:mysql://localhost:3306/project?characterEncoding=utf8&useSSL=true";
			String id = "root";
			String password = "123456";
			//con = DriverManager.getConnection(url,id,password);
			con = DriverManager.getConnection(url, "root", "123456");
			DatabaseMetaData metadata = con.getMetaData();
			ResultSet rsl = metadata.getColumns(null, null, tableName, null);
			int StrNum = 0;
			while(rsl.next()){
				StrNum++;
			}
			sql = con.createStatement();
			rs = sql.executeQuery(getSQL());
			while(rs.next()){
				for(int k=1;k<=StrNum;k++){
					System.out.print("   "+rs.getString(k)+"   ");
				}
				System.out.println("");
			}
			con.close();
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
	*/
	public ArrayList inputQueryFlight(){
		ArrayList cityflights= new ArrayList();
		
		Connection con;
		Statement sql;
		ResultSet rs;
		try{
			
			String url = "jdbc:mysql://localhost:3306/project?characterEncoding=utf8&useSSL=true";
			String id = "root";
			String password = "123456";
			con = DriverManager.getConnection(url,id,password);
			//con = DriverManager.getConnection(url, "root", "123456");
			DatabaseMetaData metadata = con.getMetaData();
			ResultSet rsl = metadata.getColumns(null, null, tableName, null);
			int StrNum = 0;
			while(rsl.next()){
				StrNum++;
			}
			sql = con.createStatement();
			rs = sql.executeQuery(getSQL());
			while(rs.next()){
				while (rs.next()) {
	                //ÊµÀý»¯VO
					City cityflight = new City();
					cityflight.setFlight(rs.getString("º½°à"));
					//student.setStuname(rs.getString("STUNAME"));
					System.out.println(" cityflight  "+cityflight.Flight()+"   ");
					cityflights.add(cityflight);
				}
				
			}
			con.close();
		}
		catch(SQLException e){
			System.out.println(e);
		}
		return cityflights;
	}
}
