package hoctap.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import hoctap.utils.Constant;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); // false: không tạo session mới nếu chưa có

        if (session != null) {
            // Hủy session
            session.invalidate();
        }
        
        Cookie[] cookies = req.getCookies();
        
        if (cookies != null) {
        	for (Cookie cookie : cookies) {
        		if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
        			cookie.setMaxAge(0);
        			resp.addCookie(cookie);
        			break;
        		}
        	}
        }

        // Chuyển hướng về trang đăng nhập
        resp.sendRedirect(req.getContextPath() + "/login");
	}

}
