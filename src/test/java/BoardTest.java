import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setUpBoard() {
        board = new Board();
    }

    @Test
    public void newBoardIsEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    public void addAMarkToBoard() {
        board.markBoard(1, "X");
        assertEquals("X", board.getCellAtPosition(1));
    }

    @Test
    public void knowsThatAMoveIsValid() {
        board.markBoard(1, "X");
        assertTrue(board.isValidMove(2));
    }

    @Test
    public void knowsThatAMoveIsNotValid() {
        board.markBoard(1, "X");
        assertFalse(board.isValidMove(1));
    }

    @Test
    public void knowsThatAPlayerHasWon() {
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        board.markBoard(3, "X");
        assertTrue(board.playerHasWon("X"));
    }

    @Test
    public void knowsThatThePlayerHasNotWon() {
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        assertFalse(board.playerHasWon("X"));
    }

    @Test
    public void knowsThatTheBoardIsFull() {
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
        board.markBoard(1, "X");
        board.markBoard(2, "X");
        assertFalse(board.isFull());
    }

    @Test
    public void knowsWhatCellsAreStillAvailable() {
        board.markBoard(1, "X");
        List availableMoves = board.availableMoves();
        assertFalse(availableMoves.isEmpty());
    }

    @Test
    public void testReturnsTheMarkAtARequestedPosition() {
        board.markBoard(1, "X");
        assertEquals("X", board.getCellAtPosition(1));
    }

    @Test
    public void testReturnsTheEmptyCellAtARequestedPosition() {
        assertEquals("1", board.getCellAtPosition(1));
    }

    @Test
    public void returnsTheOpponentsMark() {
        assertEquals("O", board.getOpponentMark("X"));
    }
}