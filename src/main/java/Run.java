public class Run {
    private static Game game;
    private static Display display = new Display(System.out, System.in);
    private static GameFactory gameFactory;
    private static String filename = "saved_game.txt";

    public static void main(String[] args) {
        gameFactory = new GameFactory(display, filename);
        display.printGreeting();
        display.printInstructions();
        game = gameFactory.loadGame();
        game.play();
    }
}

