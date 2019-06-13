<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="servlet.queryWithServlet1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>提示信息</title>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  		<style type="text/css">
  		body
		{
			opacity:0.9;
		background-color:#E0FFFF;}

		h1{
			text-align:center;
			color:#99696b;
			margin-bottom:30px;
			 font-family:"幼圆";
			 font-size:50px;
		}
		 form input
        {

        	padding:5px;
        	border:1px solid #3e3a37;
        	-webkit-border-radius:10px;
        }
        		.bottom{
			width:100%;
			position:fixed;
			bottom:30px;
		}
		.bottom .introduction{
			text-align:center;
			font-size:13px;
			margin-top:5px;
			
		}
		.photo{
			position:absolute;
			left:0px;
			bottom:55px;
			
		}

</style>

  <body>
 
    <br>
   <h1>请登录!</h1> 
   <center>
    <form action="1.jsp">
    	<input type="submit"  value ="返回" style="background:#08ebe0">
    </form>
    </center>
    <br>
	 <div class="photo">
          <img src="pic/flightQuery/goHome.jpg" width = "280" height = "300" ><br>
     </div>
	 <div class="bottom">
	 
	 	<hr>
	 	<div class="introduction">旅客行程智能推荐系统</div>
	 	</hr>
	 </div>
             
  </body>
</html>
