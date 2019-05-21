import org.junit.Test;

import java.util.List;

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
    public void testKnowsThatAMoveIsValid() {
        Board board = new Board();
        board.markBoard(1, "X");
        assertTrue(board.isValidMove(2));
    }

    @Test
    public void testKnowsThatAMoveIsNotValid() {
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

    @Test
    public void testKnowsThatTheBoardIsNotFull() {
        Board board = new Board();
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        assertFalse(board.isFull());
    }

    @Test
    public void testKnowsWhatCellsAreStillAvailable() {
        Board board = new Board();
        board.markBoard(1, "X");
        List availableMoves = board.availableMoves();
        assertFalse(availableMoves.isEmpty());
    }

    @Test
    public void testReturnsTheMarkAtARequestedPosition() {
        Board board = new Board();
        board.markBoard(1, "X");
        assertEquals("X", board.getCellAtPosition(1));
    }

    @Test
    public void testReturnsTheEmptyCellAtARequestedPosition() {
        Board board = new Board();
        assertEquals("1", board.getCellAtPosition(1));
    }

    @Test
    public void testKnowsTheSizeOfTheBoard() {
        Board board = new Board();
        assertEquals(9, board.getSize());
    }

    @Test
    public void returnsTheOpponentsMark() {
        Board board = new Board();
        assertEquals("O", board.getOpponentMark("X"));
    }
}