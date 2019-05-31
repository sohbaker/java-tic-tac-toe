public class PlayersFactory {
    public Players getPlayers(String gameType) {
        if(gameType == null) {
            return null;
        }

        if(gameType.equalsIgnoreCase("hh")) {
            return new HumanHuman();
        }

        return null;
    }
}
