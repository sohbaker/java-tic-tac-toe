import org.junit.*;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class HumanTest {
    private Human human;
    private Display display = new Display();

    @Before
    public void setUp() {
       human = new Human("X", display);
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void hasAMark() {
        assertEquals("X", human.getMark());
    }

    @Test
    public void getsAMoveFromAPlayer() throws IOException {
        String sampleMove = "1";
        InputStream stream = new ByteArrayInputStream((sampleMove+"\n").getBytes());
        System.setIn(stream);
        assertEquals(1, human.getMove());
    }
}
