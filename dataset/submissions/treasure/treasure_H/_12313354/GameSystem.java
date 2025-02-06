
import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns,treasures );
        return map;
    }

    public Player getWinner() {
        Player winner = null;
        int maxScore = -1;
        int minSteps = Integer.MAX_VALUE;

        for (int i = 0; i < players.size(); i++) {
            Player player =(Player) players.get(i);
            if (player.getScore() > maxScore || (player.getScore() == maxScore && player.getSteps() < minSteps)) {
                winner = player;
                maxScore = player.getScore();
                minSteps = player.getSteps() ;
            }
        }

        return winner;
    }
}