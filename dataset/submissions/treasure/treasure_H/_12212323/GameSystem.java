import java.util.ArrayList;
import java.util.List;
public class GameSystem {
    private List<Player> players=new ArrayList<Player>() {
    };
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures) {
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int index=0;
        int max=players.get(0).getScore();
        int stepIndex=players.get(0).getSteps();
        for (int i = 1; i < players.size(); i++) {
            if(max<players.get(i).getScore()){
                max=players.get(i).getScore();
                stepIndex=players.get(i).getSteps();
                index=i;
            }else if(max==players.get(i).getScore()){
                if(stepIndex>players.get(i).getSteps()){
                    max=players.get(i).getScore();
                    stepIndex=players.get(i).getSteps();
                    index=i;
                }
            }
        }
        return players.get(index);
    }
}