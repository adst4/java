import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
public class Traffic extends JFrame implements Runnable
 {
    JPanel red,yellow,green;
    public Traffic()
    {
        setLayout(new GridLayout(3,1));
        setBounds(200,200,200,200);

        red = new JPanel();
        add(red);

        yellow = new JPanel();
        add(yellow);

        green = new JPanel();
        add(green);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void run()
    {
        try{

            while(true)
            {
                red.setBackground(Color.RED);
                yellow.setBackground(Color.WHITE);
                green.setBackground(Color.WHITE);

                Thread.sleep(2000);

                red.setBackground(Color.WHITE);
                yellow.setBackground(Color.YELLOW);
                green.setBackground(Color.WHITE);

                Thread.sleep(2000);

                red.setBackground(Color.WHITE);
                yellow.setBackground(Color.WHITE);
                green.setBackground(Color.GREEN);

                Thread.sleep(2000);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(new Traffic());
        t.start();
    }
}
