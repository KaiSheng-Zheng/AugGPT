import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class GameSystem {
    private List<Player> players;
    public GameSystem(){
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
         Map game = new Map(rows, columns, treasures);
         return game;
    }

    public Player getWinner() {
        return players.stream()
                .max(Comparator.comparing(Player::getScore)
                        .thenComparing(Comparator.comparingInt(Player::getSteps).reversed()))
                .orElse(null);
    }
}

