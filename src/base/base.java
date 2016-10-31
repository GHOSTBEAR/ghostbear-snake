package base;

import javafx.stage.Screen;

import javax.swing.*;

public class base {
    public static void main(String[] args) {
        window h = new window();
        h.setVisible(true);
        h.setSize(220, 270);
        h.setLocation(500, 100);
        h.setTitle("Hello World!");
        h.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}