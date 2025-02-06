import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player){
        players.add(player);
    }public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }public Player getWinner() {
        Player winner = null;
        for (Player fucker : players) {
            if(winner==null){
                winner=fucker;
            }else{
                if(fucker.getScore()> winner.getScore()){
                    winner=fucker;
                } else if (fucker.getScore()== winner.getScore()&&fucker.getSteps()< winner.getSteps()) {
                    winner=fucker;
                }
            }
        }return winner;

    }
}



