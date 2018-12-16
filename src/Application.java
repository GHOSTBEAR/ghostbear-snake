import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    private Panel panel;

    public static void main(String[] args) {
        new Application();
    }

    Application() {
        init();
        start();
    }

    private void init() {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(240, 270));
        this.setMinimumSize(new Dimension(240, 270));
        this.setMaximumSize(new Dimension(240, 270));
        this.setLocation(100, 100);
        this.setTitle("Snake: The new Beginnings");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void start() {
        String val = JOptionPane.showInputDialog("Easy: 1\nMedium: 2\nHard: 3\nExtreme: 4").toString();
        switch (val) {
            case "1":
                panel = new Panel(110);
                add(panel);
                break;
            case "2":
                panel = new Panel(90);
                add(panel);
                break;
            case "3":
                panel = new Panel(70);
                add(panel);
                break;
            case "4":
                panel = new Panel(50);
                add(panel);
                break;
            default:
                System.out.println("Wrong input!\nBut I will choose a difficulty for you.");
                int x = (int) (50 + (Math.random() * 50));
                panel = new Panel(x);
                add(panel);
                break;
        }
    }
}

