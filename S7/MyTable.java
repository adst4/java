import java.util.*;
import java.sql.*;
public class MyTable {
    public static void main(String[] args) {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;

        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc","postgres","7374");
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from Product");
            System.out.println("PID\tNAME\tPRICE");
            while (rs.next()) {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

// create database jdbc;

// \c jdbc

// create table product(pid int,name varchar(20),price int);

// insert into product values(5,'sabun',50);
