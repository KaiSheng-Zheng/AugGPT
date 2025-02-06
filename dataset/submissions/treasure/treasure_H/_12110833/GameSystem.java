import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>(); //ArrayList: list;
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows, columns, treasures);
    }

    public Player getWinner(){
        //Player winner = players.get(0);
        ArrayList<Player> maxScorePlayers = getMaxScorePlayers();
        int leastStep = maxScorePlayers.get(0).getSteps();
        int winnerIndex = 0;
        for(int i = 0; i < maxScorePlayers.size(); ++i){
            if(maxScorePlayers.get(i).getSteps() < leastStep){
                winnerIndex = i;
            }
        }
        return maxScorePlayers.get(winnerIndex);
    }


    private ArrayList<Player> getMaxScorePlayers(){ //getMaxScorePlayers method;
        int maxScore = 0;
        for(Player p: players){
            if(p.getScore() > maxScore){
                maxScore = p.getScore();
            }
        }

        ArrayList<Player> maxScorePlayers = new ArrayList<>();

        for(Player p: players){
            if(p.getScore() == maxScore){
                maxScorePlayers.add(p);
            }
        }
        return maxScorePlayers;
    }
}
