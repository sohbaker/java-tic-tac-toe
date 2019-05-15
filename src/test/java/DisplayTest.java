import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {
    @Test
    public void testPrintsWelcome() {
        Display display = new Display();
        assertEquals("Welcome!", display.greeting());
    }

    @Test
    public void testPromptsPlayer() {
        Display display = new Display();
        assertEquals("Make a move: X", display.promptPlayer("X"));
    }

    @Test
    public void testShowsAnEmptyBoard() {
        Display display = new Display();
        Board board = new Board();
        int boardSize = board.getSize();
        assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9", display.createArrayListOfCurrentGrid(board, boardSize));
    }
}
