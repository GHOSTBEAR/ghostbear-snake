import java.awt.*;

public class SuperFood extends Food {

    private long start = System.currentTimeMillis();
    private boolean should = true;

    SuperFood(Vector vector, Bound bound) {
        super(vector, bound);
        setPoints(2);
    }

    @Override
    public void draw(Graphics graphics) {
        if (System.currentTimeMillis() - start > 20000) {
            if(should) {
                move();
                should = false;
            }
        }
        super.draw(graphics);
    }
}
