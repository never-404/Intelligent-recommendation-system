package DAO;
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
	}
}
