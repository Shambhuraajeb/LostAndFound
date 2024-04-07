import java.sql.*;
import jakarta.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;
@SuppressWarnings("unused")
public class Found extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
        Connection con;
		PreparedStatement p;
		
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
        String what_lost=req.getParameter("what_lost");
        String category=req.getParameter("category");
        String brand=req.getParameter("brand");
        String p_color=req.getParameter("p_color");
		String s_color=req.getParameter("s_color");
		String option=req.getParameter("option");
		int z_code=Integer.parseInt(req.getParameter("z_code"));
        String f_name=req.getParameter("f_name");
        
        String fdate=req.getParameter("fdate");
        String sdate=req.getParameter("sdate");
        String a_info=req.getParameter("a_info");
        String l_name=req.getParameter("l_name");
        int p_no=Integer.parseInt(req.getParameter("p_no"));
        String email=req.getParameter("email");
        try{
        	
        	
        Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/landf","root","");
		p=con.prepareStatement("INSERT INTO `found`(`what_lost`, `date`, `category`, `time`, `brand`, `p_color`, `s_color`, `info`, `location`, `zip`, `fname`, `lname`, `email`, `phn`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
		
		
		p.setString(1, what_lost);
		p.setString(2, fdate);
		p.setString(3, category);
		p.setString(4, sdate);
		p.setString(5, brand);
		p.setString(6, p_color);
		p.setString(7, s_color);
		p.setString(8, a_info);
		p.setString(9, option);
		p.setInt(10, z_code);
		p.setString(11, f_name);
		p.setString(12, l_name);
		p.setString(13, email);
		p.setInt(14, p_no);

		
		
        int n=p.executeUpdate();
        
        if(n!=0)
        {
            out.println("<html><script>window.alert('Thank you')</script></html>");
            res.sendRedirect("html/recent_posts.html");
        }
        else{
            out.println("<html><script>window.alert('Something wrong')</script></html>");
        }
        }catch(Exception e){out.println("<html><body>"+e+"</body></html>");}
        

        out.close();	
	}
}
