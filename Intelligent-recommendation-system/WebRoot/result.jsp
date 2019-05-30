<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>
<%@ page import= "servlet.queryWithServlet1"%>

<html>
	<body>  
起始站：${startStation}<br>
终点站：${endStation}<br>
花费时长:<br>
		 <c:forEach items="${stations}" var="station">
		 ${station}
		 </c:forEach>
<BR>

		 <c:forEach items="${Routes}" var="Route">
		 ${Route}
		 </c:forEach>
		 
<BR>

		 <c:forEach items="${sums}" var="sum">
		 ${sum}
		 </c:forEach>
<BR>



    </body>
</html>
