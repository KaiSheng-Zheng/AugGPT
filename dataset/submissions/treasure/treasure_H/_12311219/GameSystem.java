import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players = new ArrayList<>();

  
    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {


        Player winner = players.get(0);
        int temMaxScore = winner.getScore();
        int temMinSteps = winner.getSteps();

        for (int i = 1; i < players.size(); i++) {
            Player temwinner = players.get(i);
            int playerScore = temwinner.getScore();
            int playerSteps = temwinner.getSteps();

            if (playerScore > temMaxScore || (playerScore == temMaxScore && playerSteps < temMinSteps)) {
                winner = temwinner;
                temMaxScore = playerScore;
                temMinSteps = playerSteps;
            }
        }

        return winner;
    }
}