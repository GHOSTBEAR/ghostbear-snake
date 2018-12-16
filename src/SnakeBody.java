import java.awt.*;

public class SnakeBody extends Entity {

    SnakeBody(int x, int y) {
        setPosition(x, y);
        setSize(10);
        setColor(new Color(0, 255, 0));
    }

    void paint(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getX(), getY(), getSize(), getSize());
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(getX() + x, getY() + y);
    }

    void inherit(SnakeBody inherit) {
        super.setPosition(inherit.getX(), inherit.getY());
    }
}
