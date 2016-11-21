package base;

import java.awt.*;

class score {
    static int score;
    private int x, y;
    score(){
        newX();
        newY();
    }

    void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 9, 9);
        System.out.println(score);
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
        y = 40 + (10 * (int) (Math.random() * 19));
    }
}
