<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>

<html>
	<body>  

	车站为：
      <%
	
        stationDao sdao= new stationDao();
       	ArrayList stations= sdao.queryAllStudents();

		for (int i = 0; i < stations.size(); i++) {
			station station=(station)stations.get(i);

        //if(substation!=null){
        %>
        <% 
        //out.println(subwayLine);
        //out.println(direction);
        out.println(station.getSubwayLine());
        
        }

       %>
  </body>
</html>
