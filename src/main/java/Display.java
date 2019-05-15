import java.util.ArrayList;
import java.util.List;

public class Display {
    public String greeting() {
        String x = "Welcome!";
        return x;
    }

    public String promptPlayer(String playerMark) {
        String prompt = String.format("Make a move: %s", playerMark);
        return prompt;
    }

    public String createArrayListOfCurrentGrid(Board board, int size) {
        List currentBoardAsArray = new ArrayList<>();
        Board boardClass = board;
        int boardSize = size;
        int count = 1;

        while (count <= boardSize) {
            String cell = boardClass.getCellAtPosition(count);
            currentBoardAsArray.add(cell);
            count++;
        }

        String boardArraysAsString = currentBoardAsArray.toString();
        String arrayStringWithoutBrackets = boardArraysAsString.replace("[", "").replace("]","");

        return arrayStringWithoutBrackets;
    }
}
