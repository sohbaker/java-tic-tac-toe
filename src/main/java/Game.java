public class Game {
    private final Display display;
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;
    private Board board;

    public Game(Board currentBoard, Display currentDisplay, Player player1, Player player2) {
        this.board = currentBoard;
        this.display = currentDisplay;
        this.currentPlayer = player1;
        this.playerOne = player1;
        this.playerTwo = player2;
    }

    public boolean isOver() {
        boolean over = false;

        if (this.board.isFull() || this.board.playerHasWon(this.playerOne.getMark()) || this.board.playerHasWon(this.playerTwo.getMark())) {
            over = true;
        }
        return over;
    }

    public void play() {
        while (!isOver()) {
            display.printGrid(board);
            display.promptPlayer(currentPlayer.getMark());
            int move = this.currentPlayer.getMove();
            this.board.markBoard(move, this.currentPlayer.getMark());
            if(!this.board.playerHasWon(this.currentPlayer.getMark())) {
                togglePlayer();
            }
        }
        showOutcome(this.currentPlayer.getMark());
    }

    private void showOutcome(String mark) {
        if (this.board.isATie()) {
            this.display.announceTie();
        } else if(this.board.playerHasWon(mark)) {
            this.display.announceWinner(mark);
        }
    }

    private void togglePlayer() {
        if (this.currentPlayer == this.playerOne) {
            this.currentPlayer = this.playerTwo;
        } else {
            this.currentPlayer = this.playerOne;
        }
    }
}
