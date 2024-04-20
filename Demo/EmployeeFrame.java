import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class EmployeeFrame  extends JFrame implements ActionListener
{
    JLabel eno,ename,edest,esal;
    JTextField  tno,tname,tdest,tsal;
    JButton insert,display;
    JTextArea result;

   public EmployeeFrame()
    {
        setLayout(new FlowLayout());
        setBounds(200,200,340,400);

        eno = new JLabel("ENO :");
        add(eno);

        tno = new JTextField(20);
        add(tno);



        ename = new JLabel("Employee Name :");
        add(ename);

        tname =  new JTextField(20);
        add(tname);

        edest = new JLabel("Destination : ");
        add(edest);
           
        tdest  = new JTextField(20);
        add(tdest);



        esal=new JLabel("Salary : ");
        add(esal);

        tsal=new JTextField(20);
        add(tsal);

        insert=new JButton("insert");
        add(insert);

        display=new JButton("Display");
        add(display);


        result=new JTextArea(10,30);
        add(result);
    
        insert.addActionListener(this);
        display.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent Ae)
    {
        String ans = "";
        String no = tno.getText();
        String name =tname.getText();
        String dest =tdest.getText();
        String salary = tsal.getText();

        Connection con = null;
        PreparedStatement stmt = null;
        if(Ae.getSource() == insert)
        {
            try{
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc1","postgres","7374");
                stmt = con.prepareStatement("insert into employee values(?,?,?,?)");

                stmt.setInt(1,Integer.parseInt(no));
                stmt.setString(2,name);
                stmt.setString(3,dest);
                stmt.setFloat(4,Float.parseFloat(salary));

                stmt.executeUpdate();

                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        } 
        if(Ae.getSource() == display)
        {
            Statement st =null;
            ResultSet rs = null;
            try
            {       
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc1","postgres","7374");
                st = con.createStatement();
                rs = st.executeQuery("select * from employee");

                ans="no\tname\tdestination\tsalary\n";
                
                while(rs.next()){

                    ans+=rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t" +rs.getFloat(4)+"\n";
                }

                result.setText(ans);
            }
            catch(Exception ae)
            {
                System.out.println(ae);
            }   
        }
    }

    public static void main(String[] args) {
        new EmployeeFrame();
    }
}
