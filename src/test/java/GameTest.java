import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GameTest {
    private String[] marks = {"X", "O"};
    private Board board = new Board(marks);
    private DisplaySpy display;
    private FakePlayer player1;
    private FakePlayer player2;

    @Test
    public void knowsThatTheGameCanContinue() {
        List<String> playerOneMoves = Arrays.asList("9");
        List<String> playerTwoMoves = Arrays.asList("5");
        display = new DisplaySpy(System.out, System.in);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        assertFalse(game.isOver());
    }

    @Test
    public void knowsThatTheGameHasEndedWithATie() {
        List<String> playerOneMoves = Arrays.asList("9", "1", "4", "3", "8");
        List<String> playerTwoMoves = Arrays.asList("5", "6", "7", "2");
        display = new DisplaySpy(System.out, System.in);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertTrue(display.announceTieShouldHaveBeenCalled());
    }

    @Test
    public void knowsThatTheGameHasEndedBecauseXWins() {
        List<String> playerOneMoves = Arrays.asList("1", "4", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "3");
        display = new DisplaySpy(System.out, System.in);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertTrue(display.announceWinnerShouldHaveBeenCalled());
    }

    @Test
    public void knowsThatTheGameHasEndedBecauseOWins() {
        List<String> playerOneMoves = Arrays.asList("1", "3", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "5", "8");
        display = new DisplaySpy(System.out, System.in);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertTrue(display.announceWinnerShouldHaveBeenCalled());
    }

    @Test
    public void willNotLetAPlayerSelectAMoveThatIsTaken() {
        List<String> playerOneMoves = Arrays.asList("1", "2", "3", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "5", "8");

        display = new DisplaySpy(System.out, System.in);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertTrue(display.notifyInvalidShouldHaveBeenCalled());
    }

    @Test
    public void endsTheGameLoopWhenUserTypesExit() {
        List<String> playerOneMoves = Arrays.asList("1", "3", "exit");
        List<String> playerTwoMoves = Arrays.asList("2", "5");
        display = new DisplaySpy(System.out, System.in);
        player1 = new FakePlayer("X", playerOneMoves);
        player2 = new FakePlayer("O", playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertTrue(display.confirmGameIsSavedShouldHaveBeenCalled());
    }
}
