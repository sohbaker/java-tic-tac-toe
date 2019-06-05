import org.junit.*;
import java.io.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class DisplayTest {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final InputStream inputContent = new ByteArrayInputStream(("").getBytes());
    private Display display;

    @Before
    public void setUpStreams() {
        display = new Display(new PrintStream(outputContent), inputContent);
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
        String[] marks = {"X", "O"};
        Board board = new Board(marks);
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
        assertThat(outputContent.toString(), containsString("Invalid move. Please try again"));
    }

    @Test
    public void receivesAnInputFromAUser() {
        String sample = "sample text";
        InputStream fakeInput = new ByteArrayInputStream((sample+"\n").getBytes());
        display = new Display(new PrintStream(outputContent), fakeInput);
        assertEquals(sample, display.getInput());
    }

    @Test
    public void promptsPlayerToSelectAMark() {
        display.promptForMark("Player 1");
        assertThat(outputContent.toString(), containsString("Player 1, please choose your mark for the game:"));
    }

    @Test
    public void printsAGivenMessage() {
        display.printMessage("foobar");
        assertThat(outputContent.toString(), containsString("foobar"));
    }

    @Test
    public void asksThePlayerForATypeOfGame() {
        display.askForGameType();
        assertThat(outputContent.toString(), containsString("Type hh to play Human vs Human, or hc to play Human vs Computer"));
    }

    @Test
    public void printsTheGameInstructions() {
        display.printInstructions();
        assertThat(outputContent.toString(), containsString("type 'exit' to leave the game"));
    }

    @Test
    public void letsTheUserKnowThatASavedGameHasBeenLoaded() {
        display.confirmSavedGameHasReloaded();
        assertThat(outputContent.toString(), containsString("Here's your saved game:"));
    }
}
