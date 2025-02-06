

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GameSystem {
    ArrayList<Player> players=new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
   
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner() {
        Collections.sort(players, Comparator.comparingInt(Player::getSteps));
        Collections.sort(players, Comparator.comparingInt(Player::getScore).reversed());
        return players.get(0);
    }
}
