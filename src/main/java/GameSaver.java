import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GameSaver {
    private String filename;
    private Display display;

    public GameSaver(String filename, Display display) {
        this.filename = filename;
        this.display = display;
    }

    public void saveGame(Board board, String currentPlayerMark, String opponentMark) {
        try {
            FileOutputStream file = new FileOutputStream(this.filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(board.isFull());
            out.writeObject(board);
            out.writeObject(currentPlayerMark);
            out.writeObject(opponentMark);
            out.close();
            file.close();
            display.confirmGameIsSaved();
        } catch (IOException ex) {
            System.out.println(String.format("IOException caught %s", ex));
        }

    }
}
