import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<Player>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows , columns , treasures);
        for (int i = 1; i < players.size(); i++){
            players.get(i).setScore(0);
            players.get(i).setMap(map);

        }
        return map;
    }
    public Player getWinner(){
        Player winner = players.get(0);
        for (int i = 1; i < players.size(); i++){
            if (players.get(i).getScore() > winner.getScore()){
                winner = players.get(i);
            }
            else if (players.get(i).getScore() == winner.getScore() && players.get(i).getSteps() < winner.getSteps()){
                //test
                winner = players.get(i);
            }
        }
        return winner;

    }
}
