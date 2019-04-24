<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>我的</title>
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
	
	<body style="background:url(background_yc.jpg) ;background-size:cover; ">
	
	<h1><img src="gundong.gif"  width="150"   height="80"><img src="nihao.png"  width="300"   height="200"><img src="gundong.gif"  width="150"   height="80"></h1>

    	<img src="changeCity.png"  width="100"   height="50">
    	<select>
    		<option>南昌</option>
    		<option>北京</option>
    		<option>黑龙江</option>
    	</select>
        <br>
        <img src="banben.png"  width="200"   height="100"><img src="dongtu.gif"  width="300"   height="50"> 

	<form>
		<img src="yijianliuyan.png"  width="200"   height="100">        <br>
		<textarea rows="15" cols="150" style="background:transparent;border:1px solid #ffffff"></textarea><br>
		<div class="a">
			<input type="submit" value ="提交">
			<input type="reset"  value="取消">
		</div>
	</form>
	<hr>
	<img src="guanyuwomen.png"  width="300"   height="50"> 
        <br>
	<form action = "mainpage.jsp" method = "post">
		<input type="submit" value ="返回">
	</form>
	
	</body>


</html>