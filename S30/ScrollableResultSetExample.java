import java.sql.*;

public class ScrollableResultSetExample {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            // Create a Statement object with scrollable ResultSet
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Execute a query and get the ResultSet object
            rs = stmt.executeQuery("SELECT * FROM Teacher");
            // Move the cursor to the last row
            rs.last();
            // Get the total number of rows in the ResultSet
            int rowCount = rs.getRow();
            // Move the cursor back to the first row
            rs.beforeFirst();
            // Display the column headers
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();
            // Iterate through the ResultSet and display the data
            while (rs.next()) {
                System.out.print(rs.getInt("TID") + "\t");
                System.out.print(rs.getString("TName") + "\t");
                System.out.print(rs.getInt("Salary") + "\t");
                System.out.println();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the ResultSet, Statement, and Connection
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
