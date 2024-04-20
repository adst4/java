import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyCityFrame extends JFrame implements ActionListener
{
          JLabel l1,l2;
          JTextField t1,t2;
          JButton b1,b2,b3;
          JPanel p1,p2;
          JTextArea  result1;
          
          
          Hashtable ht = new Hashtable();
          
          public MyCityFrame()
          {
                    setLayout(new GridLayout(3,1));
                    setBounds(400,400,500,300);
                    p1 = new JPanel();
                    p2= new JPanel();
          
                    l1 = new JLabel("City");
                    l2 = new JLabel("STD Code");
                    
                    t1 = new JTextField(20);
                    t2 = new JTextField(20);
                    
                    p1.setLayout(new GridLayout(2,2));
                    p1.add(l1);
                    p1.add(t1);
                    p1.add(l2);
                    p1.add(t2);
                    add(p1);
                    
                    
                    b1 = new JButton("ADD");
                    b2 = new JButton("REMOVE");
                    b3 = new JButton("SEARCH");
                    
                    p2.setLayout(new GridLayout(1,3));
                    p2.add(b1);
                    p2.add(b2);
                    p2.add(b3);
                    add(p2);
                    
                    
                    result1 = new JTextArea(3,3);
                    add(result1);
                    result1.setEditable(false);
                    
                    b1.addActionListener(this);
                    b2.addActionListener(this);
                    b3.addActionListener(this);
           
                    setVisible(true);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
          }

          
          public void actionPerformed(ActionEvent e)
          {
                    String city = t1.getText();
                    String std = t2.getText();
                    String result = "";
                    if(e.getSource() == b1)
                    {
                              ht.put(city , std);
                              Set s = ht.keySet();
                              Iterator itr = s.iterator();
                              
                              
                              result = "CITY\t\tSTD\n";
                              while(itr.hasNext())
                              {
                                        Object o = itr.next();
                                        result += o +"\t\t" +ht.get(o) +"\n";
                              }
                              t1.setText("");
                              t2.setText("");
                              result1.setText("" +result);                                                                                              
                    }
                    
                    if(e.getSource() == b2)
                    {
                              ht.remove(city);
              
                              Set s = ht.keySet();
                              Iterator itr = s.iterator();
                              
                              
                              result = "CITY\t\tSTD\n";
                              while(itr.hasNext())
                              {
                                        Object o = itr.next();
                                        result += o +"\t\t" +ht.get(o) +"\n";
                              }
                              t1.setText("");
                              t2.setText("");
                              result1.setText("" +result);                                                                                              
                    }
                    
                    if(e.getSource() == b3)
                    {
                              Set s = ht.keySet();
                              Iterator itr = s.iterator();
             
                              result = "CITY\t\tSTD\n";
                              while(itr.hasNext())
                              {
                                        Object o = itr.next();
                                        if(o.equals(city))
                                                  result += o +"\t\t" +ht.get(o) +"\n";
                              }
                              t1.setText("");
                              t2.setText("");
                              result1.setText("" +result);                                                                                              
                    }
          }

          public static void main(String args[])
          {     
                    new MyCityFrame();         
          }
}