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
    public void returnsAMove() {
        computer = new Computer(board, mark);
        int move = computer.getMove();
        assertTrue((move >= 0 && move <= 9));
    }
}
