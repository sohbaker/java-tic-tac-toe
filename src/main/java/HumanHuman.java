public class HumanHuman implements Players {
    @Override
    public Human[] createPlayers(String playerOne, String playerTwo, Display display) {
        Human obj[] = new Human[2];
        obj[0] = new Human(playerOne, display);
        obj[1] = new Human(playerTwo, display);
        return obj;
    }
}
