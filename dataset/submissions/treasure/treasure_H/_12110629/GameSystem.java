import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameSystem {
    private List<Player> players=new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        Player oldestPerson = players.stream()
                .max(Comparator.comparingInt(Player::getScore))
                .orElse(null);

        return oldestPerson;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
