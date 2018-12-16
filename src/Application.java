import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    public static void main(String[] args) {
        new Application();
    }

    Application() {
        start();
        init();
    }

    private void init() {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(240, 270));
        this.setMinimumSize(new Dimension(240, 270));
        this.setMaximumSize(new Dimension(240, 270));
        this.setLocation(100, 100);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void start() {
        this.add(new Panel());
    }
}

