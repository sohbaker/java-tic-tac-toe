import org.junit.*;
import java.util.*;
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
        assertFalse(board.availableMoves().contains(1));
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
        board.markBoard(4, "O");
        board.markBoard(2, "X");
        board.markBoard(5, "O");
        board.markBoard(3, "X");
        assertTrue(board.playerHasWon("X"));
    }

    @Test
    public void knowsThatThePlayerHasNotWon() {
        board.markBoard(1, "X");
        board.markBoard(2, "O");
        assertFalse(board.playerHasWon("X"));
    }

    @Test
    public void knowsThatTheBoardIsFull() {
        board.markBoard(1, "X");
        board.markBoard(2, "O");
        board.markBoard(3, "X");
        board.markBoard(4, "O");
        board.markBoard(5, "X");
        board.markBoard(6, "O");
        board.markBoard(7, "X");
        board.markBoard(8, "O");
        board.markBoard(9, "X");
        assertTrue(board.isFull());
    }

    @Test
    public void knowsThatTheBoardIsNotFull() {
        board.markBoard(1, "X");
        board.markBoard(2, "O");
        assertFalse(board.isFull());
    }

    @Test
    public void knowsWhatCellsAreStillAvailable() {
        board.markBoard(1, "X");
        List availableMoves = board.availableMoves();
        assertFalse(availableMoves.isEmpty());
    }

    @Test
    public void returnsTheOpponentsMark() {
        assertEquals("O", board.getOpponentMark("X"));
    }

    @Test
    public void returnsTheCellsAsAList() {
        List<String> expected = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        assertEquals(expected, board.gridCells());
    }
}