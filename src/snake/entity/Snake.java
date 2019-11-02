package snake.entity;

import snake.Drawable;
import snake.Movable;

import java.awt.*;
import java.util.ArrayList;

public class Snake extends Entity implements Drawable, Movable {

    private final Integer size;
    private ArrayList<Body> bodies = new ArrayList<>();

    public Snake(int x, int y, int size) {
        this.size = size;
        bodies.add(new Body(x, y));
    }

    public Body getHead() {
        return bodies.get(0);
    }

    private void inherit() {
        for (int i = bodies.size() - 1; i >= 1; i--) {
            bodies.get(i).inherit(bodies.get(i - 1));
        }
    }

    public void grow() {
        bodies.add(new Body(-20, -20));
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        for (Body body : bodies) {
            body.draw(graphics);
        }
    }

    @Override
    public boolean collision(Entity entity) {
        for (Body body : bodies) {
            if (body.collision(entity)) {
                return true;
            }
        }
        return false;
    }

    public boolean collision(Snake snake) {
        for (int i = 1; i < bodies.size(); i++) {
            Body body = bodies.get(i);
            if (body.collision(getHead())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(int x, int y) {
        inherit();
        bodies.get(0).move(x, y);
    }

    public int size() {
        return bodies.size();
    }

    public class Body extends Entity implements Drawable, Movable {

        public Body(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void inherit(Body parent) {
            x = parent.x;
            y = parent.y;
        }

        @Override
        public void draw(Graphics graphics) {
            graphics.fillRect(x, y, size, size);
        }

        @Override
        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
