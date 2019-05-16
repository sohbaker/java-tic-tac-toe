import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {
    private Human human;

    @Test
    public void hasAMark() {
        human = new Human("X");
        assertEquals("X", human.getMark());
    }
}
