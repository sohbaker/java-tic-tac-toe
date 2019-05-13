import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testChecksIfAMoveIsValid() {
        Board board = new Board();
        board.markBoard(1, "X");
        assertFalse(board.isValidMove(1));
    }

    @Test
    public void testKnowsThatAPlayerHasWon() {
        Board board = new Board();
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        board.markBoard(3, "X");
        assertTrue(board.playerHasWon("X"));
    }

    @Test
    public void testKnowsThatThePlayerHasNotWon() {
        Board board = new Board();
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        assertFalse(board.playerHasWon("X"));
    }

    @Test
    public void testKnowsThatTheBoardIsFull() {
        Board board = new Board();
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        board.markBoard(3, "X");
        board.markBoard(4, "X");
        board.markBoard(5, "X");
        board.markBoard(6, "X");
        board.markBoard(7, "X");
        board.markBoard(8, "X");
        board.markBoard(9, "X");
        assertTrue(board.isFull());
    }

}