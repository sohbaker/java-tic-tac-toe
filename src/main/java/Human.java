import java.io.IOException;

public class Human {
    private String mark;
    private Display display;

    Human(String mark, Display display) {
        this.mark = mark;
        this.display = display;
    }

    public String getMark() {
        return this.mark;
    }

    public int getMove() throws IOException{
        String move = display.getInput();
        return Integer.parseInt(move);
    }
}
