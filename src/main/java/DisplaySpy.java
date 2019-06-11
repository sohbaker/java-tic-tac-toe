import java.io.*;

public class DisplaySpy extends Display {
    private boolean win = false;
    private boolean tie = false;
    private boolean invalid = false;
    private boolean savedGame = false;
    private boolean reloadedGame = false;

    public DisplaySpy(PrintStream output, InputStream input) {
        super(output, input);
    }

    @Override
    public void printGrid(Board board) {
    }

    @Override
    public void promptPlayer(String mark) {
    }

    @Override
    public String askForGameType() {
        return getInput();
    }

    @Override
    public String[] getPlayersToChooseMarks(String... args) {
        String[] marks = {"X","O"};
        return marks;
    }

    @Override
    public void notifyInvalid(String prompt) {
        this.invalid = true;
    }

    @Override
    public void announceWinner(String mark) {
        this.win = true;
    }

    @Override
    public void announceTie() {
        this.tie = true;
    }

    @Override
    public void confirmGameIsSaved() {
        this.savedGame = true;
    }

    @Override
    public void confirmSavedGameHasReloaded() {
        this.reloadedGame = true;
    }

    @Override
    public void printMessage(String mark) {
    }

    public boolean announceWinnerShouldHaveBeenCalled() {
        return win;
    }

    public boolean announceTieShouldHaveBeenCalled() {
        return tie;
    }

    public boolean notifyInvalidShouldHaveBeenCalled() {
        return invalid;
    }

    public boolean confirmGameIsSavedShouldHaveBeenCalled() {
        return savedGame;
    }

    public boolean confirmGameReloadedShouldHaveBeenCalled() {
        return reloadedGame;
    }
}
