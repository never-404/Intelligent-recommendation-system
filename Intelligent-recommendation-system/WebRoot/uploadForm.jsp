<%@ page language="java" pageEncoding="gb2312"%>
<html>
	<body style="background:url(pic/background_yc.jpg) ;background-size:cover; ">
		头像上传
		<hr>
		<form action="/Intelligent-recommendation-system/servlet/UploadServlet" method="post" 
			enctype="multipart/form-data">
			请选择一张图片进行上传：
			<input type="file" name="myFile">
			<input type="submit" value="上传">
		</form>
		${msg}
	</body>
</html>
