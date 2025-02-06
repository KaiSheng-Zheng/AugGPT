import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> PlayerList =new ArrayList<Player>();
    public void addPlayer(Player player){
        PlayerList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
       Map map = new Map(rows,columns,treasures);
       return map;
    }
    public Player getWinner(){
        Player winner=PlayerList.get(0);
        for(int i=1;i<PlayerList.size();i++){
            if(PlayerList.get(i).getScore()>winner.getScore()){
                winner=PlayerList.get(i);
            }else{
                if(PlayerList.get(i).getScore()==winner.getScore()){
                    if(PlayerList.get(i).getSteps()<winner.getSteps()){
                        winner=PlayerList.get(i);
                    }
                }
            }
        }
        return winner;
    }

}
