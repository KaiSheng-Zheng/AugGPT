import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> a=new ArrayList<>();
    public void addPlayer(Player player){
        a.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner() {
        Player max=a.get(0);
        for(Player player: a){
            if(player.getScore()>max.getScore()){
                max= player;
            }
            else if(player.getScore()==max.getScore()){
                if(player.getSteps()<max.getSteps())
                    max=player;
            }
        }
        return max;
    }
}
