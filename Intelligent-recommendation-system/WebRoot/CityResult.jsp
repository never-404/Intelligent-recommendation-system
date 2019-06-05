<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="test.AF" %>
<%@ page import= "test.Graph"%>
<%@ page import= "test.Vertex"%>
<%@ page import= "test.Main"%>



<html>
	<body>  	
	<%
		AF operation = new AF(new Graph(0), 0, 1);  
        operation.getResult(); 
        String resultlines = operation.getResultLine();         
	 %>
	路线为：<br><%=resultlines%>
	<%
		System.out.println();
		System.out.println("*************");
		System.out.println(resultlines);
	 %>

  </body>
</html>