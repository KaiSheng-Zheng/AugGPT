import java.util.ArrayList;
import java.util.Collections;

public class GameSystem {
    private Map map;
    private ArrayList<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        map = new Map(rows,columns,treasures);
        return map;
    }

    public Player getWinner(){
        for (int i = players.size()-1; i >= 1; i--) {
            for (int j = players.size()-1; j >= 1; j--) {
                if (players.get(j).getScore() > players.get(j-1).getScore()){
                    Collections.swap(players,j,j-1);
                }
                else if (players.get(j).getScore()==players.get(j-1).getScore()){
                    if (players.get(j).getSteps()< players.get(j-1).getSteps()){
                        Collections.swap(players,j,j-1);
                    }
                }
            }
        }
        return players.get(0);
    };
}
