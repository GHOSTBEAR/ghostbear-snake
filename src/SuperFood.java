import java.awt.*;

class SuperFood extends Food {
    private long start = System.currentTimeMillis();
    private boolean should = true;

    void paint(Graphics graphics) {
        if (System.currentTimeMillis() - start > 20000) {
            if(should) {
                setPostion(0,0);
                should = false;
            }
        }
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(getX(), getY(), 9, 9);
    }

    void setScore() {
        score+=10;
    }
}
