import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String seatNo = request.getParameter("seatno");
        String studName = request.getParameter("studname");
        String studentClass = request.getParameter("class");
        int totalMarks = Integer.parseInt(request.getParameter("totalmarks"));
        double percentage = (double) totalMarks / 5;
        String grade;
        if (percentage >= 80) {
            grade = "A+";
        } else if (percentage >= 70) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else {
            grade = "F";
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Student Details</h1>");
        out.println("<table>");
        out.println("<tr><td>Seat No:</td><td>" + seatNo + "</td></tr>");
        out.println("<tr><td>Student Name:</td><td>" + studName +
                "</td></tr>");
        out.println("<tr><td>Class:</td><td>" + studentClass + "</td></tr>");
        out.println("<tr><td>Total Marks:</td><td>" + totalMarks + "</td></tr>");
        out.println("<tr><td>Percentage:</td><td>" + percentage + "%</td></tr>");
        out.println("<tr><td>Grade:</td><td>" + grade + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}