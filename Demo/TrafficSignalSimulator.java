import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TrafficSignalSimulator extends JFrame implements Runnable {
    private JLabel redLight, yellowLight, greenLight;
    private final String[] colors = {"RED", "YELLOW", "GREEN"};
    private final Random random = new Random();

    public TrafficSignalSimulator() {
        setTitle("Traffic Signal Simulator");
        setSize(200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        redLight = new JLabel();
        yellowLight = new JLabel();
        greenLight = new JLabel();

        add(redLight);
        add(yellowLight);
        add(greenLight);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Sleep for a random duration to simulate traffic light changes
                Thread.sleep(random.nextInt(5000) + 3000);

                // Change the color of the traffic lights
                SwingUtilities.invokeLater(() -> {
                    int index = random.nextInt(colors.length);
                    String color = colors[index];
                    if (color.equals("RED")) {
                        setLightColor(redLight, Color.RED);
                        setLightColor(yellowLight, Color.BLACK);
                        setLightColor(greenLight, Color.BLACK);
                    } else if (color.equals("YELLOW")) {
                        setLightColor(redLight, Color.BLACK);
                        setLightColor(yellowLight, Color.YELLOW);
                        setLightColor(greenLight, Color.BLACK);
                    } else if (color.equals("GREEN")) {
                        setLightColor(redLight, Color.BLACK);
                        setLightColor(yellowLight, Color.BLACK);
                        setLightColor(greenLight, Color.GREEN);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setLightColor(JLabel light, Color color) {
        light.setBackground(color);
        light.setOpaque(true);
        light.setPreferredSize(new Dimension(50, 50));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrafficSignalSimulator simulator = new TrafficSignalSimulator();
            simulator.setVisible(true);
        });
    }
}
