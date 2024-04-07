
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Access
 */
public class Access extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String buttonValue = request.getParameter("button");
		
		if ("Submit Lost Item".equals(buttonValue)) {
			response.sendRedirect("html/Lost_Info.jsp");
		} else if ("Submit Found Item".equals(buttonValue)) {
			response.sendRedirect("html/Found_Info.jsp");
		} else {

			response.getWriter().write("Invalid button click");
		}
	}

}
