<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="DAO.stationDao" %>
<%@ page import= "javabean.station"%>
<html>
	<body>  

	车站为：
      <%
        request.setCharacterEncoding("UTF-8");
        String subwayLine= request.getParameter("subwayLine");
        String direction=request.getParameter("direction");
        String station=request.getParameter("station");
        String startTime=request.getParameter("startTime");
        String endTime=request.getParameter("endTime");
        

        stationDao sdao= new stationDao();
       	ArrayList substations= sdao.queryAllStudents();

		for (int i = 0; i < substations.size(); i++) {
			station substation=(station)substations.get(i);

        //if(substation!=null){
        %>
        if内部
        <% 
        //out.println(subwayLine);
        //out.println(direction);
        out.println(substation.getSubwayLine());
        
        }

       %>
  </body>
</html>
