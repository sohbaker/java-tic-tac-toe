import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {
    @Test
    public void testDisplayPrintsWelcome() {
        Display display = new Display();
        assertEquals("Welcome!", display.greeting());
    }
}
