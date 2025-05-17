public class PlayerFactory {
        public Player createPlayer(String playerId, String playerName) {
            return new Player(playerId, playerName);
        }
    }