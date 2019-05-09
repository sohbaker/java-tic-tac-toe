import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void testNewBoardIsEmpty() {
        Board board = new Board();
        assertTrue(board.isEmpty());
    }
}