import java.io.*;

public class GameSaver {
    private String filename;
    private Display display;
    private Board savedBoard;
    private String playerOneMark;
    private String playerTwoMark;
    public boolean fileRead = false;
    public boolean fileNotFound = false;

    public GameSaver(String filename, Display display) {
        this.filename = filename;
        this.display = display;
    }

    public void saveGame(Board board, String currentPlayerMark, String opponentMark) {
        try {
            FileOutputStream file = new FileOutputStream(this.filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(board);
            out.writeObject(currentPlayerMark);
            out.writeObject(opponentMark);
            out.close();
            file.close();
            display.confirmGameIsSaved();
        } catch (IOException IOEx) {
            System.out.println(String.format("IOException caught %s", IOEx));
        }
    }

    public void readFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.filename));
            this.savedBoard = (Board) in.readObject();
            this.playerOneMark = (String) in.readObject();
            this.playerTwoMark = (String) in.readObject();
            this.fileRead = true;
        } catch (FileNotFoundException FlEx) {
            this.fileNotFound = true;
            createTextFileForSaving(filename);
        } catch (IOException IOEx) {
            System.out.println(String.format("IOException caught %s", IOEx));
        } catch (ClassNotFoundException ClEx) {
            System.out.println(String.format("Class Not Found Exception caught %s", ClEx));
        }
    }

    public boolean savedGameIsOver() {
        // readFile();
        return (this.savedBoard.isFull() || this.savedBoard.playerHasWon(this.playerOneMark) || this.savedBoard.playerHasWon(this.playerTwoMark));
    }

    public Game reloadSavedGame() {
        Human playerOne = new Human(playerOneMark, display);
        Human playerTwo = new Human(playerTwoMark, display);
        Game reloadedGame = new Game(savedBoard, display, playerOne, playerTwo, this);
        display.confirmSavedGameHasReloaded();
        return reloadedGame;
    }

    private void createTextFileForSaving(String filename) {
        Writer fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
        } catch (IOException ex) {

        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {

            }
        }
    }
}
