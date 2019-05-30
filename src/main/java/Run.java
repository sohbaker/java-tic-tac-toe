public class Run {
    private static Game game;
    private static Display display = new Display(System.out, System.in);

    public static void main(String[] args) {
        display.printGreeting();
        String[] chosenMarks = getPlayersToChooseMarks();
        setUpGame(chosenMarks);
        game.play();
    }

    private static String[] getPlayersToChooseMarks() {
        String[] marks = new String[2];
        display.promptForMark("Player 1");
        marks[0] = display.getInput();
        display.promptForMark("Player 2");
        marks[1] = display.getInput();

        for(String mark : marks) {
            mark = mark.replaceAll("\\s", "");
        }
        return marks;
    }

    private static void setUpGame(String[] marks) {
        Board board = new Board(marks);
        Player playerOne = new Human(marks[0],display);
        Player playerTwo = new Human(marks[1], display);
        game = new Game(board, display, playerOne, playerTwo);
    }
}

