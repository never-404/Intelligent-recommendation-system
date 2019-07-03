<%@ page language="java" pageEncoding="gb2312"%>
<html>
<style type="text/css">
  		body
		{
			opacity:0.9;
		background-color:#E0FFFF;}
		.w{
			
			position:absolute;
			left:550px;
			top:120px;
		}
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
			
		</style>
	<body >
	
		<h1>头像上传</h1>
		<hr>
		<br>
		<div class="w">
		<form action="/Intelligent-recommendation-system/servlet/UploadServlet" method="post" 
			enctype="multipart/form-data">
			请选择一张图片进行上传：
			<input type="file" name="myFile">
			<input type="submit" value="上传">
			
		</form>
		
		${msg}
		</div>

    	 
    	 <div class="bottom">
	 	<hr>
	 	<div class="introduction">旅客行程智能推荐系统</div>
	 	</hr>
	 </div>
	</body>
</html>
