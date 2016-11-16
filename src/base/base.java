package base;

import javafx.stage.Screen;

import javax.swing.*;

public class base {
    public static void main(String[] args) {
        window h = new window();
        h.setVisible(true);
        h.setSize(220, 270);
        h.setLocation(100, 100);
        h.setTitle("Snake: The new Beginnings");
        h.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}