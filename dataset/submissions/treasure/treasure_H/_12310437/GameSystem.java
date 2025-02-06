import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;

    public GameSystem(){
        players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows, columns, treasures);
    }
    public Player getWinner(){
        Player winPlayer = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if(players.get(i).getScore() > winPlayer.getScore()){
                winPlayer = players.get(i);
            }else if (players.get(i).getScore() == winPlayer.getScore()){
                if(players.get(i).getSteps() < winPlayer.getSteps()){
                    winPlayer = players.get(i);

                }
            }
        }
        return winPlayer;
    }
}
