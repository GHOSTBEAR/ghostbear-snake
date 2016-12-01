import javax.swing.*;

class Window extends JFrame {
    Window() {
        int val;
        try {
            val = Integer.parseInt(JOptionPane.showInputDialog("Easy: 1\nMedium: 2\nHard: 3\nExtreme: 4\nChuck Norris: 5"));
        } catch (Exception e) {
            val = 50;
        }
        switch (val) {
            case 1:
                Panel p = new Panel(110);
                add(p);
                break;
            case 2:
                p = new Panel(90);
                add(p);
                break;
            case 3:
                p = new Panel(70);
                add(p);
                break;
            case 4:
                p = new Panel(50);
                add(p);
                break;
            case 5:
                p = new Panel(20);
                add(p);
                break;
            default:
                System.out.println("Wrong input!\nBut I will choose a difficulty for you.");
                int x = (int) (50 + (Math.random() * 50));
                // System.out.println(x);
                p = new Panel(x);
                add(p);
                break;
        }
    }
}
