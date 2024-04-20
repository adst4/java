import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRecordDisplay extends JFrame implements ActionListener {
    private JTextField txtRNo, txtSName, txtPer;
    private JButton btnDisplay;

    public StudentRecordDisplay() {
        setTitle("Display Student Record");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtRNo = new JTextField(10);
        txtSName = new JTextField(10);
        txtPer = new JTextField(10);

        btnDisplay = new JButton("Display");
        btnDisplay.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Roll No:"));
        panel.add(txtRNo);
        panel.add(new JLabel("Name:"));
        panel.add(txtSName);
        panel.add(new JLabel("Percentage:"));
        panel.add(txtPer);
        panel.add(btnDisplay);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            if (rs.next()) {
                txtRNo.setText(rs.getString(1));
                txtSName.setText(rs.getString(2));
                txtPer.setText(rs.getString(3));
            } else {
                JOptionPane.showMessageDialog(this, "No records found.");
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StudentRecordDisplay frame = new StudentRecordDisplay();
                frame.setVisible(true);
            }
        });
    }
}
