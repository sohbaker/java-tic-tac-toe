import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class HumanTest {
    private Human human;
    private DisplaySpy displaySpy = new DisplaySpy(System.out, System.in);

    @Test
    public void hasAMark() {
        human = new Human("X", displaySpy);
        assertEquals("X", human.getMark());
    }

    @Test
    public void getsAMoveFromAPlayer() {
        String sampleMove = "1";
        InputStream fakeInput = new ByteArrayInputStream((sampleMove + "\n").getBytes());
        displaySpy = new DisplaySpy(System.out, fakeInput);
        human = new Human("O", displaySpy);
        assertEquals(1, human.getMove());
    }

    @Test
    public void returnsIntegerIfUserTypesExit() {
        String exit = "exit";
        InputStream fakeInput = new ByteArrayInputStream((exit + "\n").getBytes());
        displaySpy = new DisplaySpy(System.out, fakeInput);
        human = new Human("X", displaySpy);
        assertEquals(-2, human.getMove());
    }
}