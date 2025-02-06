import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        int mvpScore = 0;
        int mvpID = 0;
        for (int i = 0; i < players.size(); i++) {
            int individualScore = players.get(i).getScore() * 1000 - players.get(i).getSteps();
            if (individualScore > mvpScore) {
                mvpScore = individualScore;
                mvpID = i;
            }
        }
        return players.get(mvpID);
    }
}