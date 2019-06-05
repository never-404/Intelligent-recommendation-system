<%@ page language="java" contentType= "text/html;charset=utf-8" %>
<html>

	<head>
		<title>XXX系统</title>
	    <meta charset="utf-8">    
		<style type="text/css">
		*{margin: 0;padding: 0;}
		.clearfix:before,.clearfix:after { content:"";display:table; }
		.clearfix:after {clear:both;}
		.clearfix { *zoom:1;}

		body
		{
			opacity:0.9;
		background-color:#b9b6b252;
		}
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
		lable { 
			float: left; 
			width: 7em; 
			margin-right:1em; 
			text-align: right;
		 }
		h1{
			text-align:center;
			color:#99696b;
			margin-bottom:30px;
			 font-family:"楷体";
		}
        div.a{
            text-align:center;
            vertical-align:middle;
        }
        img{
        	max-width: 100%;
        	 height:auto;
        }
        .main{
        	margin:auto;
        	border:1px solid #3e3a37;
        	border-style:ridge;
        	border-radius:20px;
        	width:200px;
        	height:280px;
        	padding:5px 30px;
        	background-color: #E3E4E5;
        }
        .main option{
        font-family:"楷体";
        }
        .main .begin{
        margin:auto;
        font-size:25px;
        font-family:"楷体";
        padding:5px 20px;
        }
         .main .arrive{
        margin:auto;
        font-size:25px;
        font-family:"楷体";
        padding:5px 20px;
        }
        .main .radio{
        margin:auto;
        font-size:25px;
        font-family:"楷体";
        padding:5px 30px;
        }
        .main form input
        {
        	margin:auto;
        	padding:5px;
        	border:1px solid #3e3a37;
        	-webkit-border-radius:10px;
        }
        .main form{
        	padding:20px 73px;
        }
		.w {
			width: 1190px;
			margin: auto;
		}
		.fr {
			float: right;
		}
		.fl {
			float: left;
		}
		.style-red {
			color: #f10215!important;
		}
		a {
			text-decoration: none;
		}
		li {
			list-style: none;
		}
		.shortcut {
			height: 30px;
			background-color: #E3E4E5;
			border-bottom: 1px solid #DDD;
			line-height: 30px;
		}
		.shortcut a {
			color: #9D9D9D;
			font-size: 12px; 
			text-decoration: none;
		}
		.shortcut .fr li {
			float: left; 
		}
		.shortcut .fr li {
			margin-left: 10px;
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
</style>
	</head>
	
		<body>
		<script  type="text/javascript">
			function showResult1(){
	  			
		  		var xmlHttp=null;
		  		if(window. XMLHttpRequest){ //Mozilla等浏览器
	   			xmlHttp=new XMLHttpRequest();
				}
				else if(window.ActiveXObject){ //IE浏览器
	    			try{
						xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					}catch(e){
	        			try{
	        				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	        			}catch(e){
	        				window.alert("该浏览器不支持AJAX");
	                    }
					}
				}
		  		var url = "servlet/queryWithServlet1";
				xmlHttp.open("POST", url, true);				
				xmlHttp.onreadystatechange=function() {
					if (xmlHttp.readyState==4) {
						resultDiv.innerHTML = xmlHttp.responseText;
					}		
					else{
						resultDiv.innerHTML += "正在查询，请稍候......";
					}	
				};
				xmlHttp.send();	
			}
		</script>
		
		
		 <!--  导航栏开始 -->
	    <div class="shortcut">
    	<div class="w">
    		<ul class="fl">
    			<li>
    			   南昌
    		    </li>
    		</ul>
    		<ul class="fr">
    			<li>
    				<a href="log.jsp">你好，请登录&nbsp;&nbsp;</a>
    				<a href="register.jsp" class="style-red">免费注册 </a>
    			</li> 
    			<li class="spacer"></li>
    			<li>
    				<a href="mine.jsp">个人中心</a>
    			</li>
    			<li class="spacer"></li>
    			<li class="dropdown">
    				<a href="#">我的行程</a>
    			</li>
    			<li class="spacer"></li>
    			<li>
    				<a href="mine.jsp">用户反馈</a>
    			</li>
    	    	<li class="spacer"></li>
    			<li>
    				<a href="#">关于我们</a>
    			</li>
    			<li class="spacer"></li>
    		</ul>
    	</div>
    </div>
     <!--  页面中心开始 -->
     <h1>欢迎来到never-404！</h1>
	 
	<div class="main">
	<form >
		<div class="begin">
		出发地
    	<select name="startStation">
    		<option value="苹果园站">苹果园站</option>
    		<option value="公主坟站">公主坟站</option>
    		<option value="西单站">西单站</option>
    	</select>
		</div>
        <br>
        
        <div class="arrive">
    	目的地
    	<select name="endStation">
    		<option value="朝阳门站">朝阳门站</option>
    		<option value="安定门站">安定门站</option>
    		<option value="钟灵街站">钟灵街站</option>
    	</select>
    	</div>
        <br>

	<div class="radio">
	<input type="radio" name="selection" checked>时间最短<br>
	<input type="radio" name="selection">最便宜<br>
	<input type="radio" name="selection">最舒服<br>
	</div>
	<input type="submit" value ="查询" onclick="showResult1()">
	</form>
	 </div>
	 <div class="bottom">
	 	<hr>
	 	<div class="introduction">旅客行程智能推荐系统</div>
	 </div>

	</body>


</html>