public class Human implements Player {
    private String mark;
    private Display display;
    private int moveAsInt;

    public Human(String mark, Display display) {
        this.mark = mark;
        this.display = display;
    }

    public String getMark() {
        return this.mark;
    }

    public int getMove() {
        String move = display.getInput();
        move = move.replaceAll("\\s","");

        if (move.matches("[0-9]+") && move.length() < 2) {
            moveAsInt = Integer.parseInt(move);
        } else {
            display.notifyInvalid("move");
            getMove();
        }
        return moveAsInt;
    }
}
