import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ProjectTable {
  // Database connection settings
  private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
  private static final String DB_USER = "username";
  private static final String DB_PASSWORD = "password";

  // Create the PROJECT table
  private static void createProjectTable(Connection conn) throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS PROJECT (" +
                 "project_id INT PRIMARY KEY AUTO_INCREMENT," +
                 "project_name VARCHAR(255) NOT NULL," +
                 "project_description TEXT," +
                 "project_status VARCHAR(255)" +
                 ")";
    Statement stmt = conn.createStatement();
    stmt.executeUpdate(sql);
  }

  // Insert values into the PROJECT table
  private static void insertProjectValues(Connection conn) throws SQLException {
    String sql = "INSERT INTO PROJECT (project_name, project_description, project_status) VALUES (?,?,?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setString(1, "Project 1");
    pstmt.setString(2, "This is a sample project description.");
    pstmt.setString(3, "In Progress");
    pstmt.executeUpdate();

    pstmt.setString(1, "Project 2");
    pstmt.setString(2, "This is another sample project description.");
    pstmt.setString(3, "Completed");
    pstmt.executeUpdate();
  }

  // Display the details of the PROJECT table in a tabular format
  private static void displayProjectTable(Connection conn) throws SQLException {
    String sql = "SELECT * FROM PROJECT";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    // Create a table to display the results
    JTable table = new JTable(new String[][] {
      {"project_id", "project_name", "project_description", "project_status"}
    });

    while (rs.next()) {
      String[] row = new String[] {
        rs.getString("project_id"),
        rs.getString("project_name"),
        rs.getString("project_description"),
        rs.getString("project_status")
      };
      table.addRow(row);
    }

    // Create a scroll pane to hold the table
    JScrollPane scrollPane = new JScrollPane(table);

    // Create a frame to hold the scroll pane
    JFrame frame = new JFrame("PROJECT Table");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    try {
      // Connect to the database
      Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

      // Create the PROJECT table
      createProjectTable(conn);

      // Insert values into the PROJECT table
      insertProjectValues(conn);

      // Display the details of the PROJECT table in a tabular format
      displayProjectTable(conn);

      // Close the connection
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}