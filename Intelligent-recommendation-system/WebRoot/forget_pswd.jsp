<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>
<head>
<meta charset="utf-8">
<title>忘记密码</title>
	<script src = "jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready( function(){
			$("#submit").click(event,function(){
				if (1){
	 			alert("信息正确，密码已重置为000000");
				}
				if(0){
				alert("信息错误，无法修改密码");
				}/*提交信息至数据库并判断*/
			});
		});
	</script>
							  
</head>

<body>

		<p>用户名：<input type="text" name="number" size="20" maxlength="10"></p>

 		<button id="submit"> 确定 </button>
	 
</body>
</html>
