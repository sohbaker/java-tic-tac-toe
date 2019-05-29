import java.io.*;

public class DisplaySpy extends Display {
    private boolean win = false;
    private boolean tie = false;

    public DisplaySpy(PrintStream console, InputStream input) {
        super(console, input);
    }

    @Override
    public void printGrid(Board board) {
    }

    @Override
    public void promptPlayer(String mark) {
    }

    @Override
    public void announceWinner(String mark) {
        this.win = true;
    }

    @Override
    public void announceTie() {
        this.tie = true;
    }

    public boolean announceWinnerShouldHaveBeenCalled() {
        return win;
    }

    public boolean announceTieShouldHaveBeenCalled() {
        return tie;
    }
}
