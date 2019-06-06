import java.io.Serializable;
import java.util.*;

public class Board implements Serializable {
    private final List<String> grid = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    private static final int[][] WINNING_LINES = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {0, 4, 8}};
    private String[] PLAYER_MARKS = new String[2];

    public Board(String[] marks) {
        this.PLAYER_MARKS[0] = marks[0];
        this.PLAYER_MARKS[1] = marks[1];
    }

    public boolean isEmpty() {
        return !grid.contains(PLAYER_MARKS[0]) && !grid.contains(PLAYER_MARKS[1]);
    }

    public boolean isFull() {
        return availableMoves().isEmpty();
    }

    public void markBoard(int position, String mark) {
        grid.set(position - 1, mark);
    }

    public boolean isValidMove(int position) {
        int index = position - 1;
        return !grid.get(index).equals(PLAYER_MARKS[0]) && !grid.get(index).equals(PLAYER_MARKS[1]);
    }

    public boolean playerHasWon(String mark) {
        return playerHasWinningLine(mark);
    }

    public List<String> availableMoves() {
        List<String> availableCells = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            if (!grid.get(i).equals(PLAYER_MARKS[0]) && !grid.get(i).equals(PLAYER_MARKS[1])) availableCells.add(grid.get(i));
        }
        return availableCells;
    }

    public String getOpponentMark(String mark) {
        String opponent = null;

        for (String PLAYER_MARK : PLAYER_MARKS) {
            if(!PLAYER_MARK.equals(mark)) {
                opponent = PLAYER_MARK;
            }
        }
        return opponent;
    }

    public boolean isATie() {
        boolean tie = false;

        if((isFull() && !playerHasWon(PLAYER_MARKS[0])) || (isFull() && !playerHasWon(PLAYER_MARKS[1]))) {
            tie = true;
        }
        return tie;
    }

    public List gridCells() {
        List<String> gridCells = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            gridCells.add(getCellAtPosition(i));
        }
        return gridCells;
    }

    private String getCellAtPosition(int i) {
        return grid.get(i);
    }

    private boolean playerHasWinningLine(String mark) {
        for (int[] singleLine : WINNING_LINES) {
            if (Arrays.stream(singleLine).allMatch(x -> getCellAtPosition(x).equals(mark))) {
                return true;
            }
        }
        return false;
    }
}