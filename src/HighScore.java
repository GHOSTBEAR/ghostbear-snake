import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

class HighScore {

    private static HighScore instance;

    private HighScore() {}

    public static HighScore getInstance() {
        if (instance == null) {
            instance = new HighScore();
        }
        return instance;
    }

    private int score = 0;

    public void add(int i) {
        score+=i;
    }

    public int getScore() {
        return score;
    }

    private int previousHighScore;

    public int getPreviousHighScore() {
        if (previousHighScore == 0) {
            previousHighScore = read();
        }
        return previousHighScore;
    }

    private File file = new File("highscore.txt");

    void write(int score) {
        try {
            new Formatter(file).format("%d", score).close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    int read() {
        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNext()) {
                return Integer.parseInt(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, creating new file!");
            write(0);
        }
        return read();
    }
}