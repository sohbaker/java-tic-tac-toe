import java.util.ArrayList;
import java.util.List;

public class Display {
    public String greeting() {
        return "Welcome";
    }

    public String promptPlayer(String playerMark) {
       return String.format("Make a move: %s", playerMark);
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

    public String showBoardGrid(Board board, int size) {
        List gridCells = currentGridCells(board, size);

        String row1 = gridCells.get(0) + " | " + gridCells.get(1) + " | " + gridCells.get(2) + "\n";
        String row2 = gridCells.get(3) + " | " + gridCells.get(4) + " | " + gridCells.get(5) + "\n";
        String row3 = gridCells.get(6) + " | " + gridCells.get(7) + " | " + gridCells.get(8);

        return row1 + row2 + row3;
    }
}
