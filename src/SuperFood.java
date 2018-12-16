import java.awt.*;

class SuperFood extends Food {
    private long start = System.currentTimeMillis();
    private boolean should = true;

    SuperFood() {
        setColor(new Color(255, 181,0));
        this.setPosition(0,0);
    }

    void paint(Graphics graphics) {
        if (System.currentTimeMillis() - start > 20000) {
            if(should) {
                setPosition(0,0);
                should = false;
            }
        }
        System.out.println("SuperFood: " + getX() + ", " + getY());

        graphics.setColor(Color.ORANGE);
        graphics.fillRect(getX(), getY(), getSize(), getSize());
    }

}
