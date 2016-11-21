package base;

import java.awt.*;
import java.util.ArrayList;

class snake {
    private ArrayList<String> body = new ArrayList<>();
    private ArrayList<Integer> oldX = new ArrayList<>();
    private ArrayList<Integer> oldY = new ArrayList<>();
    private int r, g, b;
    private int x, y;
    private death d;

    snake() {
        r = 0;
        g = 255;
        b = 0;
        x = 100;
        y = 100;
    }

    void paint(Graphics g) {
        g.setColor(new Color(r, this.g, b));
        g.fillRect(x, y, 9, 9);
        for (int i = 0; i < body.size(); i++) {
            int a = oldX.get((oldX.size() - 2) - i);
            int b = oldY.get((oldY.size() - 2) - i);
            g.fillRect(a, b, 9, 9);
        }
    }

    void check() {
        if (y > 231 || x > 201 || y < 39 || x < 9) {
            System.out.println("Out of bounds");
            d = new death(score.score);
        }

        for (int i = 0; i < body.size(); i++) {
            int a = oldX.get((oldX.size() - 2) - i);
            int b = oldY.get((oldY.size() - 2) - i);
            if (a == x && b == y) {
                System.out.println("Killed in Action");
                d = new death(score.score);
            }
        }
    }

    void clean() {
        for (int i = oldX.size() - body.size() - 5; i > 0; i--) {
            oldX.remove(i);
            oldY.remove(i);
        }
    }

    void setColor() {
        r = (int) (Math.random() * 255);
        b = (int) (Math.random() * 255);
        g = (int) (Math.random() * 255);
    }

    void setX(int x) {
        this.x += x;
    }

    int getX() {
        return x;
    }

    void setY(int y) {
        this.y += y;
    }

    int getY() {
        return y;
    }

    void setBody() {
        body.add("");
    }

    void setOldX() {
        oldX.add(x);
    }

    void setOldY() {
        oldY.add(y);
    }
}
