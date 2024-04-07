import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        try {
            // Load the JDBC driver (optional in newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/landf", "root", "");
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM login WHERE email=? AND password=?")) {

                // Set parameters for the prepared statement
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                // Execute the query
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        out.println("<html><script>window.alert('You are logged in')</script></html>");
                        response.sendRedirect("index.html");
                    } else {
                        out.println("<html><script>window.alert('Login failed')</script></html>");
                        response.sendRedirect("login.html");
                    }
                }
            }
        } catch (Exception e) {
            // Log the exception (consider using a logging framework like Log4j)
            e.printStackTrace();

            // Provide a generic error message to the user
            out.println(e);
        } finally {
            out.close();
        }
    }
}
