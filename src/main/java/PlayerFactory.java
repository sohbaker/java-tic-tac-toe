public class PlayerFactory {
    String[] types;
    Board board;
    Display display;

    public PlayerFactory(String[] types, Board board, Display display) {
        this.types = types;
        this.board = board;
        this.display = display;
    }

    public Player createPlayer(String mark) {
        Player player = null;
        for(int i = 0; i < this.types.length; i++) {
            if (this.types[i].equalsIgnoreCase("h")) {
                player = new Human(mark, display);
            }
            if (this.types[i].equalsIgnoreCase("c")) {
                player = new Computer(board, mark);
            }
        }
        return player;
    }
}
