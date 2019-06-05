import java.util.*;

public class FakePlayer implements Player {
    private String mark;
    private Display display;
    private LinkedList<String> newMoves = new LinkedList<String>();
    private List<String> moves;

    public FakePlayer(String mark, Display display, List<String> moves) {
        this.mark = mark;
        this.display = display;
        this.moves = moves;
    }

    public String getMark() {
        return this.mark;
    }

    public int getMove() {
        this.newMoves.addAll(this.moves);
        String move = this.newMoves.pollFirst();

       if (move.equalsIgnoreCase("exit")) {
           return -2;
       } else {
           return Integer.parseInt(move);
       }
    }
}