import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {
    @Test
    public void testDisplayPrintsWelcome() {
        Display display = new Display();
        assertEquals("Welcome!", display.greeting());
    }

    @Test
    public void testDisplayPromptsPlayer() {
        Display display = new Display();
        assertEquals("Make a move: X", display.promptPlayer("X"));
    }
}
