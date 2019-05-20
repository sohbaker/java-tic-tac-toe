import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Display {
    public void printGreeting() {
        System.out.println("Welcome to TicTacToe!");
    }

    public void promptPlayer(String playerMark) {
        System.out.println(String.format("Make a move: %s", playerMark));
    }

    private List<String> currentGridCells(Board board, int size) {
        List<String> currentGridAsArray = new ArrayList<>();
        Board boardClass = board;
        int gridSize = size;
        int count = 1;

        while (count <= gridSize) {
            String cell = boardClass.getCellAtPosition(count);
            currentGridAsArray.add(cell);
            count++;
        }
        return currentGridAsArray;
    }

    public void printGrid(Board board, int size) {
        List<String> gridCells = currentGridCells(board, size);

        String row1 = gridCells.get(0) + " | " + gridCells.get(1) + " | " + gridCells.get(2) + "\n";
        String row2 = gridCells.get(3) + " | " + gridCells.get(4) + " | " + gridCells.get(5) + "\n";
        String row3 = gridCells.get(6) + " | " + gridCells.get(7) + " | " + gridCells.get(8);

        System.out.println(row1 + row2 + row3);
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

    public static String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
