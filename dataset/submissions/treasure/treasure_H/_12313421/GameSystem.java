import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> a=new ArrayList<Player>();
    private Map map;
    public void addPlayer(Player player){
        a.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        Player temp=a.get(0);
        for (int i=1;i<a.size();i++){
            if (temp.getScore()< a.get(i).getScore()) {
                temp=a.get(i);
            }
        }
        for (int i=0;i<a.size();i++)
            if ((temp.getScore()==a.get(i).getScore())&&(temp.getSteps()>a.get(i).getSteps()))
                temp=a.get(i);
        return temp;

    }
}
