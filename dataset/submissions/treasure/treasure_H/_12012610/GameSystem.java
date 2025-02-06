import java.util.Arrays; // Import statement for Arrays
import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players;

    // Constructor
    public GameSystem() {
        this.players = new ArrayList<>();
    }

    // Add a new player to the game
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Start a new game
    public Map newGame(int rows, int columns, Treasure... treasures) {
        // Directly pass the treasures array to the Map constructor
        return new Map(rows, columns, treasures);
    }


    // Get the winner
    public Player getWinner() {
        if (players.isEmpty()) {
            return null; // or handle this case as per requirements
        }

        Player winner = players.get(0);
        for (Player player : players) {
            // First compare scores
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
            // If scores are equal, compare steps (fewer steps is better)
            else if (player.getScore() == winner.getScore() && player.getSteps() < winner.getSteps()) {
                winner = player;
            }
        }
        return winner;
    }


}
