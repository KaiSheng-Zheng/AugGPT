import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows,int columns,Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player winner = null;
        for (int i = 0; i < players.size(); i++) {
            if (winner==null){
                winner = players.get(i);
                continue;
            }
            if (players.get(i).getScore()>winner.getScore()){
                winner=players.get(i);
            } else if (players.get(i).getScore() == winner.getScore()) {
                if (players.get(i).getSteps()< winner.getSteps()){
                    winner=players.get(i);
                }
            }
        }
        return winner;
    }
}
