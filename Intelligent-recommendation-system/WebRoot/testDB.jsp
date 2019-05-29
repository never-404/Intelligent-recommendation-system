<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>
<%@ page import= "servlet.Subway"%>

<html>
	<body>  

	车站为：
      <%
		String station1 = request.getParameter("account");
        stationDao sdao= new stationDao();
       	ArrayList stations= sdao.queryAllStations(station1);
       	//out.println(station1);
		%>
		<table border=2>
			<tr>
				<td>地铁线</td>
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
				<td><%=station.getStation()%></td>
				<td><%=station.getEndTime()%></td>
				<td><%=station.getStartTime()%></td>

			</tr>
			<%
				}
        	%>
        	
        <%
        for(int j = 0;j<20;j++){
				//out.print(RouteNum[j]+"号线"+Route[j]+"->");
			}
        
         %>

  </body>
</html>
