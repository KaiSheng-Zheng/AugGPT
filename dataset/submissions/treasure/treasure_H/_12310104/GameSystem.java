import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> Players = new ArrayList<>();

    public void addPlayer(Player player){
        Players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows, columns, treasures);
        return map;
    }
    
    public Player getWinner(){
        Player winner = Players.get(0);
        int score_tmp = winner.getScore();
        for (int index = 0; index < Players.size(); index++) {
            int score = Players.get(index).getScore();
            if(score>score_tmp){
                score_tmp = score;
                winner = Players.get(index);
            }
            if(score==score_tmp){
                if(Players.get(index).getSteps()<winner.getSteps()) winner = Players.get(index);
            }
        }
        return winner;
    }
}
