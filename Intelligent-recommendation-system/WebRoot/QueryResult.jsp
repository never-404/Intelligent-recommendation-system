<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="test.AF" %>
<%@ page import= "test.Graph"%>
<%@ page import= "test.Vertex"%>
<%@ page import= "test.Main"%>
<%@ page import= "city.CityDao"%>
<%@ page import= "city.City"%>
<%@ page import= "city.Query"%>


<html>
	<body>  

	
	
	<%
		String strQueryHour = request.getParameter("queryhour");
		String strQueryMinute = request.getParameter("queryminute");
		int queryhour = Integer.parseInt(strQueryHour);
		int queryminute = Integer.parseInt(strQueryMinute);
		Time querytime= new Time(0);
        querytime.setHours(queryhour);
        querytime.setMinutes(queryminute);
        querytime.setSeconds(00);
        String timeprint = "'";
        timeprint += querytime.toString();
        timeprint += "'";
        
        
       // out.println("****time:"+querytime.toString()+"<br>");
        out.println(timeprint+"以后北京到上海的航班<br>");
		Query query = new Query();
		query.setQuerysql("SELECT 航班,出发时,出发机,到达时,到达机,价格   FROM  北京到上海航班   WHERE 出发时 >= "+timeprint+";");
		ArrayList queryflights = query.QueryFlight();
		%>
		
		
		<table border = 2>
			<tr>
				<td>航班</td>
				<td>出发时</td>
				<td>出发机</td>
				<td>到达时</td>
				<td>到达机</td>
				<td>价格</td>
			</tr>
		<%
			for(int i = 0;i<queryflights.size();i++){
			City cityflight = (City)queryflights.get(i);
		 %>
		 	<tr>
		 		<td><%=cityflight.Flight()%></td>
		 		<td><%=cityflight.DepartureTime() %></td>
		 		<td><%=cityflight.DepartureStation()%></td>
		 		<td><%=cityflight.ArrivalTime()%></td>
		 		<td><%=cityflight.ArrivalStation()%></td>
		 		<td><%=cityflight.Price()%></td>
		 	</tr>
		
		<% 	
		}
		%>
	
	

  </body>
</html>