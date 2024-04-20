import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        try {
            // Establishing connection to the PostgreSQL database
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres", "postgres",
                    "saqlain");

            // Prepare a statement to insert data into the Teacher table
            PreparedStatement insertStmt = conn
                    .prepareStatement("INSERT INTO Teacher (Tno, Tname, Subject) VALUES (?, ?, ?)");

            // Inserting data into the Teacher table
            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "John Doe");
            insertStmt.setString(3, "JAVA");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 2);
            insertStmt.setString(2, "Jane Smith");
            insertStmt.setString(3, "Python");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 3);
            insertStmt.setString(2, "Mike Johnson");
            insertStmt.setString(3, "C++");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 4);
            insertStmt.setString(2, "Sarah Lee");
            insertStmt.setString(3, "JAVA");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 5);
            insertStmt.setString(2, "David Chen");
            insertStmt.setString(3, "PHP");
            insertStmt.executeUpdate();

            // Prepare a statement to retrieve data from the Teacher table
            PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM Teacher WHERE Subject = ?");

            selectStmt.setString(1, "JAVA");
            ResultSet rs = selectStmt.executeQuery();
            while (rs.next()) {
                int tno = rs.getInt("Tno");
                String tname = rs.getString("Tname");
                String subject = rs.getString("Subject");
                System.out.println("Teacher number: " + tno + ", Teacher name: " + tname + ", Subject: " + subject);
            }

            // Closing ResultSet, statements, and connection
            rs.close();
            selectStmt.close();
            insertStmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
