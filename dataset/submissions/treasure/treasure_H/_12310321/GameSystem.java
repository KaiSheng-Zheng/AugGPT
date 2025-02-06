import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows , int columns , Treasure... treasures){
        return new Map(rows , columns , treasures);
    }

    public Player getWinner(){
        for (int i = 0 ; i < players.size() ; i++){
            for (int j = 0 ; j < players.size() - 1 ; j++){
                if (players.get(j).getScore() < players.get(j+1).getScore()){
                    Player player = players.get(j);
                    players.set(j , players.get(j+1));
                    players.set(j+1 , player);
                }
            }
        }
        for (int i = 0 ; i < players.size() ; i++){
            for (int j = 0 ; j < players.size() - 1 ; j++){
                if (players.get(j).getScore() == players.get(j+1).getScore()){
                    if (players.get(j).getTotalSteps() > players.get(j+1).getTotalSteps()) {
                        Player player = players.get(j);
                        players.set(j, players.get(j + 1));
                        players.set(j + 1, player);
                    }
                }
            }
        }
        return players.get(0);
    }

}
