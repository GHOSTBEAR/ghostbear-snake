import java.awt.*;
import java.util.ArrayList;

class DrawableList<T extends Drawable> extends ArrayList<T> implements Drawable {

    @Override
    public void draw(Graphics graphics) {
        forEach(t -> t.draw(graphics));
    }
}
