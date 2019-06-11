import org.junit.Test;
import java.util.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GameTest {
    private String[] marks = {"X", "O"};
    private String filename = "test_save.txt";
    private Board board = new Board(marks);
    private DisplaySpy displaySpy;
    private FakePlayer player1;
    private FakePlayer player2;
    private GameSaver gameSaver;

    @Test
    public void knowsThatTheGameCanContinue() {
        List<String> playerOneMoves = Arrays.asList("9");
        List<String> playerTwoMoves = Arrays.asList("5");
        displaySpy = new DisplaySpy(System.out, System.in);
        gameSaver = new GameSaver(filename,displaySpy);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, displaySpy, player1, player2, gameSaver);
        assertFalse(game.isOver());
    }

    @Test
    public void knowsThatTheGameHasEndedWithATie() {
        List<String> playerOneMoves = Arrays.asList("9", "1", "4", "3", "8");
        List<String> playerTwoMoves = Arrays.asList("5", "6", "7", "2");
        displaySpy = new DisplaySpy(System.out, System.in);
        gameSaver = new GameSaver(filename,displaySpy);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, displaySpy, player1, player2, gameSaver);
        game.play();
        assertTrue(displaySpy.announceTieShouldHaveBeenCalled());
    }

    @Test
    public void knowsThatTheGameHasEndedBecauseXWins() {
        List<String> playerOneMoves = Arrays.asList("1", "4", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "3");
        displaySpy = new DisplaySpy(System.out, System.in);
        gameSaver = new GameSaver(filename,displaySpy);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, displaySpy, player1, player2, gameSaver);
        game.play();
        assertTrue(displaySpy.announceWinnerShouldHaveBeenCalled());
    }

    @Test
    public void knowsThatTheGameHasEndedBecauseOWins() {
        List<String> playerOneMoves = Arrays.asList("1", "3", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "5", "8");
        displaySpy = new DisplaySpy(System.out, System.in);
        gameSaver = new GameSaver(filename,displaySpy);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, displaySpy, player1, player2, gameSaver);
        game.play();
        assertTrue(displaySpy.announceWinnerShouldHaveBeenCalled());
    }

    @Test
    public void willNotLetAPlayerSelectAMoveThatIsTaken() {
        List<String> playerOneMoves = Arrays.asList("1", "2", "3", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "5", "8");

        displaySpy = new DisplaySpy(System.out, System.in);
        gameSaver = new GameSaver(filename,displaySpy);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, displaySpy, player1, player2, gameSaver);
        game.play();
        assertTrue(displaySpy.notifyInvalidShouldHaveBeenCalled());
    }

    @Test
    public void endsTheGameLoopWhenUserTypesExit() {
        List<String> playerOneMoves = Arrays.asList("1", "3", "exit");
        List<String> playerTwoMoves = Arrays.asList("2", "5");
        displaySpy = new DisplaySpy(System.out, System.in);
        gameSaver = new GameSaver(filename,displaySpy);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, displaySpy, player1, player2, gameSaver);
        game.play();
        assertTrue(displaySpy.confirmGameIsSavedShouldHaveBeenCalled());
    }
}
