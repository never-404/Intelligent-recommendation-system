<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
    <html>  
<body bgcolor=#E0FFFF>
		<center>
			<img src="pic/flightQuery/plane_fengexian.jpg" width = "800" height = "50" ><br>
		</center>
		<TABLE WIDTH="100%" HEIGHT="100%">
             <TR>
                 <TD ALIGN="center" >
                   		<form action="QueryResult.jsp" method="post">
   							<img src="pic/flightQuery/plane4_L.jpg" width = "110" height = "50" ><img src="pic/flightQuery/beijing_shanghai.png" width = "400" height = "50" ><img src="pic/flightQuery/plane4_R.jpg" width = "110" height = "50" ><br>
							<img src="pic/flightQuery/plane5.gif" width = "500" height = "80" ><br>
				   			
				   			请输入您想查询的时间：<br>
							<input type="text" name="queryhour" style="width:25px;">时
							<input type="text" name="queryminute" style="width:25px;">分<br>
							<input type="image" src="pic/flightQuery/dianjichakan.gif" width = "80" height = "40"name="img"> <br>
				   			
				   			
				   		</form>
                 </TD>
             </TR>
             <TR>
             	<TD ALIGN="left" >
             		<img src="pic/flightQuery/goHome.jpg" width = "280" height = "200" ><br>
             	</TD>
             </TR>
         </TABLE>
         
   		
   		
  </body>
</html>
