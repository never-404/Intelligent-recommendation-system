<%@ page language="java" contentType= "text/html;charset=gb2312" %>
<html>

	<head>
		<title>XXXϵͳ</title>
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
	
	<h1>��ӭ����XXXϵͳ��</h1>
	<!-- ����ѡ��һ��ʾ -->
	<form action = "mine.jsp" method = "post">
		<input type="submit" value ="�ҵ�">
	</form>

	<form action = "log.jsp" method = "post">
		<input type="submit" value ="��¼">
	</form>
	
	<form action = "register.jsp" method = "post">
		<input type="submit" value ="ע��">
	</form>

    	������
    	<select>
    		<option>�ϲ�</option>
    		<option>����</option>
    		<option>������</option>
    	</select>
        <br>
        
    	Ŀ�ĵ�
    	<select>
    		<option>�ϲ�</option>
    		<option>����</option>
    		<option>������</option>
    	</select>
        <br>

	<input type="radio" name="selection" checked>ʱ�����<br>
	<input type="radio" name="selection">�����<br>
	<input type="radio" name="selection">�����<br>
	
	<form action = "result.jsp" method = "post">
		<input type="submit" value ="��ѯ">
	</form>


	
	</body>


</html>