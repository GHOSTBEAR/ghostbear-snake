import java.awt.*;
import java.util.ArrayList;
import java.util.List;


class Snake {
    private List<SnakeBody> bodies = new ArrayList<>();

    Snake(int x, int y) {
        bodies.add(new SnakeBody(x, y));
    }

    void move(int x, int y) {
        if (bodies.size() > 1) {
            for (int i = bodies.size() - 1; i > 0; i--) {
                bodies.get(i).inherit(bodies.get(i - 1));
            }
        }
        bodies.get(0).setPosition(x, y);
    }

    void paint(Graphics g) {
        bodies.forEach(b -> b.paint(g));
    }

    boolean outOfBounds() {
        SnakeBody first = bodies.get(0);
        return first.getY() > 211 || first.getX() > 201 || first.getY() < 19 || first.getX() < 9;
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
        bodies.add(new SnakeBody(-10,-10));
    }

    void clean() {
        bodies.clear();
        bodies.add(new SnakeBody(10, 10));
    }
}
