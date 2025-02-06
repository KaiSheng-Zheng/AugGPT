import  java.util.ArrayList;
import java.util.Properties;
public class GameSystem {
    ArrayList<Player> PlayerList= new ArrayList<>();
    public void addPlayer(Player player){
        PlayerList.add(player);
    }
    private Map map;
    public Map newGame(int rows, int columns, Treasure... treasures){
         return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        int index=0;
        int count=0;
        int highestScore=PlayerList.get(0).getScore();
        for (int i = 0; i < PlayerList.size(); i++) {

          {
            if (PlayerList.get(i).getScore()>highestScore||(PlayerList.get(i).getScore()==highestScore&&PlayerList.get(i).getSteps()<PlayerList.get(index).getSteps()))
index=i;}

        }
        return PlayerList.get(index);
    }
}
