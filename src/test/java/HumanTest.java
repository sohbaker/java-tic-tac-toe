import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertEquals;

public class HumanTest {
    private Human human;
    private Display display = new Display(System.out, System.in);

    @Test
    public void hasAMark() {
        human = new Human("X", display);
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
