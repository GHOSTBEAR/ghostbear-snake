package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class panel extends JPanel implements ActionListener, KeyListener {
    private snake s;
    private score p;
    private Timer timer;
    private JLabel score;
    private int direction = 37 + ((int)(Math.random() * 4));

    panel(int x) {
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0, 0, 0));
        addKeyListener(this);
        p = new score();
        s = new snake();
        score = new JLabel("Score: ");
        score.setForeground(new Color(0, 255, 0));
        add(score);
        timer = new Timer(x, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocus();
        s.paint(g);
        s.check();
        s.clean();
        p.paint(g);

        g.setColor(new Color(0, 255, 0));
        g.drawRect(9, 39, 201, 201);

        // Checks if snake goes on score
        if (s.getX() == p.getX() && s.getY() == p.getY()) {
            p.setScore();
            p.newX();
            p.newY();
            s.setBody();
            score.setText("Score: " + p.getScore());
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Making snake move right
        if (direction == 39) {
            s.setX(10);
            s.setOldX();
            s.setOldY();
            repaint();
        }

        // Making snake move left
        if (direction == 37) {
            s.setX(-10);
            s.setOldX();
            s.setOldY();
            repaint();
        }

        // Making snake move up
        if (direction == 38) {
            s.setY(-10);
            s.setOldX();
            s.setOldY();
            repaint();
        }

        // Making snake move down
        if (direction == 40) {
            s.setY(10);
            s.setOldX();
            s.setOldY();
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // Make snake go right
        if (e.getKeyCode() == 39) {
            direction = 39;
        }

        // Make snake go left
        if (e.getKeyCode() == 37) {
            direction = 37;
        }

        // Make snake go up
        if (e.getKeyCode() == 38) {
            direction = 38;
        }

        // Make snake go down
        if (e.getKeyCode() == 40) {
            direction = 40;
        }

        // Cheat to get more body parts
        if (e.getKeyCode() == 65) {
            s.setBody();
        }

        // Cheat to get higher score
        if (e.getKeyCode() == 83) {
            p.setScore();
            score.setText("Score: " + p.getScore());
        }

        // Change color of snake head
        if (e.getKeyCode() == 67) {
            s.setColor();
            repaint();
        }

        // Debug to see that scorebox don't go outside inner box
        if (e.getKeyCode() == 81) {
            p.newX();
            p.newY();
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}