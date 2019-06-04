<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript">
    function check(form) {
        if(document.forms.loginForm.userName.value==""){
            alert("请输入用户名");
            document.forms.loginForm.userName.focus();
            return false;
        } else if (document.forms.loginForm.password.value==""){
            alert("请输入用户密码");
            document.forms.loginForm.password.focus();
            return false;
        }
    }
</script>

<style>
	div.table
		{
			margin:auto;
			width:75%;
			background-color:#b0e0e6;
		}
	div.button
	{
		padding-left:45%;
	}
	lable { float: center; width: 7em; margin-right:1em; text-align: right; }

</style>
</head>
<body>
    <form action="<%= request.getContextPath() %>/LoginServlet" method="post" name="loginForm">
        <%
            if(request.getAttribute("return_uri") != null) {
        %>
            <input type="hidden" name="return_uri" value="<%= request.getAttribute("return_uri") %>" />
        <%
            }
        %>

      用户名：<input type="text" name = "userName" />
      密码：<input type="password" name = "password" /><br>

      <input type="submit" value="提交" onclick="return check(this);"/>
      <input type="reset" value="重置" />


    </form>
    <%
        if(request.getAttribute("msg")!=null && !request.getAttribute("msg").toString().equals("")){
            out.print(request.getAttribute("msg"));
        }
    %>
</body>
</html>