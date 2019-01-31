import java.awt.*;

public class Entity {
    private Vector vector;
    private Bound bound;
    private Color color = Color.white;
    private int size = 10;

    Entity(Vector vector, Bound bound) {
        this.vector = vector;
        this.bound = bound;
    }

    Entity(Vector vector, Bound bound, Color color) {
        this.vector = vector;
        this.color = color;
        this.bound = bound;
    }

    public Bound getBound() {
        return bound;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    boolean outOfBounds() {
        return vector.y > bound.bottom || vector.x > bound.right || vector.y < bound.top || vector.x < bound.left;
    }

    boolean collision(Entity other) {
        return vector.x == other.vector.x && vector.y == other.vector.y;
    }
}
