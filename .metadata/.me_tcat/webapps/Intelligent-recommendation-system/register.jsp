<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>注册页面</title>
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
        .a{
            text-align:center;
            vertical-align:middle;
        }
		lable { float: left; width: 7em; margin-right:1em; text-align: right; }
		h1	  {text-align: center}
</style>
	</head>
	<body background="background3.jpg">
	<div class="title">
		<h1>用户注册</h1>
	</div>
	<div class="table">
	
		<form action = "mainpage.jsp" method = "post">
			<lable>用户名</lable><input name="username" type="text" placeholder="请输入用户名" /><BR>
			<lable>密码</lable><input id="pwd2" name="password1" type="password" placeholder="请输入密码"/><BR>
			<lable>确认密码</lable><input name="password2" type="password"/><BR>
			<lable>性别</lable>
				<input name="sex" type="radio" value="男" checked>男
				<input name="sex" type="radio" value="女" >女<BR>
		<div class="a">
			<input type="submit" value ="提交">
			<input type="reset"  value="取消">
		</div>
		</form>
	</div>

<!-- 		<SCRIPT language = javascript>
  		 	 document.onkeydown = chang_page;
   			 function chang_page() 
   			 {
        	 	if (event.keyCode == 39 || event.keyCode == 40) location = 'show_log.jsp'
    		 }
		</SCRIPT>
		 -->


	</body>


</html>