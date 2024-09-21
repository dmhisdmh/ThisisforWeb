package hoctap.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(urlPatterns= {"/login1"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.sendRedirect(req.getContextPath() + "/Login.html");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		//lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if(user.equals("dmh") && pass.equals("123"))
		{
		Cookie cookie = new Cookie("username", user); //khởi tạo cookie
		//thiết lập thời gian tồn tại 30s của cookie
		cookie.setMaxAge(30);
		//thêm cookie vào response
		resp.addCookie(cookie);
		//chuyển sang trang HelloServlet
		resp.sendRedirect("/LTweb/hello");
		}else {
		//chuyển sang trang LoginServlet
		resp.sendRedirect("/LTweb/Login.html");
		}
	}
}

