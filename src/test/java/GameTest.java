import org.junit.*;
import java.io.*;
import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {
    private Board board = new Board();
    private Display display = new Display();
    private Player player1;
    private Player player2;
    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream defaultOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void tearDownAndRevertStream() {
        System.setOut(defaultOut);
    }

    @Test
    public void knowsThatTheGameCanContinue() {
        player1 = new Human("X", display);
        player2 = new Human("O", display);
        Game game = new Game(board, display, player1, player2);
        assertFalse(game.isOver());
    }

    @Test
    public void knowsThatTheGameHasEndedWithATie() throws IOException {
        List<String> playerOneMoves = Arrays.asList("9", "1", "4", "3", "8");
        List<String> playerTwoMoves = Arrays.asList("5", "6", "7", "2");
        player1 = new FakePlayer("X", display, playerOneMoves);
        player2 = new FakePlayer("O", display, playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertThat(outputContent.toString(), containsString("It\'s a tie!"));
    }

    @Test
    public void knowsThatTheGameHasEndedBecauseXWins() throws IOException {
        List<String> playerOneMoves = Arrays.asList("1", "4", "7");
        List<String> playerTwoMoves = Arrays.asList("2", "3");
        player1 = new FakePlayer("X", display, playerOneMoves);
        player2 = new FakePlayer("O", display, playerTwoMoves);
        Game game = new Game(board, display, player1, player2);
        game.play();
        assertThat(outputContent.toString(), containsString("Player X wins!"));
    }
}
