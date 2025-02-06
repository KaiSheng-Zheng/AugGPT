import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players=new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner()
    {
        int MAX_Score=0;
        int id=0;
        int MIN_Steps=0;
        for(int i=0;i<players.size();i++){
            if(players.get(i).getScore()>MAX_Score||(players.get(i).getScore()==MAX_Score&&players.get(i).getSteps()<MIN_Steps)){
                MAX_Score=players.get(i).getScore();
                MIN_Steps=players.get(i).getSteps();
                id=i;
            }
        }
        return players.get(id);
    }
}
