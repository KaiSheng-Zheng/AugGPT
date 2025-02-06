import java.util.ArrayList;
public class GameSystem {
    ArrayList<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    ArrayList<Player> scoremax = new ArrayList<>();
    int max = 0;
    public Player getWinner() {
        for (Player p :
                players) {
            if (p.getScore() >=max) {
                max = p.getScore();
            }
        }
        for (Player p :
                players) {
            if (p.getScore() == max) {
                scoremax.add(p);
            }
        }Player stepsmin = scoremax.get(0);
        for (int i = 1; i < scoremax.size(); i++) {
            if (stepsmin.getSteps() > scoremax.get(i).getSteps()) {
                stepsmin = scoremax.get(i);
            }
        }return stepsmin;
    }
    /*public Player getWinner() {
        Player winner = null;
        int maxScore = Integer.MIN_VALUE;
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getScore() > maxScore || (player.getScore() == maxScore && player.getSteps() < minSteps)) {
                maxScore = player.getScore();
                minSteps = player.getSteps();
                winner = player;
            }
        }
        return winner;
    }*/

}
