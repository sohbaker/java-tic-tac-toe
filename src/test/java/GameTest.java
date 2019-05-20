import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class GameTest {
    private Board board = new Board();
    private Display display = new Display();
    private Player player1;
    private Player player2;

    @Test
    public void knowsThatTheGameCanContinue() {
        player1 = new Human("X", display);
        player2 = new Human("O", display);
        Game game = new Game(board, display, player1, player2);
        assertFalse(game.isOver());
    }
}
