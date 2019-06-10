public class PlayerFactory {
    Board board;
    Display display;

    public PlayerFactory(Board board, Display display) {
        this.board = board;
        this.display = display;
    }

    public Player createPlayer(String mark, String type) {
        Player player = null;
        if (type.equalsIgnoreCase("h")) {
            player = new Human(mark, display);
        } else if (type.equalsIgnoreCase("c")) {
            player = new Computer(board, mark);
        }
        return player;
    }
}
