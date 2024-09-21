package hoctap.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloController
 */
@WebServlet(
	    urlPatterns = {"/check-config"}, 
	    initParams = {
	        @WebInitParam(name = "name", value = "D M H"),
	        @WebInitParam(name = "email", value = "hieudm")
	    }
	)
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");	
		 PrintWriter out = response.getWriter();
		 
		 ServletConfig sc = getServletConfig();
		 
		 out.print(sc.getInitParameter("email"));
		 out.print(sc.getInitParameter("name"));
		 out.close();
	}

	
}
