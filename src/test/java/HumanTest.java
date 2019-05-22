import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static junit.framework.TestCase.assertEquals;

public class HumanTest {
    private Human human;
    private Display display = new Display(System.out, System.in);

    @Before
    public void setUp() {
        human = new Human("X", display);
    }

    @Test
    public void hasAMark() {
        assertEquals("X", human.getMark());
    }

    @Test
    public void getsAMoveFromAPlayer() {
        String sampleMove = "1";
        InputStream fakeInput = new ByteArrayInputStream((sampleMove + "\n").getBytes());
        display = new Display(System.out, fakeInput);
        human = new Human("O", display);
        assertEquals(1, human.getMove());
    }
}
