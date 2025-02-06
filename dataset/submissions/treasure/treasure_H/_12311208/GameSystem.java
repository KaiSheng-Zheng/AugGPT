import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameSystem {
    private List<Player> players;
    private Map currentMap;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        currentMap = new Map(rows, columns, treasures);
        for (Player player : players) {
            player.reset();
        }
        return currentMap;
    }

    public Player getWinner() {
        if (currentMap != null &&!currentMap.isActive()) {
            return players.stream()
                    .max(Comparator.comparingInt(Player::getScore)
                            .thenComparingInt(Player::getSteps))
                    .orElse(null);
        }
        return null;
    }
}