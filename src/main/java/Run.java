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
            reloadPreviousGame(args[0]);
        }
        game.play();
    }

    private static void createNewGame() {
        String gameType = getGameType();
        String[] chosenMarks = getPlayersToChooseMarks();
        setUpNewGame(gameType, chosenMarks);
    }

    private static void reloadPreviousGame(String args) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(args));
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
        if (gameType.equalsIgnoreCase("hh")) {
            return gameType;
        } else {
            display.printMessage("Coming soon!");
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
            mark.replaceAll("\\s", "");
        }
        return marks;
    }

    private static void setUpNewGame(String gameType, String[] marks) {
        PlayersFactory playerFactory = new PlayersFactory();
        Players getPlayers = playerFactory.getPlayers(gameType);
        Player[] players = getPlayers.createPlayers(marks[0], marks[1], display);

        Board board = new Board(marks);
        game = new Game(board, display, players[0], players[1]);
    }
}

