import java.util.*;

public class FakePlayer implements Player {
    private String mark;
    private List<String> moves;

    public FakePlayer(String mark, List<String> moves) {
        this.mark = mark;
        this.moves = moves;
    }

    public String getMark() {
        return this.mark;
    }

    public int getMove() {
        String move = this.moves.get(0);
        this.moves = this.moves.subList(1, this.moves.size());

        if (move.equalsIgnoreCase("exit")) {
            return -2;
        } else {
            return Integer.parseInt(move);
        }
    }
}