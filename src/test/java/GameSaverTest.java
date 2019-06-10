import org.junit.*;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GameSaverTest {
    private GameSaver gamesaver;
    private Board board;
    private DisplaySpy displaySpy;
    private Human player1;

    private String filename = "test_save_1.txt";

    @Before
    public void createDummyGame() {
        String[] marks = {"X", "O"};
        board = new Board(marks);
        displaySpy = new DisplaySpy(System.out, System.in);
        player1 = new Human(marks[0], displaySpy);
        gamesaver = new GameSaver(filename, displaySpy);
    }

    @Test
    public void canSaveAGivenSetOfGameObjects() {
        gamesaver.saveGame(board, player1.getMark(), board.getOpponentMark(player1.getMark()));
        assertTrue(displaySpy.confirmGameIsSavedShouldHaveBeenCalled());
    }

    @Test
    public void canReadAFileOnceSaved() {
        gamesaver.saveGame(board, player1.getMark(), board.getOpponentMark(player1.getMark()));
        gamesaver.readSavedFile();
        assertTrue(gamesaver.fileRead);
    }

    @Test
    public void knowsWhetherTheSavedGameIsOver() {
        gamesaver.saveGame(board, player1.getMark(), board.getOpponentMark(player1.getMark()));
        gamesaver.readSavedFile();
        assertFalse(gamesaver.savedGameIsOver());
    }

    @Test
    public void canReloadAPreviouslySavedGame() {
        gamesaver.saveGame(board, player1.getMark(), board.getOpponentMark(player1.getMark()));
        gamesaver.readSavedFile();
        gamesaver.reloadSavedGame();
        assertTrue(displaySpy.confirmGameReloadedShouldHaveBeenCalled());
    }
}
