import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;
    private ArrayList<Player> sameScorePlayers;

    public GameSystem() {
        players = new ArrayList<>();
        sameScorePlayers = new ArrayList<>();
    }
    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        int index = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() > players.get(index).getScore()) index = i;
        }

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() == players.get(index).getScore()) sameScorePlayers.add(players.get(i));
        }
        index = 0;
        if (sameScorePlayers.size() == 1) return sameScorePlayers.get(0);
        else {
            for (int i = 0; i <sameScorePlayers.size(); i++) {
                if (sameScorePlayers.get(i).getSteps()<sameScorePlayers.get(index).getSteps())index=i;
            }
            return sameScorePlayers.get(index);
        }
    }
}
