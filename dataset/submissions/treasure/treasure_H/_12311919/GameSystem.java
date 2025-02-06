import java.util.ArrayList;

public class GameSystem {
    ArrayList Player=new ArrayList<Player>();
    public void addPlayer(Player player){
        player.resetScore();
        player.resetsteps();
        Player.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
       Player[] P=new Player[Player.size()];
        for (int i = 0; i <Player.size() ; i++) {
            P[i]=(Player)Player.get(i);
        }
        Player winner;int e=0;
        for (int i = 0; i <P.length ; i++) {
            if(P[e].getScore()<P[i].getScore())e=i;
            if(P[e].getScore()==P[i].getScore()){
                if(P[e].getSteps()>P[i].getSteps())e=i;
            }
        }
        //if(e==3)e=1;
        winner=P[e];
        return winner;
    }
}
