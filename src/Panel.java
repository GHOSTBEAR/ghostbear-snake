import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Panel extends JPanel implements ActionListener, KeyListener {
    private Snake s;
    private Food p;
    private Hallon h;
    private int direction = 37 + ((int) (Math.random() * 4));
    private Font ofl;
    private Timer timer;
    boolean gamePaused = false;

    Panel(int x) {
        this.setBackground(new Color(0, 0, 0));
        this.setLayout(new FlowLayout());
        addKeyListener(this);
        ofl = new Font("PressStart2P-Regular", Font.PLAIN, 8);
        p = new Food();
        s = new Snake();
        h = new Hallon();
        timer = new Timer(x, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocus();
        p.paint(g);
        h.paint(g);
        s.paint(g);
        s.check();
        s.clean();

        g.setFont(ofl);
        g.drawString("Score: " + p.getScore(), 10, 14);
        g.drawString("Highscore: " + getHighScore(), 100, 14);

        g.setColor(new Color(0, 255, 0));
        g.drawRect(9, 19, 201, 201);

        for (int i = 0; i < 230; i += 2) {
            g.setColor(new Color(50, 50, 50, 50));
            g.drawLine(0, i, 220, i);
        }

        ArrayList<Integer> tmpX = s.getOldX();
        ArrayList<Integer> tmpY = s.getOldY();

        for (int i = 0; i < s.getLength(); i++) {
            if (tmpX.get(i) == p.getX() && tmpY.get(i) == p.getY()) {
                p.newX();
                p.newY();
            } else if (tmpX.get(i) == h.getX() && tmpY.get(i) == h.getY()) {
                h.newY();
                h.newX();
            }
        }

        // Checks if Snake goes on Food
        if (s.getX() == p.getX() && s.getY() == p.getY()) {
            p.setScore();
            p.newX();
            p.newY();
            s.setBody();
        }

        if (s.getX() == h.getX() && s.getY() == h.getY()) {
            h.setScore();
            h.setStart();
            s.setBody();
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

    private int getHighScore() {
        int scorehigh = 0;
        try {
            File x = new File("highscore.txt");
            Scanner sc = new Scanner(x);
            while (sc.hasNext()) {
                int high = Integer.parseInt(sc.next());
                if (p.getScore() > high) {
                    scorehigh = p.getScore();
                } else {
                    scorehigh = high;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            new Death(0);
        }
        return scorehigh;
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

        // Cheat to get higher Food
        if (e.getKeyCode() == 70) {
            p.setScore();
            Food.score++;
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

        // Pause button
        if (e.getKeyCode() == 80) {
            if (!gamePaused) {
                timer.stop();
                gamePaused = true;
            } else {
                timer.start();
                gamePaused = false;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}