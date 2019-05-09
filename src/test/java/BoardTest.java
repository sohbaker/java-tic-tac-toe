import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void testNewBoardIsEmpty() {
        Board board = new Board();
        assertTrue(board.isEmpty());
    }

    @Test
    public void testAddAMarkToBoard() {
        Board board = new Board();
        board.markBoard(1, "X");
        assertEquals("X", board.getMarkAtPosition(1));
    }
}