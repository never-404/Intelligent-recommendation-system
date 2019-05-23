<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>
<%@ page import= "servlet.queryWithServlet1"%>

<html>
	<body>  
路线为：

${startStation}
<BR>
		 <c:forEach items="${stations}" var="station">
		 ${station}
		 </c:forEach>

    </body>
</html>
