import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;


    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows, columns,treasures);
    }

    public Player getWinner() {
        Player winner = null;
        int highestScore = Integer.MIN_VALUE;

        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                winner = player;
            }
        }

        return winner;
    }

}
