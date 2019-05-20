class FakePlayer implements Player {
    private String mark;
    private Display display;
    private int move;

    FakePlayer(String mark, Display display, int move) {
        this.mark = mark;
        this.display = display;
        this.move = move;
    }

    public String getMark() {
        return this.mark;
    }

    public int getMove() {
        return this.move;
    }
}
