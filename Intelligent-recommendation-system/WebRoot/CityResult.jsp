<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="test.AF" %>
<%@ page import= "test.Graph"%>
<%@ page import= "test.Vertex"%>
<%@ page import= "test.Main"%>
<%@ page import= "city.CityDao"%>
<%@ page import= "city.Query"%>


<html>
	<body>  	
	<%
		AF operation = new AF(new Graph(0), 0, 1);  
        operation.getResult(); 
        String resultlines = operation.getResultLine();
       
	 %>
	路线为：<br><%=resultlines%>

	*****************<br>
	
	北京到上海航班1点以后的航班：<br>
	<%
		
		try{
			Query query = new Query();
			CityDao citydao = new CityDao();
			String dataSource = "project";
			String tableName = "北京到上海航班";
			String querysql = "SELECT 航班  FROM  北京到上海航班   WHERE 出发时 > '1:00:00';";
			String SQL;
			query.setQuerysql(querysql);
			citydao.setDatasourceName(dataSource);
			citydao.setTableName(tableName);
			citydao.setSQL(query.getQuerysql());
			SQL = citydao.getSQL();
			Connection con;
			Statement sql;
			ResultSet rs;
			
			String url = "jdbc:mysql://localhost:3306/project?characterEncoding=utf8&useSSL=true";
			String id = "root";
			String password = "123456";
			//con = DriverManager.getConnection(url,id,password);
			con = DriverManager.getConnection(url, "root", "123456");
			DatabaseMetaData metadata = con.getMetaData();
			ResultSet rsl = metadata.getColumns(null, null, tableName, null);
			int strNum = 0;
			while(rsl.next()){
				strNum++;
			}
			out.print(" strNum：  "+strNum+"   <br>");
			sql = con.createStatement();
			rs = sql.executeQuery(querysql);
			while(rs.next()){
				for(int k=1;k<=strNum;k++){
					out.print(k+"   "+rs.getString(k)+"   ");
				}
				out.println("<br>");
			}
			con.close();
		}
		catch(SQLException e){
			System.out.println(e);
		}
	 %>


  </body>
</html>