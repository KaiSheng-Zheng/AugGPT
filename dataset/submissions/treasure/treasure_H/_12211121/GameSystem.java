
import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;
    private Map map;
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        this.map = new Map(rows, columns, treasures);
        return this.map;
    }
    public GameSystem(){
        this.players = new ArrayList<>();

    }
    // Return the player with the highest score as the winner. If two players have the same score, return the player with the least steps.
    public Player getWinner(){
        Player winner = null;
        for (Player player : players) {
            if (winner == null) {
                winner = player;
            } else {
                if (player.getScore() > winner.getScore()) {
                    winner = player;
                } else if (player.getScore() == winner.getScore()) {
                    if (player.getSteps() < winner.getSteps()) {
                        winner = player;
                    }
                }
            }
        }
        return winner;
    }

}
