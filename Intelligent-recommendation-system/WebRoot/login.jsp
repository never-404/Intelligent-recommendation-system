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
    
	function refresh(){
			//生成只包含数字的验证码
			//loginForm.imgValidate.src = "validate.jsp?id=" + Math.random();
			//生成包含数字和字符的验证码
			loginForm.imgValidate.src = "validateMix.jsp?id=" + Math.random();
		}
</script>

<style>
		body
		{
		opacity:0.9;
		background-color:#E0FFFF;

		}
		.title
		{
			font-size: 300%

		}
	
		h1	  {text-align: center}
	    body{
        font-size:20px;
        font-family:"宋体";
        background-image:url(circle.jpg);

    	}
        .a{
				
            text-align:center;
            vertical-align:middle;
            font-size:25px;
        }
        img{max-width: 100%; height:auto;}

	div.button
	{
		padding-left:45%;
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
		.info{
		text-align:center;
		}
</style>

</head>
<body>

    <form name="loginForm" action="<%= request.getContextPath() %>/LoginServlet" method="post" name="loginForm">
        <%
            if(request.getAttribute("return_uri") != null) {
        %>
            <input type="hidden" name="return_uri" value="<%= request.getAttribute("return_uri") %>" />
        <%
            }
        %>
         <br><br><br>
         <center>
        <img src="pic/flightQuery/never404_1.jpg" width = "280" height = "300" ></center>
 <br><br>
    <br>
    <div class=a>
      	用户名：<input type="text" name = "userName" /><br>
     	密&nbsp码：<input type="password" name = "password" /><br>
	 	验证码:
	<input type="text" name="code" ><br>
	<img name="imgValidate" src="validateMix.jsp" style="vertical-align: middle;">
	<a onclick="refresh()" href="#" style="font-size: 10; text-decoration: none;">重新获取验证码</a>
		
		
	<br>
     	 <input type="submit" value="提交" onclick="return check(this);"/>
     	 <input type="reset" value="重置" />
      </div>
      

    </form>
    <br>
    <div class="info">
    <%
        if(request.getAttribute("msg")!=null && !request.getAttribute("msg").toString().equals("")){
            out.print(request.getAttribute("msg"));
        }
    %>
    </div>
    	 <div class="photo">
          <img src="pic/flightQuery/goHome.jpg" width = "280" height = "200" ><br>
     </div>
    	 <div class="bottom">
	 
	 	<hr>
	 	<div class="introduction">旅客行程智能推荐系统</div>
	 	</hr>
	 </div>
</body>
</html>