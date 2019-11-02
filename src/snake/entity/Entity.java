package snake.entity;

public class Entity {

    protected Integer x;
    protected Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public boolean collision(Entity entity) {
        return entity.x.equals(x) && entity.y.equals(y);
    }
}
