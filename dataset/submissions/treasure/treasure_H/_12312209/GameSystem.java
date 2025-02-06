import java.util.ArrayList;
import java.util.Comparator;

public class GameSystem {
    private ArrayList<Player> playerlist=new ArrayList<>();
    public void addPlayer(Player player){
    playerlist.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        playerlist.sort(Comparator.comparingInt(Player::getScore));
        return playerlist.get(0);
    }
}