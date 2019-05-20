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

    public String getMove() throws IOException {
        return display.getInput();
    }
}
