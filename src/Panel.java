import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Panel extends JPanel implements ActionListener, KeyListener {
    private Snake s;
    private Score p;
    private JLabel score;
    private int direction = 37 + ((int)(Math.random() * 4));

    Panel(int x) {
        this.setBackground(new Color(0, 0, 0));
        addKeyListener(this);
        p = new Score();
        s = new Snake();
        score = new JLabel("Score: ");
        score.setForeground(new Color(0, 255, 0));
        add(score);
        Timer timer = new Timer(x, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocus();
        p.paint(g);
        s.paint(g);
        s.check();
        s.clean();

        g.setColor(new Color(0, 255, 0));
        g.drawRect(9, 39, 201, 201);

        // Checks if Snake goes on Score
        if (s.getX() == p.getX() && s.getY() == p.getY()) {
            p.setScore();
            p.newX();
            p.newY();
            s.setBody();
            score.setText("Score: " + p.getScore());
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Making Snake move right
        if (direction == 39) {
            s.setX(10);
            s.setOldX();
            s.setOldY();
            repaint();
        }

        // Making Snake move left
        if (direction == 37) {
            s.setX(-10);
            s.setOldX();
            s.setOldY();
            repaint();
        }

        // Making Snake move up
        if (direction == 38) {
            s.setY(-10);
            s.setOldX();
            s.setOldY();
            repaint();
        }

        // Making Snake move down
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
        // Make Snake go right
        if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
            direction = 39;
        }

        // Make Snake go left
        if (e.getKeyCode() == 37 || e.getKeyCode() == 65) {
            direction = 37;
        }

        // Make Snake go up
        if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
            direction = 38;
        }

        // Make Snake go down
        if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
            direction = 40;
        }

        // Cheat to get more body parts
        if (e.getKeyCode() == 66) {
            s.setBody();
        }

        // Cheat to get higher Score
        if (e.getKeyCode() == 83) {
            p.setScore();
            score.setText("Score: " + p.getScore());
        }

        // Change color of Snake head
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