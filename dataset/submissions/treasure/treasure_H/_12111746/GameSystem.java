import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players = new ArrayList<>();
    public void addPlayer(Player player){
       players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        Player winner = players.get(0);
        for(int i = 1;i < players.size();i++){
            if(players.get(i).getScore() > winner.getScore()){
                winner = players.get(i);
            }else if(players.get(i).getScore() == winner.getScore()){
                if(players.get(i).getSteps() < winner.getSteps()){
                    winner = players.get(i);
                }
            }
        }
        return winner;
    }
}
