import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Display {
    String userInput;

    public void printGreeting() {
        System.out.println("Welcome to TicTacToe!");
    }

    public void promptPlayer(String playerMark) {
        System.out.println(String.format("Make a move: %s", playerMark));
    }

    public void printGrid(Board board) {
        List gridCells = board.gridCells();

        String row1 = gridCells.get(0) + " | " + gridCells.get(1) + " | " + gridCells.get(2) + "\n";
        String row2 = gridCells.get(3) + " | " + gridCells.get(4) + " | " + gridCells.get(5) + "\n";
        String row3 = gridCells.get(6) + " | " + gridCells.get(7) + " | " + gridCells.get(8);

        String wholeGrid = row1 + row2 +row3;

        System.out.println(wholeGrid);
    }

    public void announceWinner(String playerMark) {
        System.out.println(String.format("Player %s wins!", playerMark));
    }

    public void announceTie() {
        System.out.println("It\'s a tie!");
    }

    public void notifyInvalid(String prompt) {
        System.out.println(String.format("Invalid %s", prompt));
    }

    public String getInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            this.userInput = reader.readLine();
        } catch (IOException e) {
            System.out.println("Trouble reading input: " + e);
        }
        return this.userInput;
    }
}
