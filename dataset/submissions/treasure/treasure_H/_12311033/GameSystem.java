import java.util.ArrayList;
public class GameSystem {
    ArrayList<Player> players;
    public GameSystem(){
        players = new ArrayList<>();
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public Map newGame(int rows, int cols, Treasure... treasures){
        Map gameMap = new Map(rows, cols, treasures);
        return gameMap;
    }
    public Player getWinner(){
        Player res = players.get(0);
        for(Player i: players){
            if((i.getScore() > res.getScore()) || ((i.getScore() == res.getScore()) && (i.getSteps() < res.getSteps()))){
                res = i;
            }
        }
        return res;
    }
}
