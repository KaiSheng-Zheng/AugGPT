
import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;
    public GameSystem(){
        players=new ArrayList<>();
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        Player winner = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            Player current = players.get(i);
            if (current.getScore() > winner.getScore()) {
                winner = current;
            } else if (current.getScore() == winner.getScore()) {
                if (current.getSteps() < winner.getSteps()) {
                    winner = current;
                }
            }
        }
        return winner;
    }


}
