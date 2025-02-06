
import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players=new ArrayList<Player>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows,int columns,Treasure[] treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int best=0;
        for(int i=0;i<players.size();i++){
            if(players.get(i).isBetterThan(players.get(best)))
                best=i;
        }
        return players.get(best);
    }
}
