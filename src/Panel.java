import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements ActionListener, KeyListener {
    private Bound bound;
    private Snake snake;
    private Food food;
    private SuperFood superFood;
    private int direction = 0;
    private Timer timer;


    public Panel() {
        setBackground(Color.black);
        setLayout(new FlowLayout());
        addKeyListener(this);
        bound = new Bound(0, 240, 240, 0);
        snake = new Snake(new Vector(10,10), bound, false);
        food = new Food(new Vector(-10, -10), bound);
        superFood = new SuperFood(new Vector(-10, -10), bound);
        timer = new Timer(250, this);
        timer.start();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.requestFocus();

        food.draw(graphics);
        superFood.draw(graphics);
        snake.getSnake().draw(graphics);
        snake.draw(graphics);

        if(snake.outOfBounds()) {
            System.out.println("You out!");
            System.exit(1);
        }

        if (food.collision(snake)) {
            System.out.println("Snake grew!");
            food.move();
            snake.grow();
        }

        if (superFood.collision(snake)) {
            System.out.println("Snake grew!");
            superFood.move();
            snake.grow();
        }

        if (snake.collisionWithBody()) {
            System.out.println("Don't try eat yourself!");
            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Making Snake move right
        System.out.println(". " + direction);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Make Snake go right
        System.out.println(e.getKeyCode());
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

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
