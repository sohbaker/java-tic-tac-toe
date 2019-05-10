import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public List grid = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public Boolean isEmpty() {
        return !grid.contains("X") && !grid.contains("O");
    }

    public Object markBoard(int position, String mark) {
        return grid.set(position - 1, mark);
    }

    public Object getMarkAtPosition(int position) {
        int index = position - 1;
        return grid.get(index);
    }

    public Boolean isValidMove(int position) {
        int index = position - 1;
        return grid.get(index) != "X" && grid.get(index) != "O";
    }

    public Boolean playerHasWon(String mark) {
        // knows what the winning combinations for the board are
        // checks the mark against those winning combinations
        // returns true if the same mark is present for all positions in a winning combination
    }
}