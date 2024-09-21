package hoctap.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ReadCookie
 */
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = request.getCookies();
		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (cookies != null) {
			out.println("<h2> Found Cookies Name and Value</h2>");
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.print("Name : " + cookie.getName() + ", ");
				out.print("Value: " + cookie.getValue() + " <br/>");
			}
		} else {
			out.println("<h2>No cookies founds</h2>");
		}
		out.close();	}

	

}
