import java.awt.*;

class Food extends Entity {
    //public static int score = 0;

    Food(){
        setSize(10);
        setColor(new Color(255,0,0));
        this.setPosition(0,0);
    }

    void paint(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getX(), getY(), getSize(), getSize());
    }

    @Override
    public void setPosition(int x, int y) {
        x = 10 + (10 * (int) (Math.random() * 19));
        y = 20 + (10 * (int) (Math.random() * 19));
        super.setPosition(x, y);
    }
}