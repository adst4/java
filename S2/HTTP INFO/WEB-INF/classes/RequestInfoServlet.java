import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RequestInfoServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Request Information</title></head><body>");

        // Client's IP Address
        String ipAddress = request.getRemoteAddr();
        out.println("<h3>Client's IP Address: " + ipAddress + "</h3>");

        // Browser Type
        String browser = request.getHeader("User-Agent");
        out.println("<h3>Browser Type: " + browser + "</h3>");

        // Server Information
        String serverOS = System.getProperty("os.name");
        out.println("<h3>Server Operating System: " + serverOS + "</h3>");

        // Servlets loaded on the server
        String[] servlets = getServletContext().getServletRegistrations().keySet().toArray(new String[0]);
        out.println("<h3>Currently Loaded Servlets:</h3><ul>");
        for (String servlet : servlets) {
            out.println("<li>" + servlet + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
        out.close();
    }
}
