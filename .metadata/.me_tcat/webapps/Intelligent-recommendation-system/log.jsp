<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>登录页面</title>
	    <meta charset="utf-8">
	    
		<style type="text/css">
		.title
		{
			font-size: 300%

		}
		.table
		{
			margin:auto;
			width:25%;
			background-color:#ffffe9;
			border-radius:5px;
		}
		lable { float: left; width: 7em; margin-right:1em; text-align: right; }
		h1	  {text-align: center}
	    body{
        font-size:20px;
        font-family:"宋体";
        background-image:url(circle.jpg);

    	}
        .a{
            text-align:center;
            vertical-align:middle;
            font-size:7px;
        }
        img{max-width: 100%; height:auto;}

</style>
	</head>
	
	<body>
	<BR>	<BR>
	<h1>欢迎来到旅客行程智能推荐系统！</h1>
		<BR>	<BR>
    <div class="table">
    <br>
    	<lable>用户名：</lable><input type="text" name="number" placeholder="请输入用户名" size="15" maxlength="10"/>
        <!--学号为10位-->
        <br>
        <lable>密码：</lable><input type="password" name="passport" placeholder="请输入密码" size="15" maxlength="10"/>
        <br><br>

	<div class=a>
	
    <form action = "mainpage.jsp" method = "post">
		<input type="submit" value ="登录">
	</form> 

	<a href="forget_pswd.jsp"><font color="#000000">忘记密码</font></a>
	</div>
	<br>
	    </div>
	</body>


</html>