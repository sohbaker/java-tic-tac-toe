public class Run {
    private static Game game;
    private static Display display = new Display(System.out, System.in);

    public static void main(String[] args) {
        display.printGreeting();
        String gameType = getGameType();
        String[] chosenMarks = getPlayersToChooseMarks();
        setUpGame(gameType, chosenMarks);
        game.play();
    }

    private static String getGameType() {
        display.askforGameType();
        String gameType = display.getInput();
        if (gameType.equalsIgnoreCase("hh")) {
            return gameType;
        } else {
            display.print("Coming soon!");
            System.exit(0);
        }
        return "";
    }

    private static String[] getPlayersToChooseMarks() {
        String[] marks = new String[2];
        display.promptForMark("Player 1");
        marks[0] = display.getInput();
        display.promptForMark("Player 2");
        marks[1] = display.getInput();

        for (String mark : marks) {
            mark = mark.replaceAll("\\s", "");
        }
        return marks;
    }

    private static void setUpGame(String gameType, String[] marks) {
        PlayersFactory playerFactory = new PlayersFactory();
        Players getPlayers = playerFactory.getPlayers(gameType);
        Player[] players = getPlayers.createPlayers(marks[0], marks[1], display);

        Board board = new Board(marks);
        game = new Game(board, display, players[0], players[1]);
    }
}

