<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>
<%@ page import= "servlet.queryWithServlet1"%>

<html>
<style type="text/css">
		*{margin: 0;padding: 0;}
		.clearfix:before,.clearfix:after { content:"";display:table; }
		.clearfix:after {clear:both;}
		.clearfix { *zoom:1;}

		body
		{
		opacity:0.9;
		background-color:#E0FFFF;
		}
		.w{
			position:absolute;
			left:20%;
			font-size:20px;
			font-family:"幼圆";
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
				h1{
			text-align:center;
			color:#99696b;
			margin-bottom:30px;
			 font-family:"幼圆";
			 font-size:50px;
		}
		.login{
			float:left;
			margin-top:2px;
			margin-right:7px;
		}
		.photo{
			position:absolute;
			left:0px;
			bottom:55px;
			
		}
		.return
        {
			position:absolute;
			left:750px;
        	margin-top:180px;
        	padding:5px;
        	-webkit-border-radius:10px;
        }

</style>
	</head>
	<body>  
    
		<div><br></div>
     <!--  页面中心开始 -->
     <h1>查询结果</h1>
     <div class="w">
	起始站：${startStation}<br>
	终点站：${endStation}<br>
	<BR>
		 <c:forEach items="${stations}" var="station">
		 ${station}
		 </c:forEach>
		<BR><BR>
				 <c:forEach items="${Routes}" var="Route">
		 ${Route}
		 </c:forEach>
		<BR>
	</div>
	<div class="return">
		<input type="button"  value="返回" onclick="javascript:history.back()" />
	</div>


	 <div class="bottom">
	 
	 	<hr>
	 	<div class="introduction">旅客行程智能推荐系统</div>
	 	</hr>


    </body>
</html>
