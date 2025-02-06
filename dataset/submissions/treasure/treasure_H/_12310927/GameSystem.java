import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player>PlayersList=new ArrayList<Player>();
    private Map map;

    public Map getMap() {
        return map;
    }

    public void addPlayer(Player player){
        PlayersList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        Player winner=PlayersList.get(0);
        for(int i=1;i<PlayersList.size();i++){
            if(PlayersList.get(i).getScore()> winner.getScore()){
                winner=PlayersList.get(i);
            }else {
                if(PlayersList.get(i).getScore()==winner.getScore()){
                    if(PlayersList.get(i).getSteps()< winner.getSteps()){
                        winner=PlayersList.get(i);
                    }
                }
            }
        }
        return winner;
    }
}