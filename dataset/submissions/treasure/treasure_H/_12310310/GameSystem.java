import java.util.ArrayList;
import java.util.Collections;

public class GameSystem {
    private ArrayList<Player> plyingplayers = new ArrayList<>();
    public void addPlayer(Player player){
        plyingplayers.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Collections.sort(plyingplayers);
        return plyingplayers.get(0);
    }

}
