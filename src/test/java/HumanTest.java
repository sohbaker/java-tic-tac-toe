import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HumanTest {
    private Human human;
    private Display display = new Display();

    @Test
    public void hasAMark() {
        human = new Human("X", display);
        assertEquals("X", human.getMark());
    }
}
