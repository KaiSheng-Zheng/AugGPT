import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private ArrayList<Player> players;
    public GameSystem(){
        players = new ArrayList<>();
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows, columns, treasures);
    }
    public Player getWinner() {
        if (players.isEmpty()) {
            return null;
        }

        Player winner = players.get(0);
        List<Player> sameScorePlayers = new ArrayList<>();

        for (Player p : players) {
            int score = p.getScore();

            if (score > winner.getScore()) {
                winner = p;
                sameScorePlayers.clear();
            } else if (score == winner.getScore()) {
                sameScorePlayers.add(p);
            }
        }

        if (sameScorePlayers.size() > 1) {
            winner = findWinnerWithLeastSteps(sameScorePlayers);
        }

        return winner;
    }

    private Player findWinnerWithLeastSteps(List<Player> players) {
        Player winner = players.get(0);

        for (Player p : players) {
            if (p.getSteps() < winner.getSteps()) {
                winner = p;
            }
        }

        return winner;
    }
}
