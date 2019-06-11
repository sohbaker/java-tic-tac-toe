import org.junit.*;
import java.io.*;
import static junit.framework.TestCase.assertTrue;

public class GameFactoryTest {
    private GameFactory gameFactory;
    private DisplaySpy displaySpy;
    private String filename = "test_save.txt";

    @Before
    public void setUp() {
        String gameType = "hh";
        InputStream fakeInput = new ByteArrayInputStream(gameType.getBytes());
        displaySpy = new DisplaySpy(System.out, fakeInput);
        gameFactory = new GameFactory(displaySpy, filename);
    }

    @Test
    public void canCreateANewGame() {
        Game newGame = gameFactory.createNewGame();
        assertTrue(newGame instanceof Game);
    }

    @Test
    public void canReloadASavedGame() {
        gameFactory.reloadExistingGameIfNotOver();
        assertTrue(displaySpy.confirmGameReloadedShouldHaveBeenCalled());
    }
}
