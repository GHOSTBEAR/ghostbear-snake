import java.awt.*;
import java.util.List;

public class Snake extends Entity implements Drawable, Movable {

    private static List<Snake> snake = new DrawableList<>();

    Snake(Vector vector, Bound bound, boolean child) {
        super(vector, bound, Color.white);
        if (!child) snake.add(this);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getVector().x, getVector().y, getSize(), getSize());
    }

    @Override
    public void move(int x, int y) {
        if (snake.size() > 1) {
            for (int i = snake.size() - 1; i >= 1; i--) {
                snake.get(i).inherit(snake.get(i - 1));
            }
        }
        getVector().move(x, y);
    }

    boolean collisionWithBody() {
        if (snake.size() == 1) return false;
        Snake head = snake.get(0);
        for (int i = 1; i < snake.size(); i++) {
            if (head.collision(snake.get(i))) {
                return true;
            }
        }
        return false;
    }

    public DrawableList<Snake> getSnake() {
        return (DrawableList<Snake>) snake;
    }

    void grow() {
        snake.add(new Snake(new Vector(-10, -10), getBound(), true));
    }

    void inherit (Snake parent) {
        Vector temp = new Vector(parent.getVector().x, parent.getVector().y);
        setVector(temp);
    }
}


