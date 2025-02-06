import java.util.ArrayList;

public class GameSystem {
    private final ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows,int columns,Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int scoreMax=players.get(0).getScore(),stepMin=players.get(0).getStepsUsed();
        Player winner=players.get(0);
        for (Player player:players) if (player.getScore() >= scoreMax){
            if (player.getScore()>scoreMax){
                winner = player;
                stepMin = player.getStepsUsed();
            }
            else if (player.getStepsUsed() <= stepMin) winner = player;
        }
        return winner;
    }
}
