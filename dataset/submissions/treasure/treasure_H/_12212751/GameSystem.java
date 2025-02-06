import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players=new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        for(int i=0;i<players.size();i++){
            for(int i2=i+1;i2<players.size();i2++){
                if(players.get(i).getScore()< players.get(i2).getScore()){
                    int midscore=players.get(i).getScore();
                    int midstep=players.get(i).getSteps();
                    players.get(i).setScore(players.get(i2).getScore());
                    players.get(i).setSteps(players.get(i2).getSteps());
                    players.get(i2).setScore(midscore);
                    players.get(i2).setSteps(midstep);
                }
                else if(players.get(i).getScore()== players.get(i2).getScore()){
                    if(players.get(i).getSteps()> players.get(i2).getSteps()){
                        int midscore=players.get(i).getScore();
                        int midstep=players.get(i).getSteps();
                        players.get(i).setScore(players.get(i2).getScore());
                        players.get(i).setSteps(players.get(i2).getSteps());
                        players.get(i2).setScore(midscore);
                        players.get(i2).setSteps(midstep);
                    }
                }
            }
        }
        return players.get(0);
    }
}
