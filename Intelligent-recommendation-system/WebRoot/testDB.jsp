<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>

<html>
	<body>  

	车站为：
      <%
	
        stationDao sdao= new stationDao();
       	ArrayList substations= sdao.queryAllStudents();

		for (int i = 0; i < substations.size(); i++) {
			station substation=(station)substations.get(i);

        //if(substation!=null){
        %>
        <% 
        //out.println(subwayLine);
        //out.println(direction);
        out.println(substation.getSubwayLine());
        
        }

       %>
  </body>
</html>
