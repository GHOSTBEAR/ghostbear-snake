package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

class panel extends JPanel implements ActionListener, KeyListener {
    private snake s;
    private Timer timer;
    private ArrayList<String> snakesBody = new ArrayList<>();
    private ArrayList<Integer> oldValueX = new ArrayList<>();
    private ArrayList<Integer> oldValueY = new ArrayList<>();
    private JLabel score;
    private int snakeY = 100, snakeX = 100,
            userScore = 0,
            snakeDirection = 39,
            scoreX = 10 + (10 * (int) (Math.random() * 19)),
            scoreY = 40 + (10 * (int) (Math.random() * 19)),
            colorRed = 0,
            colorBlue = 0,
            colorGreen = 255;

    panel(int x) {
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0, 0, 0));
        addKeyListener(this);
        score = new JLabel("Score: ");
        score.setForeground(new Color(0, 255, 0));
        add(score);
        timer = new Timer(x, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocus();

        // Check if snake head goes into body
        try {
            for (int i = 0; i < snakesBody.size(); i++) {
                int a = oldValueX.get((oldValueX.size() - 2) - i);
                int b = oldValueY.get((oldValueY.size() - 2) - i);
                if (a == snakeX && b == snakeY) {
                    System.out.println("Killed in Action");
                    death(userScore);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Nothing to worry about\nLine: 61");
        }

        // Draws snakes body
        try {
            for (int i = 0; i < snakesBody.size(); i++) {
                int a = oldValueX.get((oldValueX.size() - 2) - i);
                int b = oldValueY.get((oldValueY.size() - 2) - i);
                if (i < 254) {
                    s = new snake(g, a, b, i, 255, i);
                } else {
                    s = new snake(g, a, b, 255 - (i - 253), 255, 255 - (i - 253));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Nothing to worry about\nLine: 76");
        }

        // Draws score box and snake
        s = new snake(g, scoreX, scoreY, 255, 0, 0); // Score
        s = new snake(g, snakeX, snakeY, colorRed, colorGreen, colorBlue); // Snake

        // Checks if snake goes on score
        if (snakeX == scoreX && snakeY == scoreY) {
            userScore++;
            snakesBody.add(" ");
            scoreX = s.randomizer(10, 10, 19);
            scoreY = s.randomizer(40, 10, 19);
            score.setText("Score: " + userScore);
        }

        // Checks if snake goes outside outer line
        if (snakeY > 231 || snakeX > 201 || snakeY < 39 || snakeX < 9) {
            death(userScore);
        }

        // Draws outer line
        g.setColor(new Color(0, 255, 0));
        g.drawRect(9, 39, 201, 201);
        try {
            for (int i = oldValueX.size() - snakesBody.size() - 5; i > 0; i--) {
                oldValueX.remove(i);
                // System.out.print(oldValueX);
            }
        } catch (Exception e) {
            System.out.print("Error: Nothing to worry about\nLine: 106");
        }

        try {
            for (int i = oldValueY.size() - snakesBody.size() - 5; i > 0; i--) {
                oldValueY.remove(i);
                // System.out.print(oldValueY);
            }
        } catch (Exception e) {
            System.out.print("Error: Nothing to worry about\nLine: 115");
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Making snake move right
        if (snakeDirection == 39) {
            snakeX += 10;
            oldValueX.add(snakeX);
            oldValueY.add(snakeY);
            repaint();
        }

        // Making snake move left
        if (snakeDirection == 37) {
            snakeX -= 10;
            oldValueX.add(snakeX);
            oldValueY.add(snakeY);
            repaint();
        }

        // Making snake move up
        if (snakeDirection == 38) {
            snakeY -= 10;
            oldValueX.add(snakeX);
            oldValueY.add(snakeY);
            repaint();
        }

        // Making snake move down
        if (snakeDirection == 40) {
            snakeY += 10;
            oldValueX.add(snakeX);
            oldValueY.add(snakeY);
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // Make snake go right
        if (e.getKeyCode() == 39) {
            snakeDirection = 39;
        }

        // Make snake go left
        if (e.getKeyCode() == 37) {
            snakeDirection = 37;
        }

        // Make snake go up
        if (e.getKeyCode() == 38) {
            snakeDirection = 38;
        }

        // Make snake go down
        if (e.getKeyCode() == 40) {
            snakeDirection = 40;
        }

        // Cheat to get more body parts
        if (e.getKeyCode() == 65) {
            snakesBody.add("");
        }

        // Cheat to get higher score
        if (e.getKeyCode() == 83) {
            userScore++;
            score.setText("Score: " + userScore);
        }

        // Change color of snake head
        if (e.getKeyCode() == 67) {
            colorRed = (int) (Math.random() * 255);
            colorBlue = (int) (Math.random() * 255);
            colorGreen = (int) (Math.random() * 255);
            repaint();
        }

        // Debug to see that scorebox don't go outside inner box
        if (e.getKeyCode() == 81) {
            scoreX = s.randomizer(10, 10, 19);
            scoreY = s.randomizer(40, 10, 19);
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void death(int score) {
        // Death by metal
        System.out.println("Game over");
        System.out.println("Your Score: " + score);
        try {
            File x = new File("highscore.txt");
            Scanner sc = new Scanner(x);
            while (sc.hasNext()) {
                int tovig = Integer.parseInt(sc.next());
                if (tovig < score) {
                    System.out.println("New High Score: " + score);
                    Formatter f = new Formatter("highscore.txt");
                    f.format("%s", score);
                    f.close();
                } else {
                    System.out.println("High Score: " + tovig);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            try {
                Formatter f = new Formatter("highscore.txt");
                f.format("%s", score);
                f.close();
            } catch (Exception c) {
                System.out.println("Error");
            }
        }
        System.exit(0);
    }
}
