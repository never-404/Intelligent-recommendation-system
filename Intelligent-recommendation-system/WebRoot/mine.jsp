<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>�ҵ�</title>
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
	
	<body>
	
	<h1>XXX,��ã�</h1>

    	�л�����
    	<select>
    		<option>�ϲ�</option>
    		<option>����</option>
    		<option>������</option>
    	</select>
        <br>
        <p>��ǰ�汾��0.0.1</p>

	<form>
		������ԣ�        <br>
		<textarea rows="15" cols="150"></textarea><br>
		<div class="a">
			<input type="submit" value ="�ύ">
			<input type="reset"  value="ȡ��">
		</div>
	</form>
	<hr>
	�������ǣ� git commit ��Ҫ�ǽ��ݴ�����ĸĶ����ύ�����صİ汾�⡣ÿ��ʹ��git commit �������Ƕ����ڱ��ذ汾������һ��40λ�Ĺ�ϣֵ�������ϣֵҲ��commit-id��
����commit-id�ڰ汾���˵�ʱ���Ƿǳ����õģ����൱��һ������,������δ�����κ�ʱ��ͨ����git reset���������ص�����.
        <br>
	<form action = "mainpage.jsp" method = "post">
		<input type="submit" value ="����">
	</form>
	
	</body>


</html>