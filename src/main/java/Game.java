public class Game {
    private final Display display;
    private final Player playerOne;
    private final Player playerTwo;
    private Board board;

    public Game(Board currentBoard, Display currentDisplay, Player player1, Player player2) {
        board = currentBoard;
        display = currentDisplay;
        playerOne = player1;
        playerTwo = player2;
    }

    public boolean isOver() {
        boolean over = false;

        if (board.isFull() || board.playerHasWon(playerOne.getMark()) || board.playerHasWon(playerTwo.getMark())) {
            over = true;
        }
        return over;
    }
}
