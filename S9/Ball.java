import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BallPanel extends JPanel {
    private int x = 150;
    private int y = 0;

    public void moveBall() {
        if (y < getHeight()) {
            y += 5;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }
}

class BallFrame extends JFrame {
    private BallPanel ballPanel;

    public BallFrame() {
        setTitle("Moving Ball");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballPanel = new BallPanel();
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        while (true) {
                            ballPanel.moveBall();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);

        setLayout(new BorderLayout());
        add(ballPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

public class Ball {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BallFrame frame = new BallFrame();
                frame.setVisible(true);
            }
        });
    }
}
