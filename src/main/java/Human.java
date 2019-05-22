class Human implements Player {
    private String mark;
    private Display display;

    public Human(String mark, Display display) {
        this.mark = mark;
        this.display = display;
    }

    public String getMark() {
        return this.mark;
    }

    public int getMove() {
        String move = display.getInput();
        return Integer.parseInt(move);
    }
}
