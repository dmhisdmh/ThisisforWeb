package hoctap.controllers;

import java.io.IOException;

import hoctap.services.impl.UserServiceImpl;
import hoctap.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/forgot" })
public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/forgot.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String password = req.getParameter("psw");
		String repsw = req.getParameter("repsw");
		UserServiceImpl service = new UserServiceImpl();

		String alertMsg = "";
		if (!service.checkExistEmail(email)) {
			alertMsg = "Tài khoản không tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.FORGOT).forward(req, resp);
			return;
		} else {
			if (password.equals(repsw)) {
				boolean isUpdated = service.resetPassword(email, password);

				if (isUpdated) {
					alertMsg = "Update completed";
					req.setAttribute("alert", alertMsg);
					resp.sendRedirect(req.getContextPath() + "/login");
				} else {
					alertMsg = "Error";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("views/forgot.jsp").forward(req, resp);
				}
			}

		}
	}
}
