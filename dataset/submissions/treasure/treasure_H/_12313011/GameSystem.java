import java.util.ArrayList;
import java.util.Comparator;

public class GameSystem {
    private ArrayList<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if(o1.getScore()!=o2.getScore()){
                    return o1.getScore() - o2.getScore();
                }
                else{
                    return o2.getSteps() - o1.getSteps();
                }
            }
        });
        return players.get(players.size()-1);
    }
}
