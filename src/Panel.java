import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Panel extends JPanel implements ActionListener, KeyListener {
    private Snake snake;
    private Food food;
    private SuperFood superFood;
    private int direction = 0;
    private Timer timer;

    Panel() {
        setup();
    }

    private void setup() {
        setBackground(new Color(0, 0, 0));
        setLayout(new FlowLayout());
        addKeyListener(this);
        food = new Food();
        superFood = new SuperFood();
        snake = new Snake(0,0);
        timer = new Timer(250, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocus();
        snake.paint(g);
        food.paint(g);
        superFood.paint(g);

        g.setColor(new Color(0xA30000FF, true));
        g.setFont(new Font("PressStart2P-Regular", Font.PLAIN, 16));
        g.drawString(String.valueOf(0), 240/2 - 50, 270/2);
        g.drawString(String.valueOf(0), 240/2 + 50, 270/2);

        // Checks if Snake goes on Food
        if (snake.collision(food)) {
            //food.setScore();
            food.setPosition(0,0);
            snake.grow();
        }

        if (snake.collision(superFood)) {
            //superFood.setScore();
            superFood.setPosition(0,0);
            snake.grow();
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Making Snake move right
        if (direction == 39) {
            snake.move(10, 0);
        }

        // Making Snake move left
        if (direction == 37) {
            snake.move(-10, 0);
        }

        // Making Snake move up
        if (direction == 38) {
            snake.move(0,-10);
        }

        // Making Snake move down
        if (direction == 40) {
            snake.move(0,10);
        }

        repaint();
    }

//    private int getHighScore() {
//        int scorehigh = 0;
//        try {
//            File x = new File("highscore.txt");
//            Scanner sc = new Scanner(x);
//            while (sc.hasNext()) {
//                int high = Integer.parseInt(sc.next());
//                if (food.getScore() > high) {
//                    scorehigh = food.getScore();
//                } else {
//                    scorehigh = high;
//                }
//            }
//            sc.close();
//        } catch (FileNotFoundException e) {
//            new Death(0);
//        }
//        return scorehigh;
//    }

    public void keyTyped(KeyEvent e) {}

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
            snake.grow();
        }

        // Cheat to get higher Food
//        if (e.getKeyCode() == 70) {
//            food.setScore();
//            Food.score++;
//        }

        // Change color of Snake head
//        if (e.getKeyCode() == 67) {
//            snake.setColor();
//            repaint();
//        }

        // Debug to see that scorebox don't go outside inner box
//        if (e.getKeyCode() == 81) {
//            food.newX();
//            food.newY();
//            repaint();
//        }

        // Pause button
//        if (e.getKeyCode() == 80) {
//            if (!gamePaused) {
//                timer.stop();
//                gamePaused = true;
//            } else {
//                timer.start();
//                gamePaused = false;
//            }
//        }
    }

    public void keyReleased(KeyEvent e) {}
}