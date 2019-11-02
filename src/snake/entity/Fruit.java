package snake.entity;

import snake.Drawable;

import java.awt.*;
import java.util.Random;

public class Fruit extends Entity implements Drawable {

    private final Dimension bounds;
    private final Snake snake;
    private final Integer size;

    public Fruit(Dimension bounds, Snake snake, int size) {
        this.bounds = bounds;
        this.snake = snake;
        this.size = size;
        randomPosition();
    }

    public Fruit(Fruit fruit) {
        bounds = fruit.bounds;
        snake = fruit.snake;
        size = fruit.size;
        randomPosition();
    }

    public void randomPosition() {
        int grid = bounds.height / size;

        Random random = new Random();
        x = random.nextInt(grid) * size;
        y = random.nextInt(grid) * size;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x, y, size, size);
    }
}
