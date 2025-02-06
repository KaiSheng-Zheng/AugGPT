import java.util.ArrayList;
import java.util.List;
public class GameSystem{
    List<Player> PlayerList = new ArrayList<>();

    public void addPlayer(Player player){
        PlayerList.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }

    public Player getWinner(){
        List<Player> winnerList = new ArrayList<>();
        Player winner = PlayerList.get(0);
        for (int i = 1;i < PlayerList.size();i++){
            if (winner.getScore() < PlayerList.get(i).getScore()){
                winner = PlayerList.get(i);
            }
        }
        int count = 0;
        for (int i = 0;i < PlayerList.size();i++){
            if (winner.getScore() == PlayerList.get(i).getScore()){
                winnerList.add(PlayerList.get(i));
                count++;
            }
        }
        if (count > 1){
            for (Player p : winnerList){
                if (winner.getSteps() > p.getSteps()){
                    winner = p;
                }
            }
        }
        return winner;
    }
}