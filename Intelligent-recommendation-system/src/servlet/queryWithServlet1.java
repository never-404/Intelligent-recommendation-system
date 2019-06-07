package servlet;

import javabean.station;
import DAO.stationDao;
import servlet.Subway;
import servlet.queryWithServlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List; 
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class queryWithServlet1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public queryWithServlet1() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(RouteCalculate(request,response)) {
		request.getRequestDispatcher("/result.jsp").forward(request, response);
			
			//String targetUrl = "/result.jsp";
			//stationDao stationDao = new stationDao();
		
			//ServletContext application = this.getServletContext();
			//RequestDispatcher rd = application.getRequestDispatcher(targetUrl);
			//rd.forward(request, response);

		

		}
	}

	
	
	
	
	 boolean RouteCalculate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("startStation")!=null&&request.getParameter("endStation")!=null){
			
			//从页面获取到的参数，是字符串
			String startStation = new String(request.getParameter("startStation").getBytes("iso-8859-1"), "utf-8"); 
			String endStation = new String(request.getParameter("endStation").getBytes("iso-8859-1"), "utf-8");
			response.setContentType("text/html;charset=utf-8");
			//response.setContentType("text/html;charset=gb2312");
			//request.setCharacterEncoding("gb2312");
			
			PrintWriter out = response.getWriter();
			int j;
			Subway sw = new Subway();
			//是Station对象，把获取到的参数转化成对象
			Station startStation1 = new Station(startStation,"");
			Station endStation1 = new Station(endStation,"");
			HttpSession session = request.getSession();
			
			//Subway sw = new Subway();
			ArrayList stations=(ArrayList)session.getAttribute("stations");
			ArrayList Routes=(ArrayList)session.getAttribute("Routes");

				stations = new ArrayList();
				session.setAttribute("stations", stations);
				
				Routes = new ArrayList();
				session.setAttribute("Routes",Routes);

		//	}
	
			sw.calculate(startStation1, endStation1);
			
			//换成起始站
			for(j = 0;j<=sw.i;j++){
				Routes.add("startRoute:"+sw.startRoute[j]+"endRoute:"+sw.endRoute[j]+"<br/>");
			}
			
			//整体路线
			for(j = 0;j<sw.k-1;j++){
				stations.add(sw.RouteNum[j]+"号线"+sw.Route[j]+"->");
			}
			
			stations.add(sw.RouteNum[sw.k-1]+"号线"+sw.Route[sw.k-1]);
			j=0;
	
			session.setAttribute("startStation",startStation);
			session.setAttribute("endStation",endStation);
			return true;
		}
		else{
			return false;
		}
}
	
	
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
