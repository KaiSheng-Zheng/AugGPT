import java.util.ArrayList;
public class GameSystem {
    private Map map;
    private ArrayList<Player> players=new ArrayList<Player>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        Player winner=players.get(0);
        for(Player x:players){
            if((winner.getScore()<x.getScore())|((winner.getScore()==x.getScore())&(winner.getSteps()>x.getSteps()))){
                //System.out.println(999);
                //System.out.println(winner.getSteps());
                //System.out.println(x.getSteps());
                //System.out.println(winner.getScore());
                //System.out.println(x.getScore());
                winner=x;
                //System.out.println(666);
                //System.out.println(x.getId());
            }
        }
        return winner;
    }
}
