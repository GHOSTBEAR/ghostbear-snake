package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class death {
    death(int score) {
        // Death by metal
        System.out.println("Game over");
        System.out.println("Your Score: " + score);
        try {
            File x = new File("highscore.txt");
            Scanner sc = new Scanner(x);
            while (sc.hasNext()) {
                int tovig = Integer.parseInt(sc.next());
                if (tovig < score) {
                    System.out.println("New High Score: " + score);
                    Formatter f = new Formatter("highscore.txt");
                    f.format("%s", score);
                    f.close();
                } else {
                    System.out.println("High Score: " + tovig);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            try {
                Formatter f = new Formatter("highscore.txt");
                f.format("%s", score);
                f.close();
            } catch (Exception c) {
                System.out.println("Error");
            }
        }
        System.exit(0);
    }
}
