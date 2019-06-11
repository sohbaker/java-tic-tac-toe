import org.junit.*;
import static junit.framework.TestCase.assertTrue;

public class PlayerFactoryTest {
    private String[] marks = {"X", "O"};
    private Board board;
    private DisplaySpy displaySpy;
    private PlayerFactory playerFactory;

    @Before
    public void setUp() {
        board = new Board(marks);
        displaySpy = new DisplaySpy(System.out, System.in);
        playerFactory = new PlayerFactory(board, displaySpy);
    }

    @Test
    public void canCreateANewHumanPlayer() {
        Player newHumanPlayer = playerFactory.createPlayer(marks[0], "h");
        assertTrue(newHumanPlayer instanceof Human);
    }


    @Test
    public void canCreateANewComputerPlayer() {
        Player newComputerPlayer = playerFactory.createPlayer(marks[1], "c");
        assertTrue(newComputerPlayer instanceof Computer);
    }
}
