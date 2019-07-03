<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="test.AF" %>
<%@ page import= "test.Graph"%>
<%@ page import= "test.Vertex"%>
<%@ page import= "test.Main"%>
<%@ page import= "city.CityDao"%>
<%@ page import= "city.City"%>
<%@ page import= "city.Query"%>


<html>
<style>
				.buttom{
					left:20px;
				}

<<<<<<< HEAD
	
	
=======
				
</style>
	<body bgcolor=#E0FFFF>  

	<center>
	<br><br>
	<img src="pic/flightQuery/biaoti.gif" width = "100" height = "40" >
>>>>>>> e5c42cf57c926eac4ff617289fa083eb68122c61
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
<<<<<<< HEAD
        out.println(timeprint+"以后北京到上海的航班<br>");
=======
        out.println(timeprint+"以后北京到上海的航班");
>>>>>>> e5c42cf57c926eac4ff617289fa083eb68122c61
		Query query = new Query();
		query.setQuerysql("SELECT 航班,出发时,出发机,到达时,到达机,价格   FROM  北京到上海航班   WHERE 出发时 >= "+timeprint+";");
		ArrayList queryflights = query.QueryFlight();
		%>
<<<<<<< HEAD
		
		
		<table border = 2>
			<tr>
				<td>航班</td>
				<td>出发时</td>
				<td>出发机</td>
				<td>到达时</td>
				<td>到达机</td>
=======
		<img src="pic/flightQuery/biaoti.gif" width = "100" height = "40" ><br><br><br>
		<img src="pic/flightQuery/plane_fengexian.jpg" width = "800" height = "50" ><br>
		
		<table border = 2>
			<tr>
				<td>航班</td>
				<td>出发时间</td>
				<td>出发机场</td>
				<td>到达时间</td>
				<td>到达机场</td>
>>>>>>> e5c42cf57c926eac4ff617289fa083eb68122c61
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
	
	
	</center>
	<div class="buttom">
	<input type="button"  value="返回" onclick="javascript:history.back()" /></div>
  </body>
</html>