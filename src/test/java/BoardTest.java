import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test
    public void testAppHasABoard() {
        Board classUnderTest = new Board();
        assertEquals("Hello world.", classUnderTest.getBoard());
    }

    @Test
    public void testBoardPrintsOutABoard() {
        Board classunderTest = new Board();
        assertEquals("1", classunderTest.printBoard());
    }
}