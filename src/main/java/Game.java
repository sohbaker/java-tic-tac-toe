public class Game {
    private final Display display;
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;
    private Board board;
    private boolean stopGame = false;

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
        while (!isOver() && !stopGame) {
            display.printGrid(board);
            display.promptPlayer(currentPlayer.getMark());
            int move = this.currentPlayer.getMove();
            validateMove(move);
            if(!this.board.playerHasWon(this.currentPlayer.getMark())) {
                togglePlayer();
            }
        }
        if (stopGame) {
            saveGameState();
        }
        showOutcome(this.currentPlayer.getMark());
    }

    private boolean validateMove(int move) {
        if (move == -2) { saveGameState(); }
        if (board.isValidMove(move)) {
            this.board.markBoard(move, this.currentPlayer.getMark());
            return true;
        } else {
            getNewMove();
        }
        return false;
    }

    private void getNewMove(){
        display.notifyInvalid("move");
        int newMove = this.currentPlayer.getMove();
        validateMove(newMove);
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

    private void saveGameState() {
        display.print("saved");
        System.exit(0);
    }
}
