import java.util.ArrayList;
public class GameSystem {
    private final ArrayList<Player> players = new ArrayList<Player>();
    private Map map;
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures){
        this.map = new Map(rows, columns, treasures);
        return map;
    }
    public Player getWinner(){
        Player winner = players.get(0);
        int maxindex = 0;
        for(int i = 0; i < players.size() - 1; i++){
            if(players.get(maxindex).getScore() < players.get(i + 1).getScore()){
                maxindex = i + 1;
            }
            else if(players.get(maxindex).getScore() == players.get(i + 1).getScore() && players.get(maxindex).getSteps() > players.get(i + 1).getSteps()){
                maxindex = i+ 1;
            }
        }
        winner = players.get(maxindex);
        return winner;
    }
}