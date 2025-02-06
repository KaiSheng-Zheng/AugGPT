import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player>players;

    public GameSystem(){
        players=new ArrayList<>();
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int t=0;
        for (int i=0;i<players.size();i++){
            if( players.get(i).getScore() > players.get(t).getScore()){
                t=i;
            }
            else if( players.get(i).getScore() == players.get(t).getScore()&&players.get(i).getStep()<players.get(t).getStep()){
                t=i;
            }
        }
        return players.get(t);
    }



}
