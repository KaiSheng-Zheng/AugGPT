import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Map map;
    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows,int columns, Treasure[] treasures){
        map = new Map(rows, columns, treasures);
        return map;
    }
    public Player getWinner(){
        Player temp = players.get(0);
        ArrayList<Player> winners = new ArrayList<Player>();
        int maxScore = players.get(0).getScore();
        for (int i = 1; i < players.size(); i++) {
            if (maxScore < players.get(i).getScore()){
                maxScore  = players.get(i).getScore();
                temp = players.get(i);
            }
        }
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore()== temp.getScore()){
                winners.add(players.get(i));
            }
        }
        int minSteps = winners.get(0).getSteps();
        for (int i = 1; i < winners.size(); i++) {
            if (minSteps > players.get(i).getSteps()){
                minSteps  = players.get(i).getSteps();
                temp = players.get(i);
            }
        }
        return temp;
    }

}
