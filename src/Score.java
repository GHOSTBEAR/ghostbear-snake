import java.awt.*;

class Score {
    static int score;
    private int x, y;
    Score(){
        newX();
        newY();
    }

    void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 9, 9);
    }

    int getScore() {
        return score;
    }

    void setScore() {
        score++;
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