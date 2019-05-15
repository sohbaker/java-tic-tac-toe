import org.junit.Test;

import static org.hamcrest.core.StringStartsWith.startsWith;
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
    public void testPrintsABoard() {
        Display display = new Display();
        Board board = new Board();
        int size = board.getSize();
        String displayedBoard = display.showBoardGrid(board, size);
        assertEquals("1 | 2 | 3\n4 | 5 | 6\n7 | 8 | 9", displayedBoard);
    }
}
