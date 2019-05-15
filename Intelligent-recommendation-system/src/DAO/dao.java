package DAO;
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dao {
	public ArrayList queryAllStudents() throws Exception {
		Connection conn = null;
		ArrayList students= new ArrayList();
		try {
			//获取连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/subway_database?serverTimezone=GMT","root","123456");
			// 运行SQL语句
			String sql = "SELECT STUNO,STUNAME from T_STUDENT";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
                //实例化VO
				Student student = new Student();
				student.setStuno(rs.getString("STUNO"));
				student.setStuname(rs.getString("STUNAME"));
				students.add(student);
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
		return students;
=======

 class Student {
	private String stuno;
	private String stuname;
	private String stuschool;
	private String stusex;
	private String stuclass;
	
	
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	
	
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}	
	
	
	public String getStuschool() {
		return stuschool;
	}
	public void setStushcool(String stuschool) {
		this.stuschool = stuschool;
	}	
	
	
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	
	
	public String getStuclass() {
		return stuclass;
	}
	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
>>>>>>> f722b931fba02e1f7d696210e18aadf5a98925fd
	}
}
