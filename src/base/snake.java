package base;

import java.awt.*;

class snake {
     snake(Graphics graphics, int x, int y, int r, int b, int g) {
        graphics.setColor(new Color(r, b, g));
        graphics.fillRect(x, y, 9, 9);
    }
    int randomizer(int x, int y, int z) {
        return x + (y * (int) (Math.random() * z));
    }
}
