<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>

<html>
	<body>  

	车站为：
      <%
	
        stationDao sdao= new stationDao();
       	ArrayList stations= sdao.queryAllStudents();
		%>
		<table border=2>
			<tr>
				<td>地铁线</td>
				<td>方向</td>
				<td>车站</td>
				<td>首车时间</td>
				<td>末车时间</td>
			</tr>
		<%
		for (int i = 0; i < stations.size(); i++) {
			station station=(station)stations.get(i);
		%>
			<tr>
				<td><%=station.getSubwayLine()%></td>
			</tr>
			<%
				}
        	%>

  </body>
</html>
