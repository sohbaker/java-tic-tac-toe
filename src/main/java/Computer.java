import java.util.*;

public class Computer implements Player {
    private String mark;
    private Board board;

    public Computer(Board board, String mark) {
        this.board = board;
        this.mark = mark;
    }

    public String getMark() {
        return this.mark;
    }

    public int getMove() {
        Random selectRandom = new Random();
        List<String> availableMoves = board.availableMoves();
        String move = availableMoves.get(selectRandom.nextInt(availableMoves.size()));
        return Integer.parseInt(move);
    }
}
