import java.io.*;

public class Game implements Serializable {
    private final Display display;
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;
    private Board board;
    private boolean stopGame = false;
    private GameSaver gameSaver;

    public Game(Board currentBoard, Display display, Player player1, Player player2, GameSaver gameSaver) {
        this.board = currentBoard;
        this.display = display;
        this.currentPlayer = player1;
        this.playerOne = player1;
        this.playerTwo = player2;
        this.gameSaver = gameSaver;
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
            int validMove = validateMove();
            makeMove(validMove);

            if (!this.board.playerHasWon(this.currentPlayer.getMark()) && !stopGame) {
                togglePlayer();
            }
        }
        showOutcome(this.currentPlayer.getMark());
        saveGameState();
    }

    private int validateMove() {
        int move = this.currentPlayer.getMove();
        while (move != -2 && !board.isValidMove(move)) {
            move = getNewMove();
        }
        return move;
    }

    private int getNewMove() {
        display.notifyInvalid("move");
        int newMove = this.currentPlayer.getMove();
        return newMove;
    }

    private void makeMove(int move) {
        switch (move) {
            case -2:
                stopGame = true;
                break;
            default:
                this.board.markBoard(move, this.currentPlayer.getMark());
        }
    }

    private void showOutcome(String mark) {
        if (this.board.isATie()) {
            this.display.announceTie();
        } else if (this.board.playerHasWon(mark)) {
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
        gameSaver.saveGame(this.board, this.currentPlayer.getMark(), this.board.getOpponentMark(this.currentPlayer.getMark()));
    }
}
