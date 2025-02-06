import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map GameMap = new Map(rows,columns,treasures);
        players = new ArrayList<>();
        return GameMap;
    }

    public Player getWinner() {
        Player winner = players.get(0);
        for (Player pl:
             players) {
            if(pl.getScore() > winner.getScore()) winner = pl;
            else if(pl.getScore() == winner.getScore())
                        if(pl.getSteps() < winner.getSteps()) winner = pl;
        }
        return winner;
    }

}
