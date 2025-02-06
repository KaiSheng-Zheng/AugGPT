import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;
    public GameSystem(){
        this.players = new ArrayList<>();
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows, columns, treasures);
        return map;
    }
    public Player getWinner(){
        Player winner = players.get(0);
        for(int i = 0; i<players.size();i++){
            Player player = players.get(i);
            if (player.getScore() > winner.getScore() || player.getScore() == winner.getScore() && player.getSteps() < winner.getSteps()){
                winner = player;
            }
        }
        return winner;
    }


}
