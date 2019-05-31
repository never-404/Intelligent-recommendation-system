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

	
	北京到上海航班1点以后的航班：<br>
	<%
		Query query = new Query();
		
		ArrayList queryflights = query.QueryFlight();
		
		for(int i = 0;i<queryflights.size();i++){
			City cityflight = (City)queryflights.get(i);
		%>
		<%=cityflight.Flight()%><br>
		
		<% 	
		}
		%>
	
	

  </body>
</html>