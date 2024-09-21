package hoctap.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ShowSession
 */
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// hiển thị session lên web
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		String ten = "";
		HttpSession s = req.getSession(); // khởi tạo session

		Object objName = s.getAttribute("ten"); // truy xuất dữ liệu từ session
		Object objAge = s.getAttribute("tuoi");

		// kiểm tra đối tượng Object có null không
		if (objName == null || objAge == null) {
			out.println("Thông tin session chưa được tạo. Chuyển hướng đến trang tạo session...");
			resp.sendRedirect("/LTweb/CreateSession");
			return; // Ngăn mã tiếp tục thực thi
		}
		int tuoi = (int) s.getAttribute("tuoi");// ép kiểu
		String ten1 = String.valueOf(objName);
	    int tuoi1 = (int) objAge;
	    
	    // Hiển thị session lên web
	    out.println("Xin chào bạn: " + ten1 + " tuổi: " + tuoi1);
	    out.close();
	}

}
