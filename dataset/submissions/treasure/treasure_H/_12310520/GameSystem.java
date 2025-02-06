import java.util.ArrayList;
public class GameSystem {
    ArrayList<Player> playerlist=new ArrayList<>();
    public void addPlayer(Player player){
        playerlist.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map mapnew=new Map(rows,columns,treasures);
        return mapnew;
    }

    public Player getWinner(){
        int jl=0,score=-1,step=100;
        for (int i = 0; i < playerlist.size(); i++) {
            if(playerlist.get(i).getScore()>score|| playerlist.get(i).getScore()==score&&playerlist.get(i).getSteps()<step){
                    jl=i;score=playerlist.get(i).getScore();step=playerlist.get(i).getSteps();
            }
        }
        return playerlist.get(jl);
    }
}
