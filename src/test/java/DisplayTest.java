import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class DisplayTest {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream defaultOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void revertStreams() {
        System.setOut(defaultOut);
    }

    @Test
    public void printsWelcome() {
        Display display = new Display();
        display.greeting();
        assertThat(outputContent.toString(), containsString("Welcome!"));
    }

    @Test
    public void testPromptsPlayer() {
        Display display = new Display();
        display.promptPlayer("X");
        assertThat(outputContent.toString(), containsString("Make a move: X"));
    }

    @Test
    public void testPrintsABoard() {
        Display display = new Display();
        Board board = new Board();
        int size = board.getSize();
        display.showBoardGrid(board, size);
        assertThat(outputContent.toString(), containsString("1 | 2 | 3\n4 | 5 | 6\n7 | 8 | 9"));
    }
  }
