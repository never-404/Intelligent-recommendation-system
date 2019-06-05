package servlet;

import servlet.Subway;
import DAO.stationDao;
import javabean.station;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
			
			ServletContext application = this.getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);	
	}
	}
	
	private boolean RouteCalculate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("startStation")!=null&&request.getParameter("endStation")!=null){
			//从页面获取到的参数，是字符串
			String startStation = new String(request.getParameter("startStation").getBytes("iso-8859-1"), "utf-8"); 
			String endStation = new String(request.getParameter("endStation").getBytes("iso-8859-1"), "utf-8");
			response.setContentType("text/html;charset=utf-8");
		
			PrintWriter out = response.getWriter();
			int j;
		
			//是Station对象，把获取到的参数转化成对象
			Station startStation1 = new Station(startStation,"");
			Station endStation1 = new Station(endStation,"");
			HttpSession session = request.getSession();
			
			Subway sw = new Subway();
			stationDao sdao= new stationDao();
			ArrayList stations=(ArrayList)session.getAttribute("stations");
			ArrayList Routes=(ArrayList)session.getAttribute("Routes");
			ArrayList sums=(ArrayList)session.getAttribute("sums");
			//ArrayList endRoutes=(ArrayList)session.getAttribute("endRoutes");
			//if(stations == null){
				stations = new ArrayList();
				session.setAttribute("stations", stations);
				
				Routes = new ArrayList();
				session.setAttribute("Routes",Routes);
				
				sums = new ArrayList();
				session.setAttribute("sums",sums);

		//	}
	
			sw.calculate(startStation1, endStation1);
			ArrayList TurnPoints= new ArrayList();
			int StarTime[]= new int[30];
			int num=0;
			int sum = 10;
			//换成起始站
			for(j = 0;j<=sw.i;j=j+2){
				
				Routes.add("startRouteNum:  "+sw.endRoute[j]+"startRoute: "+sw.startRoute[j+1]+"<br/>"+"endRouteNum: "+sw.endRoute[j]+"endRoute: "+sw.endRoute[j+1]+"<br/>");
				try {
					
					TurnPoints = sdao.queryTime(sw.startRoute[j+1],sw.startRoute[j]);
					for(int k = 0;k<=TurnPoints.size();k++)
					{
						station TurnPoint=(station)TurnPoints.get(k);
						StarTime[num]=TurnPoint.getStartTime();
						num++;
					}
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int k = 0;k<num;k++)
			{
				sum += StarTime[k+1]-StarTime[k];
				
			}
			sums.add(sum);
		
			

			//整体路线
			for(j = 0;j<sw.k-1;j++){
				//out.print(sw.RouteNum[j]+"号线"+sw.Route[j]+"->");
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
