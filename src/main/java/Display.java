import java.io.*;
import java.util.List;

public class Display implements Serializable {
    String userInput = "";
    PrintStream output;
    InputStream input;

    public Display(PrintStream output, InputStream input) {
        this.output = output;
        this.input = input;
    }

    public void printGreeting() {
        output.println("Welcome to Tic Tac Toe!");
    }

    public void printInstructions() {
        output.println("At any point you can type 'exit' to leave the game and continue at a later time");
    }

    public void promptPlayer(String playerMark) {
        output.println(String.format("Make a move: %s", playerMark));
    }

    public String askForGameType() {
        output.println("Type hh to play Human vs Human, or hc to play Human vs Computer");
        return getInput();
    }

    public void promptForMark(String prompt) {
        output.println(String.format("%s, please choose your mark for the game:", prompt));
    }

    public String[] getPlayersToChooseMarks(String... args) {
        String[] marks = new String[2];

        if (args.length == 0) {
            promptForMark("Player 1");
            marks[0] = getInput();
            promptForMark("Player 2");
            marks[1] = getInput();
        } else {
            promptForMark("Player 1");
            marks[0] = getInput();
            marks[1] = args[0];
        }

        for (String mark : marks) {
            mark.replaceAll("\\s", "");
        }

        return marks;
    }

    public void printGrid(Board board) {
        List gridCells = board.gridCells();

        String row1 = gridCells.get(0) + " | " + gridCells.get(1) + " | " + gridCells.get(2) + "\n";
        String row2 = gridCells.get(3) + " | " + gridCells.get(4) + " | " + gridCells.get(5) + "\n";
        String row3 = gridCells.get(6) + " | " + gridCells.get(7) + " | " + gridCells.get(8);

        String wholeGrid = row1 + row2 + row3;

        output.println(wholeGrid);
    }

    public String getInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            this.userInput = reader.readLine();
        } catch (IOException e) {
            output.println("Trouble reading input: " + e);
        }
        return this.userInput;
    }

    public void notifyInvalid(String prompt) {
        output.println(String.format("Invalid %s. Please try again", prompt));
    }

    public void announceWinner(String playerMark) {
        output.println(String.format("Player %s wins!", playerMark));
    }

    public void announceTie() {
        output.println("It\'s a tie!");
    }

    public void printMessage(String message) {
        output.println(message);
    }

    public void confirmGameIsSaved() {
        output.println("Your game has been saved!");
    }

    public void confirmSavedGameHasReloaded() {
        output.println("Here's your saved game:");
    }
}
