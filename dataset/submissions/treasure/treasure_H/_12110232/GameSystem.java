import java.util.ArrayList;
public class GameSystem {
    ArrayList<Player> players = new ArrayList<>();

    public GameSystem() {
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Treasure[] treasureArray = new Treasure[treasures.length];
        System.arraycopy(treasures, 0, treasureArray, 0, treasures.length);
        Map map = new Map(rows, columns, treasureArray);
        return map;
    }

    public Player getWinner() {
        Player winner = null;
        int maxScore = Integer.MIN_VALUE;
        int minSteps = Integer.MAX_VALUE;

        for (Player player : players) {
            if (player.getScore() > maxScore || (player.getScore() == maxScore && player.getSteps() < minSteps)) {
                winner = player;
                maxScore = player.getScore();
                minSteps = player.getSteps();
            }
        }
        return winner;
    }
}
