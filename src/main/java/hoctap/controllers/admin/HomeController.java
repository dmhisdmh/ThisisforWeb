package hoctap.controllers.admin;

import java.io.IOException;

import hoctap.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/admin/home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
        UserModel user = (UserModel) session.getAttribute("account");

        if (user != null) {
            // Truyền fullname vào thuộc tính request
            req.setAttribute("fullname", user.getFullname());
        }
		req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
	}
}
