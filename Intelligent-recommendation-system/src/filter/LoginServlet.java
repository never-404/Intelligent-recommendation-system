package filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
		String code = request.getParameter("code");
		//获取session中的验证码
		HttpSession session = request.getSession();
		String randStr = (String)session.getAttribute("randStr");
        // 访问登录页面之前所访问的页面，可通过这个值跳转至之前的页面
        String returnUri = request.getParameter("return_uri");
        RequestDispatcher rd = null;
        if (userName == null || password == null) {
            request.setAttribute("msg", "用户名或密码为空");
        } else {
            if (userName.equals("stydt") && password.equals("123456")) {
            	if(code.equals(randStr)){
                /* 登录成功 */
                // 将登录状态保存到session对象中
                request.getSession().setAttribute("flag", "login_success");
                /* 判断登录之前的上一个页面是否存在 */
                if (returnUri != null) {                   
                    // 存在则跳转到登录之前的界面
                    rd = request.getRequestDispatcher(returnUri);
                    rd.forward(request, response);
                } else {
                    // 不存在则跳转到首页
                    rd = request.getRequestDispatcher("/mainpage.jsp");
                    rd.forward(request, response);
                }
            	}
            	else{
            	request.getSession().setAttribute("flag", "login_error");
                request.setAttribute("msg", "验证码错误");
                // 失败后跳转到登录界面
                rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            	}}
            if(!userName.equals("stydt") || !password.equals("123456"))
             {
            
                /* 登录失败 */
                // 将登录状态修改为失败
                request.getSession().setAttribute("flag", "login_error");
                request.setAttribute("msg", "用户名或密码错误");
                // 失败后跳转到登录界面
                rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        }
    }  
}
    

