import java.awt.*;

class Food extends Entity {
    protected static int score;

    Food(){
        setColor(new Color(255,0,0));
        this.setPostion(0,0);
    }

    void paint(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getX(), getY(), getSize(), getSize());
    }

    int getScore() {
        return score;
    }

    void setScore() {
        score++;
    }

    @Override
    public void setPostion(int x, int y) {
        x = 10 + (10 * (int) (Math.random() * 19));
        y = 20 + (10 * (int) (Math.random() * 19));
        super.setPostion(x, y);
    }
}