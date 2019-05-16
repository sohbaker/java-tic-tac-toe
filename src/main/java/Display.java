import java.util.ArrayList;
import java.util.List;

public class Display {
    public void greeting() {
        System.out.println("Welcome!");
    }

    public void promptPlayer(String playerMark) {
        String prompt = String.format("Make a move: %s", playerMark);
        System.out.println(prompt);
    }

    private List currentGridCells(Board board, int size) {
        List currentGridAsArray = new ArrayList<>();
        Board boardClass = board;
        int boardSize = size;
        int count = 1;

        while (count <= boardSize) {
            String cell = boardClass.getCellAtPosition(count);
            currentGridAsArray.add(cell);
            count++;
        }

        return currentGridAsArray;
    }

    public void showBoardGrid(Board board, int size) {
        List gridCells = currentGridCells(board, size);

        String row1 = gridCells.get(0) + " | " + gridCells.get(1) + " | " + gridCells.get(2) + "\n";
        String row2 = gridCells.get(3) + " | " + gridCells.get(4) + " | " + gridCells.get(5) + "\n";
        String row3 = gridCells.get(6) + " | " + gridCells.get(7) + " | " + gridCells.get(8);

        System.out.println(row1 + row2 + row3);
    }
}
