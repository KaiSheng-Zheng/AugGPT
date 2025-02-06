import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        // Implement new game logic
        return new Map(rows, columns, treasures); // Placeholder return value
    }

    public Player getWinner() {
        // Implement get winner logic
        return players.get(0); // Placeholder return value
    }
}

class PlayerIdGenerator {
    private static int idCounter = 1;

    public static int generateId() {
        return idCounter++;
    }
}