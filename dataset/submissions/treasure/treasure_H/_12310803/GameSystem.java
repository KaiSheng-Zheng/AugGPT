
import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int winnerIndex = 0;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getScore() >= players.get(winnerIndex).getScore()){
                if(players.get(i).getScore() > players.get(winnerIndex).getScore()){
                    winnerIndex = i;
                }else{
                    if(players.get(i).getSteps() < players.get(winnerIndex).getSteps()){
                        winnerIndex = i;
                    }
                }
            }
        }
        return players.get(winnerIndex);
    }
}

