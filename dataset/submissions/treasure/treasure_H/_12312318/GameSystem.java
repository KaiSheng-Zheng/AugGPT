import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> MaxPlayers = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
    }


    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns, treasures);
        return map;
    }


    public Player getWinner() {
        int max = 0;
        int min =9999;
        Player maxplayer = null;
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getScore() >= max) {
                max = player.getScore();
            }
        }

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getScore() == max) {
                MaxPlayers.add(player);
            }
        }

        for (int i = 0; i < MaxPlayers.size(); i++) {
            Player player = MaxPlayers.get(i);
            if (player.getSteps() < min) {
                min = player.getSteps();
                maxplayer=player;
            }
        }
        return maxplayer;
    }
}
