import java.io.*;
import java.util.List;

public class Display {
    String userInput;
    PrintStream console;
    InputStream input;

    public Display(PrintStream console, InputStream input) {
        this.console = console;
        this.input = input;
    }
    public void printGreeting() {
        console.println("Welcome to TicTacToe!");
    }

    public void promptPlayer(String playerMark) {
        console.println(String.format("Make a move: %s", playerMark));
    }

    public void printGrid(Board board) {
        List gridCells = board.gridCells();

        String row1 = gridCells.get(0) + " | " + gridCells.get(1) + " | " + gridCells.get(2) + "\n";
        String row2 = gridCells.get(3) + " | " + gridCells.get(4) + " | " + gridCells.get(5) + "\n";
        String row3 = gridCells.get(6) + " | " + gridCells.get(7) + " | " + gridCells.get(8);

        String wholeGrid = row1 + row2 +row3;

        console.println(wholeGrid);
    }

    public void announceWinner(String playerMark) {
        console.println(String.format("Player %s wins!", playerMark));
    }

    public void announceTie() {
        console.println("It\'s a tie!");
    }

    public void notifyInvalid(String prompt) {
        console.println(String.format("Invalid %s", prompt));
    }

    public String getInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            this.userInput = reader.readLine();
        } catch (IOException e) {
            console.println("Trouble reading input: " + e);
        }
        return this.userInput;
    }
}
