import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public List grid = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static final int[][] allWinningCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {0, 4, 8}};

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
        boolean win = false;
        Integer countOccurenceOfMark = 0;
        for (int i = 0; i < allWinningCombinations.length; i++) {
            int[] singleCombination = allWinningCombinations[i];
            for (int b = 0; b < singleCombination.length; b++) {
                if (mark.equals(grid.get(singleCombination[b]))) countOccurenceOfMark++;
                if (countOccurenceOfMark.equals(3)) win = true;
            }
            countOccurenceOfMark = 0;
        }
        return win;
    }
}