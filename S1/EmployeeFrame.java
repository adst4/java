import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class EmployeeFrame extends JFrame implements ActionListener
{
    JLabel lid,lname,lsal,ldest;
    JTextField tid,tname,tsal,tdest;
    JButton in,del,show;
    JTextArea result;    

    public EmployeeFrame()
    {
        setLayout(new FlowLayout());
        setTitle("Employee");
        setBounds(400,400,400,400);


        lid = new JLabel("Employee Id : ");
        add(lid);

        tid = new JTextField(20);
        add(tid);

        lname = new JLabel("Employee Name : ");
        add(lname);

        tname = new JTextField(20);
        add(tname);

        lsal = new JLabel("Employee Salary : ");
        add(lsal);

        tsal = new JTextField(20);
        add(tsal);

        ldest = new JLabel("Employee Destination : ");
        add(ldest);

        tdest = new JTextField(20);
        add(tdest);

        in = new JButton("Insert");
        del = new JButton("Delete");
        show = new JButton("Display");

        add(in);
        add(del);
        add(show);

        result = new JTextArea(15,25);
        add(result);




        in.addActionListener(this);
        del.addActionListener(this);
        show.addActionListener(this);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
            

    
        
        String disResult="";
    
        try{
            Connection con;
            Statement stmt;
            ResultSet rs;
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc","postgres","7374");
            stmt = con.createStatement();

                if(e.getSource()==in)
                {
                    try{
                        int eid = Integer.parseInt(tid.getText());
                        String ename = tname.getText();
                        float esalary = Float.parseFloat(tsal.getText());
                        String edest = tdest.getText();
                        stmt.executeUpdate("INSERT INTO employee VALUES (" + eid + ", '" + ename + "', " + esalary + ", '" + edest + "')");
                        disResult="Record inserted successfully";
                    }catch(SQLException sqle){
                        disResult="employee already exist";
                    }  

                    result.setText(disResult);

                }
                else if (e.getSource()==del) 
                {
                    try{
                    int eid = Integer.parseInt(tid.getText());
                    String ename = tname.getText();
                    float esalary = Float.parseFloat(tsal.getText());
                    int ans = stmt.executeUpdate("delete from employee where id="+eid);
                        if(ans==0)
                                disResult = "Given id is not present";
                            else
                                disResult="Record deleted successfully";
                                result.setText(disResult);
                            }catch(SQLException sqle){
                                disResult="employee already exist";
                            }  
                }
                else
                {
                    rs = stmt.executeQuery("select * from employee");
                    if(rs.isBeforeFirst()){
                        disResult="ID\tNAME\tSALARY\tDESTINATION";
                        while(rs.next()){
                            disResult=disResult +"\n" +rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4);
                        }
                    }else   
                        disResult = "There is nothing to view";
                    result.setText(disResult);
                }



        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new EmployeeFrame();
    }

}
