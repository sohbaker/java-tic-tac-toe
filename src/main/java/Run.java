import java.io.*;

public class Run {
    private static Game game;
    private static Display display = new Display(System.out, System.in);

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
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(arg));
            boolean gameIsOver = (boolean) file.readObject();
            if (gameIsOver) {
                createNewGame();
            } else {
                reloadPreviousGame(file);
            }
        } catch (IOException ex) {
            System.out.println("IOException caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
    }

    private static void createNewGame() {
        String gameType = getGameType();
        String[] chosenMarks = getPlayerMarks(gameType);
        setUpNewGame(gameType, chosenMarks);
    }

    private static void reloadPreviousGame(ObjectInputStream in) {
        try {
            Board savedBoard = (Board) in.readObject();
            String playerOneMark = (String) in.readObject();
            String playerTwoMark = (String) in.readObject();
            Human player1 = new Human(playerOneMark, display);
            Human player2 = new Human(playerTwoMark, display);
            game = new Game(savedBoard, display, player1, player2);
            display.confirmSavedGameHasReloaded();
        } catch (IOException ex) {
            System.out.println(String.format("IO Exception %s", ex));
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
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
        PlayersFactory playerFactory = new PlayersFactory(playerTypes, board, display);
        Player player1 = playerFactory.createPlayer(marks[0]);
        Player player2 = playerFactory.createPlayer(marks[1]);
        game = new Game(board, display, player1, player2);
    }
}

