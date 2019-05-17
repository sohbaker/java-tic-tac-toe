import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class DisplayTest {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream defaultOut = System.out;
    private Display display;

    @Before
    public void setUpStreams() {
        display = new Display();
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void revertStreams() {
        System.setOut(defaultOut);
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
        int size = board.getSize();
        display.printGrid(board, size);
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
    public void receivesAnIntInputFromAUser() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        System.setIn(stdin);
    }
  }
