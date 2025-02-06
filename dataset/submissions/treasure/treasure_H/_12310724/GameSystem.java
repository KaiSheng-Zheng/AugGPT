import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players=new ArrayList<Player>();

    public void addPlayer(Player player){

        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player maxn=new Player(-1,100000007);
        for(int i=0;i<players.size();++i){
            Player tmp=players.get(i);
            if(tmp.getScore()>maxn.getScore()){
                maxn=tmp;
            }
            else if(tmp.getScore()==maxn.getScore()){
                if(tmp.getSteps()<maxn.getSteps()){
                    maxn=tmp;
                }
            }
        }
        return maxn;
    }

}
