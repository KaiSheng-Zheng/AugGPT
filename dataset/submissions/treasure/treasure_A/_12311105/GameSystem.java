import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player>players=new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int num=0;
        for(int i=1;i<players.size();i++){
            if(players.get(i).getScore()>players.get(num).getScore()){
                num=i;
            }else if(players.get(i).getScore()==players.get(num).getScore()){
                if(players.get(i).getSteps()<players.get(num).getSteps()){
                    num=i;
                }
            }
        }return players.get(num);
    }
}