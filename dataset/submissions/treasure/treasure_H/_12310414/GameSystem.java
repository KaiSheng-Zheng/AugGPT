import java.util.ArrayList;
import java.util.List;
public class GameSystem {
    private List<Player> players= new ArrayList<>();
    private Map map;
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        this.map =new Map(rows, columns, treasures);
        return map;
    }
    public Player getWinner() {
        // Implementation for determining the winner based on the rules
        Player winner = null;
        int maxScore = Integer.MIN_VALUE;

        for (Player player : players) {
            if (player.getScore() > maxScore || (player.getScore() == maxScore && player.getSteps() < winner.getSteps())) {
                winner = player;
                maxScore = player.getScore();
            }
        }

        return winner;
    }

}
