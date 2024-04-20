import java.util.*;
import javax.swing.*;
import java.awt.*;
public class BinkTextFrame extends JFrame implements Runnable
{
    Label l;
    public BinkTextFrame()
    {
        setLayout(new FlowLayout());
        setBounds(200,200,200,200);
        l = new Label("Hello World");
        add(l);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run()
    {
        try
        {
            while(true)
            {
                l.setVisible(false);
                Thread.sleep(500);
                l.setVisible(true);
                Thread.sleep(500);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
       BinkTextFrame bt =  new BinkTextFrame();
        Thread t = new Thread(bt);
        t.start();
    }
}
