import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class GameSystem {
    private ArrayList<Player> playerList=new ArrayList<>();
    public ArrayList<Player> getPlayerList(){return this.playerList;}
    public void addPlayer(Player player){
        playerList.add(player);
    }
    public Map newGame(int rows,int columns,Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player res=null;
        for(Player x:playerList){
            if(res==null)res=x;
            else if(x.getScore()>res.getScore())res=x;
            else if(x.getScore()==res.getScore()&&x.getSteps()<res.getSteps())res=x;
        }
        return res;
    }
}