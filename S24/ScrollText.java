import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ScrollText extends JFrame implements Runnable
{
	JLabel l;
	public ScrollText()
	{
		setLayout(new FlowLayout());
		setBounds(400,400,400,400);
		l = new JLabel("HELLO JAVA");
		add(l);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void run()
	{
		try
		{
			while(true)
			{
				l.setLocation(0,50);
				Thread.sleep(200);
				
				l.setLocation(100,50);
				Thread.sleep(200);
				
				l.setLocation(200,50);
				Thread.sleep(200);
				
				l.setLocation(300,50);
				Thread.sleep(200);
				
				l.setLocation(400,50);
				Thread.sleep(200);
				
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	

	public static void main(String args[])
	{
		Thread t = new Thread(new ScrollText());
		t.start();
	}

}
