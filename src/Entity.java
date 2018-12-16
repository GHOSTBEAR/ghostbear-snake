import java.awt.*;

public abstract class Entity {
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

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean collision(Entity other) {
        return x == other.x && y == other.y;
    }
}
