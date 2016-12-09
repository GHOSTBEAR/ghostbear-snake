import java.awt.*;

class Hallon {
    private int x, y;
    long start = System.currentTimeMillis();
    boolean should = true;
    Hallon(){
        x = -10;
        y = -10;
    }

    void paint(Graphics g) {
        if (System.currentTimeMillis() - start > 20000) {
            if(should) {
                newX();
                newY();
                should = false;
            }
        }
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 9, 9);
    }

    void setScore() {
        Score.score+=10;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    void setStart() {
        start = System.currentTimeMillis();
        x = -10;
        y = -10;
        should = true;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void newX() {
        x = 10 + (10 * (int) (Math.random() * 19));
    }

    void newY() {
        y = 20 + (10 * (int) (Math.random() * 19));
    }
}
