package hoctap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class ReadParamsAction
 */
public class ReadParamsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading All Form Parameters";
		String docType = "<!doctype html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"
				+ "<table width = \"100%\" border = \"1\" align = \"center\">\n" + "<tr bgcolor = \"#949494\">\n"
				+ "<th>Param Name</th>" + "<th>Param Value(s)</th>\n" + "</tr>\n");

		// get all parameters of form
		@SuppressWarnings("rawtypes")
		Enumeration paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n<td>");
			String[] paramValues = request.getParameterValues(paramName);
			// Read single valued data
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<i>No Value</i>");
				else
					out.println(paramValue);
			} else {
				out.println("<ul>");
				for (int i = 0; i < paramValues.length; i++) {
					out.println("<li>" + paramValues[i]);
				}
				out.println("</ul>");
			}
		}
		out.println("</tr>\n</table>\n</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
