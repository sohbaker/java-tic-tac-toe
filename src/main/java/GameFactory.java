public class GameFactory {
    private Display display;
    private GameSaver gameSaver;
    private Game game;

    public GameFactory(Display display, String filename) {
        this.display = display;
        this.gameSaver = new GameSaver(filename, display);
    }

    public Game loadGame() {
        gameSaver.readFile();
        if (this.gameSaver.fileNotFound || this.gameSaver.savedGameIsOver()) {
            game = createNewGame();
        } else {
            game = loadSavedGame();
        }
        return game;
    }

    public Game createNewGame() {
        String gameType = display.askForGameType();
        String[] chosenMarks = getPlayerMarks(gameType);
        game = setUpNewGame(gameType, chosenMarks);
        return game;
    }

    private String[] getPlayerMarks(String gameType) {
        String[] chosenMarks = new String[2];
        if (gameType.equalsIgnoreCase("hh")) {
            chosenMarks = display.getPlayersToChooseMarks();
        } else if (gameType.equalsIgnoreCase("hc")) {
            chosenMarks = display.getPlayersToChooseMarks("\uD83D\uDDA5");
        }
        return chosenMarks;
    }

    private Game setUpNewGame(String gameType, String[] marks) {
        String[] playerTypes = gameType.split("");
        Board board = new Board(marks);
        PlayerFactory playerFactory = new PlayerFactory(board, display);
        Player player1 = playerFactory.createPlayer(marks[0], playerTypes[0]);
        Player player2 = playerFactory.createPlayer(marks[1], playerTypes[1]);
        return new Game(board, display, player1, player2, gameSaver);
    }

    public Game loadSavedGame() {
        return this.gameSaver.reloadSavedGame();
    }
}
