import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameSystem {
    private ArrayList<Player> players;

    public GameSystem(){
        players=new ArrayList<>();

    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public static int max(int[] a) {
        Arrays.sort(a);
        return a[a.length - 1];
    }
    public Player getWinner(){
        Collections.sort(players);
return players.get(1);
    }
}


