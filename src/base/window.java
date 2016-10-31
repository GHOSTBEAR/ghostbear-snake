package base;

import javax.swing.*;

class window extends JFrame {
    panel p;

    window() {
        int x = Integer.parseInt(JOptionPane.showInputDialog(" Choose difficulty in ms \n Recommended: 250 or 125"));
        p = new panel(x);
        add(p);
    }
}
