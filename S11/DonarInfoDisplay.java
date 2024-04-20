import java.sql.*;

public class DonarInfoDisplay {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DONAR");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            System.out.println("Column Information:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + rsmd.getColumnName(i));
                System.out.println("Data Type: " + rsmd.getColumnTypeName(i));
                System.out.println("Column Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("---------------------------------------");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
