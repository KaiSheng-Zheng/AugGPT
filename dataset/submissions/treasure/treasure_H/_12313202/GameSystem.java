import java.util.ArrayList;

public class GameSystem {
    private ArrayList <Player> players;

    public GameSystem(){
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows, columns, treasures);
    }

    public Player getWinner(){
        Player cur = players.get(0);
        for(Player x : players){
            if(x.getScore() > cur.getScore()) cur = x;
            else if(x.getScore() == cur.getScore() && x.getSteps() < cur.getSteps()) cur = x;
        }
        return cur;
    }
}
