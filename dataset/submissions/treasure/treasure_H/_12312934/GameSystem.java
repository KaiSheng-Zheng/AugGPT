import java.util.ArrayList;

public class GameSystem {

    private ArrayList<Player> Players  = new ArrayList<>();
    public Map map = new Map();
    public void addPlayer(Player player){
        Players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        map.set(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        int ans = 0;
        for(int i=1;i<Players.size();++i){
            if(Players.get(i).getScore()>Players.get(ans).getScore()){
                ans = i;
            }else if(Players.get(i).getScore()==Players.get(ans).getScore() && Players.get(i).getSteps()<Players.get(ans).getSteps()){
                ans = i;
            }
        }
        return Players.get(ans);
    }
}
