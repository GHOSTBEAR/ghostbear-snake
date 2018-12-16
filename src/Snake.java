import java.awt.*;
import java.util.ArrayList;
import java.util.List;


abstract class Entity {
    private int x;
    private int y;
    private int size;
    private Color color;

    abstract void paint(Graphics graphics);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPostion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean collision(Entity other) {
        return x == other.x && y == other.y;
    }
}

class SnakeBody extends Entity {

    SnakeBody(int x, int y) {
        setPostion(x, y);
        setSize(10);
        setColor(new Color(0, 255, 0));
    }

    void paint(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getY(), getY(), getSize(), getSize());
    }

    @Override
    public void setPostion(int x, int y) {
        super.setPostion(getX() + x, getY() + y);
    }

    void inherit(SnakeBody inherit) {
        setPostion(inherit.getX(), inherit.getY());
    }
}

class Snake {
    private List<SnakeBody> bodies = new ArrayList<>();

    Snake(int x, int y) {
        bodies.add(new SnakeBody(x, y));
    }

    void move(int x, int y) {
        for (int i = bodies.size() - 1; i >= 1; i--) {
            bodies.get(i).inherit(bodies.get(--i));
        }
        bodies.get(0).setPostion(x, y);
    }

    void paint(Graphics g) {
        bodies.forEach(b -> b.paint(g));
    }

    boolean outOfBounds() {
        SnakeBody first = bodies.get(0);
        if (first.getY() > 211 || first.getX() > 201 || first.getY() < 19 || first.getX() < 9) {
            return true;
        }
        return false;
    }

    boolean collisionWithSelf() {
        for (int i = 1; i < bodies.size(); i++) {
            if (bodies.get(0).collision(bodies.get(--i))) {
                return true;
            }
        }
        return false;
    }

    boolean collision(Entity other) {
        for (SnakeBody b : bodies) {
            if (b.collision(other)) {
                return true;
            }
        }
        return false;
    }

    void grow() {
        SnakeBody last = bodies.get(bodies.size() - 1);
        SnakeBody newGuy = new SnakeBody(0,0);
        newGuy.inherit(last);
        bodies.add(newGuy);
    }

    void clean() {
        bodies.clear();
        bodies.add(new SnakeBody(10, 10));
    }
}
