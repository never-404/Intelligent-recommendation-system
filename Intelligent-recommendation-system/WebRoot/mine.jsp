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
	
	<body>
	
	<h1>XXX,你好！</h1>

    	切换城市
    	<select>
    		<option>南昌</option>
    		<option>北京</option>
    		<option>黑龙江</option>
    	</select>
        <br>
        <p>当前版本：0.0.1</p>

	<form>
		意见留言：        <br>
		<textarea rows="15" cols="150"></textarea><br>
		<div class="a">
			<input type="submit" value ="提交">
			<input type="reset"  value="取消">
		</div>
	</form>
	<hr>
	关于我们： git commit 主要是将暂存区里的改动给提交到本地的版本库。每次使用git commit 命令我们都会在本地版本库生成一个40位的哈希值，这个哈希值也叫commit-id，
　　commit-id在版本回退的时候是非常有用的，它相当于一个快照,可以在未来的任何时候通过与git reset的组合命令回到这里.
        <br>
	<form action = "mainpage.jsp" method = "post">
		<input type="submit" value ="返回">
	</form>
	
	</body>


</html>