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
			background-color:#b0e0e6;
		}
		lable { float: left; width: 7em; margin-right:1em; text-align: right; }
		h1	  {text-align: center
		}

        .a{
            text-align:center;
            vertical-align:middle;
        }
        img{max-width: 100%; height:auto;}

</style>
	</head>
	
	<body background="background.jpg">
	<h1 class=title>欢迎来到旅客行程智能推荐系统！</h1>
    <div class="table">
    	<lable>用户名：</lable><input type="text" name="number" placeholder="请输入用户名" size="15" maxlength="10"/>
        <!--学号为10位-->
        <br>
        <lable>密码：</lable><input type="password" name="passport" placeholder="请输入密码" size="15" maxlength="10"/>
        <br>
    </div>
    <br>


	<div class=a>
	
    <form action = "mainpage.jsp" method = "post">
		<input type="submit" value ="登录">
	</form> 
    <form action = "forget_pswd.jsp" method = "post">
		<input type="submit" value ="忘记密码">
	</form>  
	      
	</div>
	
	</body>


</html>