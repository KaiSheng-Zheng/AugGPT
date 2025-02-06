import java.util.List;
import java.util.ArrayList;

public class GameSystem {
    private List<Player> players = new ArrayList<Player>();
    private int count = 0;

    public void addPlayer(Player player) {
        player.setId(count);
        players.add(player);
        count++;
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        int pin = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() > players.get(pin).getScore()) {
                pin = i;
            } else if (players.get(i).getScore() == players.get(pin).getScore()
                    && players.get(i).getSteps() < players.get(pin).getSteps()) {
                pin = i;
            }
        }
        return players.get(pin);
    }

}