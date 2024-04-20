import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageFrame extends JFrame implements Runnable
{
	ImageIcon i;
	JLabel l;
	public ImageFrame()
	{
		setBounds(200,200,200,200);
		l = new JLabel("");
		i = new ImageIcon("j1.jpg");
		
		l.setIcon(i);
		l.setSize(50,50);
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
				l.setIcon(null);
				Thread.sleep(50);
				
				l.setIcon(i);
				Thread.sleep(50);
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	public static void main(String args[])
	{
		Thread t = new Thread(new ImageFrame());
		t.start();
	}

}
