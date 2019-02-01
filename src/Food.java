import java.awt.*;

public class Food extends Entity implements Drawable, Movable {
    private int points;

    Food(Vector vector, Bound bound) {
        super(vector, bound, Color.green);
        move();
        setPoints(1);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getVector().x, getVector().y, getSize(), getSize());
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Use move() instead!");
    }

    public void move() {
        getVector().x = getBound().left + (10 * (int) (Math.random() * ((getBound().right - getBound().left) / 10)));
        getVector().y = getBound().top + (10 * (int) (Math.random() * ((getBound().bottom - getBound().top) / 10)));
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
