<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>XXX系统</title>
	    <meta charset="utf-8">
	    
		<style type="text/css">
		div.title
		{
			margin:auto;
			width:25%;
			background-color:#b0e0e6;
		}
		div.table
		{
			margin:auto;
			width:25%;
			background-color:#b0e0e6;
		}
		lable { float: left; width: 7em; margin-right:1em; text-align: right; }
		h1	  {text-align: center}

        div.a{
            text-align:center;
            vertical-align:middle;
        }
        img{max-width: 100%; height:auto;}

</style>
	</head>
	
	<body>
	
	<h1>欢迎来到XXX系统！</h1>
	<!-- 两者选其一显示 -->
	<form action = "mine.jsp" method = "post">
		<input type="submit" value ="我的">
	</form>

	<form action = "log.jsp" method = "post">
		<input type="submit" value ="登录">
	</form>
	
	<form action = "register.jsp" method = "post">
		<input type="submit" value ="注册">
	</form>

    	出发地
    	<select>
    		<option>南昌</option>
    		<option>北京</option>
    		<option>黑龙江</option>
    	</select>
        <br>
        
    	目的地
    	<select>
    		<option>南昌</option>
    		<option>北京</option>
    		<option>黑龙江</option>
    	</select>
        <br>

	<input type="radio" name="selection" checked>时间最短<br>
	<input type="radio" name="selection">最便宜<br>
	<input type="radio" name="selection">最舒服<br>
	
	<form action = "result.jsp" method = "post">
		<input type="submit" value ="查询">
	</form>


	
	</body>


</html>