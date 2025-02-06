import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        this.players =new ArrayList<>();
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int temp = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore()>players.get(temp).getScore()||players.get(i).getScore()==players.get(temp).getScore()&&players.get(i).getSteps()<players.get(temp).getSteps()) {
                temp = i;
            }
        }
            return players.get(temp);
    }
}
