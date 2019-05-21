import org.junit.*;
import java.io.*;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class DisplayTest {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream defaultOut = System.out;
    private final InputStream defaultIn = System.in;
    private Display display;

    @Before
    public void setUpStreams() {
        display = new Display();
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void revertStreams() {
        System.setOut(defaultOut);
        System.setIn(defaultIn);
    }

    @Test
    public void printsGreeting() {
        display.printGreeting();
        assertThat(outputContent.toString(), containsString("Welcome"));
    }

    @Test
    public void promptsPlayerToMakeAMove() {
        display.promptPlayer("X");
        assertThat(outputContent.toString(), containsString("Make a move: X"));
    }

    @Test
    public void printsTheGrid() {
        Board board = new Board();
        display.printGrid(board);
        assertThat(outputContent.toString(), containsString("1 | 2 | 3\n4 | 5 | 6\n7 | 8 | 9"));
    }

    @Test
    public void announcesTheWinner() {
        display.announceWinner("X");
        assertThat(outputContent.toString(), containsString("Player X wins!"));
    }

    @Test
    public void announcesATiedGame() {
        display.announceTie();
        assertThat(outputContent.toString(), containsString("It\'s a tie!"));
    }

    @Test
    public void notifyOfAnInvalidChoice() {
        display.notifyInvalid("move");
        assertThat(outputContent.toString(), containsString("Invalid move"));
    }

    @Test
    public void receivesAnInputFromAUser() throws IOException {
        String sample = "sample text";
        InputStream stream = new ByteArrayInputStream((sample+"\n").getBytes());
        System.setIn(stream);
        assertEquals(sample, display.getInput());
    }
  }
