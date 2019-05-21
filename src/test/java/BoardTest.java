import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void newBoardIsEmpty() {
        Board board = new Board();
        assertTrue(board.isEmpty());
    }

    @Test
    public void addAMarkToBoard() {
        Board board = new Board();
        board.markBoard(1, "X");
        assertEquals("X", board.getCellAtPosition(1));
    }

    @Test
    public void knowsThatAMoveIsValid() {
        Board board = new Board();
        board.markBoard(1, "X");
        assertTrue(board.isValidMove(2));
    }

    @Test
    public void knowsThatAMoveIsNotValid() {
        Board board = new Board();
        board.markBoard(1, "X");
        assertFalse(board.isValidMove(1));
    }

    @Test
    public void knowsThatAPlayerHasWon() {
        Board board = new Board();
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        board.markBoard(3, "X");
        assertTrue(board.playerHasWon("X"));
    }

    @Test
    public void knowsThatThePlayerHasNotWon() {
        Board board = new Board();
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        assertFalse(board.playerHasWon("X"));
    }

    @Test
    public void knowsThatTheBoardIsFull() {
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
    public void knowsThatTheBoardIsNotFull() {
        Board board = new Board();
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        assertFalse(board.isFull());
    }

    @Test
    public void knowsWhatCellsAreStillAvailable() {
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
    public void returnsTheOpponentsMark() {
        Board board = new Board();
        assertEquals("O", board.getOpponentMark("X"));
    }
}