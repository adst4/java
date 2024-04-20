import java.sql.*;

public class DatabaseInfo {
  // Database connection settings
  private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
  private static final String DB_USER = "username";
  private static final String DB_PASSWORD = "password";

  // Display information about the database
  private static void displayDatabaseInfo(Connection conn) throws SQLException {
    DatabaseMetaData meta = conn.getMetaData();
    System.out.println("Database Product Name: " + meta.getDatabaseProductName());
    System.out.println("Database Product Version: " + meta.getDatabaseProductVersion());
    System.out.println("Driver Name: " + meta.getDriverName());
    System.out.println("Driver Version: " + meta.getDriverVersion());
  }

  // List all the tables in the database
  private static void listTables(Connection conn) throws SQLException {
    DatabaseMetaData meta = conn.getMetaData();
    ResultSet rs = meta.getTables(null, null, "%", null);
    while (rs.next()) {
      String tableName = rs.getString("TABLE_NAME");
      System.out.println("Table Name: " + tableName);
    }
  }

  public static void main(String[] args) {
    try {
      // Connect to the database
      Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

      // Display information about the database
      displayDatabaseInfo(conn);

      // List all the tables in the database
      listTables(conn);

      // Close the connection
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}