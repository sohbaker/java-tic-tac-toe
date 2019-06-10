import org.junit.*;

import static junit.framework.TestCase.assertTrue;

public class GameSaverTest {
    private GameSaver gamesaver;
    private Game game;
    private Board board;
    private DisplaySpy displaySpy;
    private Human player1;
    private Human player2;

    @Before
    public void createDummyGame() {
        String[] marks = {"X", "O"};
        board = new Board(marks);
        displaySpy = new DisplaySpy(System.out, System.in);
        player1 = new Human(marks[0], displaySpy);
        player2 = new Human(marks[1], displaySpy);
        game = new Game(board, displaySpy, player1, player2);
        gamesaver = new GameSaver("test_save.txt", displaySpy);
    }

    @Test
    public void canSaveAGivenSetOfGameObjects() {
        gamesaver.saveGame(board, player1.getMark(), board.getOpponentMark(player1.getMark()));
        assertTrue(displaySpy.confirmGameIsSavedShouldHaveBeenCalled());
    }
}
