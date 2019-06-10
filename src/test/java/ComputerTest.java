import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ComputerTest {
    private String mark = "\uD83D\uDDA5";
    private String[] marks = {"X", mark};
    private Board board = new Board(marks);
    private Computer computer;

    @Test
    public void takesAMark() {
        computer = new Computer(board, mark);
        assertEquals("\uD83D\uDDA5", computer.getMark());
    }

    @Test
    public void returnsARandomMove() {
        computer = new Computer(board, mark);
        int move = computer.getMove();
        assertTrue(board.isValidMove(move));
    }
}
