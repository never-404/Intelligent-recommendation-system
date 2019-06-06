package filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PemissionFilter implements Filter {

    public PemissionFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将请求与响应向下转换
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        // 获得访问界面的url文件地址
        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        // 获取登录状态
        String flag = (String) session.getAttribute("flag");
        /* 判断是否是登录页、首页、登录servlet */
        if (servletPath != null && (servletPath.equals("/login.jsp") || servletPath.equals("/index.jsp") || servletPath.equals("/LoginServlet"))) {
            // 是则直接转发到下一组件
            chain.doFilter(request, response);
        } else {
            // 否，则验证登录状态
            if (flag != null) {
                if (flag.equals("login_success")) {
                    // 登录成功，直接转发到下一组件
                    chain.doFilter(request, response);
                } else {
                    // 登录失败，跳转到登录页，并保证当前网页的url文件路径
                    req.setAttribute("msg", "登录失败");
                    req.setAttribute("return_uri", servletPath);
                    RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                    rd.forward(req, res);
                }
            } else {
                // 未登录，跳转到登录页，并保证当前网页的url文件路径
                req.setAttribute("msg", "您尚未登录，请登录");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                rd.forward(req, res);
            }
        }
    }

    public void destroy() {
    }

}