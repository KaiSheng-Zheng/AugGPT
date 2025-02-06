import java.util.ArrayList;

public class GameSystem {
    public ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < players.size(); i++) {
            if (max < players.get(i).getScore()) {
                max = players.get(i).getScore();
                index = i;
            } else if (max == players.get(i).getScore() && players.get(index).getSteps() > players.get(i).getSteps()) {
                max = players.get(i).getScore();
                index = i;
            }
        }
        return players.get(index);
    }
}
