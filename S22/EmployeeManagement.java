
//s22_1
import java.sql.*;

public class EmployeeManagement {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USER = "username";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();
            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(System.console().readLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter employee number: ");
                        int eno = Integer.parseInt(System.console().readLine());
                        System.out.print("Enter employee name: ");
                        String ename = System.console().readLine();
                        System.out.print("Enter employee salary: ");
                        double salary = Double.parseDouble(System.console().readLine());
                        String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES (" + eno + ", '" + ename + "', "
                                + salary + ")";
                        stmt.executeUpdate(sql);
                        System.out.println("Record inserted successfully.");
                        break;
                    case 2:
                        System.out.print("Enter employee number: ");
                        eno = Integer.parseInt(System.console().readLine());
                        System.out.print("Enter new employee name: ");
                        ename = System.console().readLine();
                        System.out.print("Enter new employee salary: ");
                        salary = Double.parseDouble(System.console().readLine());
                        sql = "UPDATE Employee SET EName='" + ename + "', Salary=" + salary + " WHERE ENo=" + eno;
                        int rowsAffected = stmt.executeUpdate(sql);
                        if (rowsAffected == 0) {
                            System.out.println("No records found with employee number " + eno);
                        } else {
                            System.out.println(rowsAffected + " record(s) updated successfully.");
                        }
                        break;
                    case 3:
                        sql = "SELECT * FROM Employee";
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            eno = rs.getInt("ENo");
                            ename = rs.getString("EName");
                            salary = rs.getDouble("Salary");
                            System.out.println("Employee number: " + eno + ", Employee name: " + ename
                                    + ", Employee salary: " + salary);
                        }
                        rs.close();
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }}

    // s22_2
    <%@page language="java"%><html><head><title>Greeting Page</title></head><body><h1>
    Welcome to
    our website</h1><%
    String userName = request.getParameter("userName");
    String greetingMessage = "Hello, " + userName;
    java.util.Date date = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
    int hour = Integer.parseInt(sdf.format(date).substring(0, 2));if(hour>=0&&hour<12)
    {
        greetingMessage += ". Good morning!";
    }else if(hour>=12&&hour<18)
    {
        greetingMessage += ". Good afternoon!";
    }else
    {
        greetingMessage += ". Good evening!";
}%><p><%=greetingMessage%></p><
form action = "greeting.jsp"method="get">
Enter your name:<
input type = "text"name="userName"><
input type = "submit"value="Submit"></form></body></html
>
