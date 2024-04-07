
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class Claim
 */
public class Claim extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con;
		Statement p;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nm = (request.getParameter("fanme") + " " + request.getParameter("lname"));
		String email = request.getParameter("email");
		String item = request.getParameter("item");
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		String dec = request.getParameter("dec");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/landf", "root", "");
			
			p=con.createStatement();
			
			int i=p.executeUpdate("INSERT INTO `claim`(`name`, `email`, `item_id`, `item`, `dec`) VALUES ('"+nm+"','"+email+"',"+id+",'"+item+"','"+dec+"')");
			
			out.println("<html><body><script type=\\\"text/javascript\\\">window.alert('Item claimed wait for admin response')</script></body></html>");
			response.sendRedirect("html/recent_posts.jsp");
		} catch (Exception e) {
		}
		

	}

}
