public class Run {
    private static Game game;
    private static Display display = new Display(System.out, System.in);
    private static String filename = "saved_game.txt";
    private static GameSaver gameSaver = new GameSaver(filename, display);

    public static void main(String[] args) {
        display.printGreeting();
        display.printInstructions();
        if (args.length == 0) {
            createNewGame();
        } else {
            determineWhatTypeOfGameToLoad(args[0]);
        }
        game.play();
    }

    private static void determineWhatTypeOfGameToLoad(String arg) {
        if (gameSaver.savedGameIsOver()) {
            createNewGame();
        } else {
            gameSaver.reloadSavedGame();
        }
    }

    private static void createNewGame() {
        String gameType = getGameType();
        String[] chosenMarks = getPlayerMarks(gameType);
        setUpNewGame(gameType, chosenMarks);
    }

    private static String getGameType() {
        display.askForGameType();
        String gameType = display.getInput();
        return gameType;
    }

    private static String[] getPlayerMarks(String gameType) {
        String[] chosenMarks = new String[2];
        if (gameType.equalsIgnoreCase("hh")) {
            chosenMarks = display.getPlayersToChooseMarks();
        } else if (gameType.equalsIgnoreCase("hc")) {
            chosenMarks = display.getPlayersToChooseMarks("\uD83D\uDDA5");
        }
        return chosenMarks;
    }

    private static void setUpNewGame(String gameType, String[] marks) {
        String[] playerTypes = gameType.split("");
        Board board = new Board(marks);
        PlayerFactory playerFactory = new PlayerFactory(board, display);
        Player player1 = playerFactory.createPlayer(marks[0], playerTypes[0]);
        Player player2 = playerFactory.createPlayer(marks[1], playerTypes[1]);
        game = new Game(board, display, player1, player2, gameSaver);
    }
}

