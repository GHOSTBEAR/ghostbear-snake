package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private Direction direction = null;

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'q') {
            System.exit(113);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w': {
                if (direction != Direction.SOUTH) {
                    direction = Direction.NORTH;
                }
                break;
            }
            case 's': {
                if (direction != Direction.NORTH) {
                    direction = Direction.SOUTH;
                }
                break;
            }
            case 'a': {
                if (direction != Direction.EAST) {
                    direction = Direction.WEST;
                }
                break;
            }
            case 'd': {
                if (direction != Direction.WEST) {
                    direction = Direction.EAST;
                }
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released (" + System.currentTimeMillis() + "): " + e.getKeyChar());
    }
}
