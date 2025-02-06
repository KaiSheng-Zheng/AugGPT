import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class GameSystem {
    private final List<Player> players;
    private Map currentMap;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        currentMap = new Map(rows, columns, treasures);
        return currentMap;
    }

    public Player getWinner() {
        if (currentMap.isActive()) {
            return null; // The game is still active, we cannot determine the winner yet.
        }

        // The winner is the player with the highest score, and in case of a tie, the one with the least steps.
        return players.stream()
                .max(Comparator.comparingInt(Player::getScore)
                        .thenComparingInt(Player::getSteps))
                .orElse(null);
    }
}
