
import java.util.ArrayList;
import java.util.List;
public class GameSystem {
    private List<Player> players = new ArrayList<>();
    Map map;
    public GameSystem(){

    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures) {
         Map map = new Map(rows, columns, treasures);
         this.map=map;
        return map;
    }
    public Player getWinner() {
        if(!map.isActive()) {
            Player winner = players.get(0);
            for (Player player : players) {
                if (player.getScore() > winner.getScore()) {
                    winner = player;
                } else if (player.getScore() == winner.getScore()) {
                    // If two players have the same score, return the player with the least steps
                    if (player.getSteps() < winner.getSteps()) {
                        winner = player;
                    }
                }
            }
            return winner;
        }else {
            return null;
        }
    }
}
