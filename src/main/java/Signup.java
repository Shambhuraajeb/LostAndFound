import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/Signup")
public class Signup extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String name = fname + lname;
        String email = req.getParameter("email");
        double cno = Double.parseDouble(req.getParameter("cno"));
        String pass = req.getParameter("pass");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/landf", "root", "");
            
            // Use try-with-resources to automatically close PreparedStatement
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO `login`(`username`, `password`, `email`, `contact`) VALUES (?,?,?,?)")) {
                pstmt.setString(1, name);
                pstmt.setString(2, pass);
                pstmt.setString(3, email);
                pstmt.setDouble(4, cno);

                int n = pstmt.executeUpdate();

                if (n != 0) {
                    out.println("<html><body><script>window.alert('You are logged in')</script></body></html>");
                    res.sendRedirect("index.html");
                } else {
                    out.println("<html><body><script>window.alert('Something went wrong')</script></body></html>");
                }
            } // PreparedStatement is closed here

        } catch (ClassNotFoundException | SQLException e) {
            // Log the exception instead of printing the stack trace
            e.printStackTrace();
            out.println("<html><body><b>"+e+"</b></body></html>");
        }
    }
}
