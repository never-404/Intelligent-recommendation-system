<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>登录页面</title>
	    <meta charset="utf-8">
	    
		<style type="text/css">
		.title
		{
			margin:auto;
			width:25%;
			background-color:#b0e0e6;
		}
		.table
		{
			margin:auto;
			width:25%;
			background-color:#b0e0e6;
		}
		lable { float: left; width: 7em; margin-right:1em; text-align: right; }
		h1	  {text-align: center}

        .a{
            text-align:center;
            vertical-align:middle;
        }
        img{max-width: 100%; height:auto;}

</style>
	</head>
	
	<body>
    <div class="table">
    	<lable>用户名：</lable><input type="text" name="number" size="15" maxlength="10">
        <!--学号为10位-->
        <br>
        <lable>密码：</lable><input type="password" name="passport" size="15" maxlength="10">
        <br>
    </div>
    <div class="a">
        <button id="denglu">
            <a href="mainpage.jsp">登录</a></button>
            <!-- 不同的登录界面链接到的页面也不同 -->
        <br>
            <a href="forget_pswd.jsp"> 忘记密码</a>
            <!--忘记密码跳转的网址-->
	</div>
	
	</body>


</html>