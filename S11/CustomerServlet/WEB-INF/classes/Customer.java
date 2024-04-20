import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Customer extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)
    throws ServletException , IOException
    {
        PrintWriter out = res.getWriter();
        int number = Integer.parseInt(req.getParameter("number"));
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc","postgres","7374");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from customer where number="+number);
            if(rs.next())
            {
                out.println("Customer number : "+rs.getInt(1));
                out.println("Customer Name : "+rs.getString(2));
                out.println("Customer Age : "+rs.getInt(3));
            }
            else{
                out.print("Customer Not Found");
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }

    }
}