package snake;

import snake.entity.Fruit;
import snake.entity.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener {

    public static final Integer GRID_SIZE = 20;
    public static final Integer FRAME_SIZE = 500;
    public static final Dimension FRAME_DIMENSION = new Dimension(FRAME_SIZE + 1, FRAME_SIZE + 1);

    private Controller controller;

    private ArrayList<Drawable> drawables = new ArrayList<>();

    private Snake snake = new Snake(12 * GRID_SIZE, 12 * GRID_SIZE, GRID_SIZE);
    private ArrayList<Fruit> fruits = FruitHelper.getArray(new Fruit(FRAME_DIMENSION, snake, GRID_SIZE), 2);

    private static Timer timer;
    private boolean gameEnded = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setSize(FRAME_DIMENSION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dimension.width / 2 - frame.getSize().width / 2,
                dimension.height / 2 - frame.getSize().height / 2);

        Game game = new Game(frame);
        timer = new Timer(600, game);
        timer.start();
    }

    public Game(JFrame frame) {
        setSize(FRAME_DIMENSION);
        frame.add(this);
        requestFocus();

        controller = new Controller();
        addKeyListener(controller);

        drawables.addAll(fruits);
        drawables.add(snake);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // DRAW
        setBackground(Color.BLACK);

        for (Drawable drawable : drawables) {
            drawable.draw(g);
        }

        if (gameEnded) {
            String fName = Paths.get("").toAbsolutePath().toString() + "/src/snake/font/PressStart2P-Regular.ttf";
            File is = new File(fName);
            try {
                g.setFont(Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(16f));
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }
            g.drawString("Game Over", 10, 20);
            g.drawString("Score: " + snake.size(), 10, 35);
        }

        g.setColor(new Color(16, 16, 16));
        for (int x = 0; x < FRAME_SIZE / GRID_SIZE; x++) {
            for (int y = 0; y < FRAME_SIZE / GRID_SIZE; y++) {
                g.drawRect(x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Snake.Body head = snake.getHead();

        Direction direction = controller.getDirection();

        if (direction != null) {
            switch (direction) {
                case WEST:
                    snake.move(head.getX() - GRID_SIZE, head.getY());
                    break;
                case NORTH:
                    snake.move(head.getX(), head.getY() - GRID_SIZE);
                    break;
                case EAST:
                    snake.move(head.getX() + GRID_SIZE, head.getY());
                    break;
                case SOUTH:
                    snake.move(head.getX(), head.getY() + GRID_SIZE);
                    break;
            }
        }

        for (Fruit fruit : fruits) {
            if (snake.collision(fruit)) {
                snake.grow();
                fruit.randomPosition();
            }
        }

        if (snake.collision(snake)) {
            gameEnded = true;
            repaint();
            timer.stop();
        }

        if (head.getX() < 0) {
            head.setX(FRAME_SIZE - GRID_SIZE);
        }

        if (head.getY() < 0) {
            head.setY(FRAME_SIZE - GRID_SIZE);
        }

        if (head.getX() > FRAME_SIZE - 2) {
            head.setX(0);
        }

        if (head.getY() > FRAME_SIZE - 2) {
            head.setY(0);
        }

        repaint();
    }
}
