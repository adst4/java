<%@ page language="java" import="java.sql.*, java.util.*" %>
<%@ page import="javax.servlet.http.*" %>

<%
    HttpSession hs = request.getSession(true);
    String name = request.getParameter("name");
    hs.setAttribute("name", name);

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/exam", "root", "");
        stmt = con.createStatement();

        // Retrieve questions from the database
        rs = stmt.executeQuery("SELECT * FROM test ORDER BY RAND()");
        while (rs.next()) {
            out.println("<h3>Question " + rs.getInt("qid") + ": " + rs.getString("que") + "</h3>");
            out.println("<form action='first.jsp' method='post'>");
            out.println("<input type='hidden' name='qid' value='" + rs.getInt("qid") + "'>");
            out.println("<input type='radio' name='answer' value='" + rs.getString("o1") + "'>" + rs.getString("o1") + "<br>");
            out.println("<input type='radio' name='answer' value='" + rs.getString("o2") + "'>" + rs.getString("o2") + "<br>");
            out.println("<input type='radio' name='answer' value='" + rs.getString("o3") + "'>" + rs.getString("o3") + "<br>");
            out.println("<input type='radio' name='answer' value='" + rs.getString("o4") + "'>" + rs.getString("o4") + "<br>");
            out.println("<input type='submit' name='next' value='Next'>");
            out.println("</form>");
        }
    } catch(Exception e) {
        out.println(e);
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            out.println("Error closing resources: " + ex.getMessage());
        }
    }
%>
