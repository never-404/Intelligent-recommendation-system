<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>注册页面</title>
		<style type="text/css">
		body
		{
		opacity:0.9;
		background-color:#E0FFFF;
		}
		.title
		{

			margin:auto;
			width:25%;
			background-color:#E0FFFF;
		}
		.table
		{
			font-size:25px;
			position:absolute;
			top:100px;
			left:650px;
			margin:auto;
			width:25%;
			background-color:#E0FFFF;
		}
        .a{
            position:absolute;
			top:250px;
			left:720px;
            vertical-align:middle;
            background-color:#E0FFFF;
        }
		lable { float: left; width: 7em; margin-right:1em; text-align: right; }
				h1{
			text-align:center;
			color:#99696b;
			margin-bottom:30px;
			 font-family:"幼圆";
			 font-size:50px;
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
	</head>
	<body background="background3.jpg">
	<div class="title">
		<h1>用户注册</h1>
	</div>
	<BR><BR>
	<div class="table">
	
		
			用   &nbsp户 &nbsp名：<input name="username" type="text" placeholder="请输入用户名" /><BR>
			密  &nbsp&nbsp &nbsp &nbsp码：<input id="pwd2" name="password1" type="password" placeholder="请输入密码"/><BR>
			确认密码：<input name="password2" type="password"/><BR>
			性  &nbsp&nbsp &nbsp &nbsp别：
				<input name="sex" type="radio" value="男" checked>男
				<input name="sex" type="radio" value="女" >女<BR>
				
				<BR></div>
		<div class="a">
			<input type="submit" value ="提交" onclick="javascript:history.back()" />
			<input type="reset"  value="取消">
		</div>
		
	

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