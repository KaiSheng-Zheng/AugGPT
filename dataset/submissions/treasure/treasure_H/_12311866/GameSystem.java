
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GameSystem {
    private List<Player> players = new ArrayList<>();
//    public PriorityQueue<Player> players0 = new PriorityQueue<>();

    public void addPlayer(Player player){
        this.players.add(player);
//        this.players0.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }

    public Player getWinner(){
        int winnerindex = 0;
        int winnerscore = 0;
        int winnersteps = 0;
//        int [] scores = new int[players.size()];
//        int [] finalsteps = new int[players.size()];
//        for (int i = 0; i < players.size(); i++) {
//            scores[i] = players.get(i).getScore();
//            finalsteps[i] = players.get(i).getSteps();
//        }
        for (int i = 0; i <players.size()-1; i++) {
            if (players.get(i).getScore()>winnerscore){
                winnerindex = i;
                winnersteps = players.get(i).getSteps();
                winnerscore = players.get(i).getScore();
            } else if (players.get(i).getScore()==winnerscore) {
                if(players.get(i).getSteps()<winnersteps){
                    winnerindex = i;
                    winnersteps = players.get(i).getSteps();
                    winnerscore = players.get(i).getScore();
                }
            }
        }
        return players.get(winnerindex);
    }

}