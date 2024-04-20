
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ChangeSessionTimeout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the current session
        HttpSession session = request.getSession();

        // Set the inactive time interval to 10 minutes (in seconds)
        session.setMaxInactiveInterval(600);

        // Display a message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Session Timeout Changed to 10 Minutes</h3>");
        out.println("</body></html>");
    }
}