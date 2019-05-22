import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

public class GameTest {
    private Board board = new Board();
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private Display display = new Display(new PrintStream(outputContent), System.in);
    private Player player1;
    private Player player2;

    @Test
    public void knowsThatTheGameCanContinue() {
        player1 = new Human("X", display);
        player2 = new Human("O", display);
        Game game = new Game(board, display, player1, player2);
        assertFalse(game.isOver());
    }

    @Test
    public void knowsThatTheGameHasEndedWithATie() {
        List<String> playerOneMoves = Arrays.asList("9", "1", "4", "3", "8");
        List<String> playerTwoMoves = Arrays.asList("5", "6", "7", "2");
        player1 = new FakePlayer("X", display, playerOneMoves);
        player2 = new FakePlayer("O", display, playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertThat(outputContent.toString(), containsString("It\'s a tie!"));
    }

    @Test
    public void knowsThatTheGameHasEndedBecauseXWins() {
        List<String> playerOneMoves = Arrays.asList("1", "4", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "3");
        player1 = new FakePlayer("X", display, playerOneMoves);
        player2 = new FakePlayer("O", display, playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertThat(outputContent.toString(), containsString("Player X wins!"));
    }

    @Test
    public void knowsThatTheGameHasEndedBecauseOWins() {
        List<String> playerOneMoves = Arrays.asList("1", "3", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "5", "8");
        player1 = new FakePlayer("X", display, playerOneMoves);
        player2 = new FakePlayer("O", display, playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertThat(outputContent.toString(), containsString("Player O wins!"));
    }
}
