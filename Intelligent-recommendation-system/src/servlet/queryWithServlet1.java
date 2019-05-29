package servlet;

import servlet.Subway;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List; 
import java.util.ArrayList;
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
			ArrayList stations=(ArrayList)session.getAttribute("stations");
			//if(stations == null){
				stations = new ArrayList();
				session.setAttribute("stations", stations);
		//	}
	
			sw.calculate(startStation1, endStation1);
			
			//换成起始站
			for(j = 0;j<=sw.i;j++){
				//out.print("j:  "+j+"  ");
				//out.println("startRoute:"+sw.startRoute[j]+"endRoute:"+sw.endRoute[j]+"<br/>");
		
			}
			//整体路线
			for(j = 0;j<sw.k-1;j++){
				//out.print(sw.RouteNum[j]+"号线"+sw.Route[j]+"->");
				stations.add(sw.RouteNum[j]+"号线"+sw.Route[j]+"->");
			}
			stations.add(sw.RouteNum[sw.k-1]+"号线"+sw.Route[sw.k-1]);
			j=0;
	
			session.setAttribute("startStation",startStation);

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
