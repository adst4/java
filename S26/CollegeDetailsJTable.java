import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CollegeDetailsJTable extends JFrame {

    // Database connection details
    static final String DB_URL = "jdbc:mysql://localhost:3306/college";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "password";

    public CollegeDetailsJTable() {
        super("College Details");

        // Create a JTable
        JTable table = new JTable();

        // Set column names for the table
        String[] columnNames = { "CID", "CName", "Address", "Year" };

        // Create a default table model with the column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add data to the table model
        try {
            // Create a database connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query to get college details
            ResultSet rs = stmt.executeQuery("SELECT * FROM college");

            // Add each row to the table model
            while (rs.next()) {
                String cid = rs.getString("CID");
                String cname = rs.getString("CName");
                String address = rs.getString("Address");
                int year = rs.getInt("Year");
                model.addRow(new Object[] { cid, cname, address, year });
            }

            // Close the result set, statement and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the table model to the JTable
        table.setModel(model);

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        getContentPane().add(scrollPane);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new CollegeDetailsJTable();
    }
}
