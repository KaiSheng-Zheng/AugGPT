import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players =  new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }

    public Player getWinner(){
        int maxScore = 0;
        int minStep = 0;
        int winnerIndex = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() > maxScore){
                maxScore = players.get(i).getScore();
                winnerIndex = i;
                minStep = players.get(i).getSteps();
            }
            else if (players.get(i).getScore() == maxScore){
                if (players.get(i).getSteps() < minStep){winnerIndex = i;}
            }
        }
        return players.get(winnerIndex);
    }
}