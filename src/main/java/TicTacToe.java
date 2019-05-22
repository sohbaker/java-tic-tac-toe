public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        Display display = new Display(System.out, System.in);
        Player playerX = new Human("X", display);
        Player playerO = new Human("O", display);
        Game game = new Game(board, display, playerX, playerO);
        display.printGreeting();
        game.play();
    }
}

