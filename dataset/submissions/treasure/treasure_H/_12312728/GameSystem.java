import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players=new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows,int columns,Treasure[] treasures){
        return new Map(rows, columns, treasures);
    }
    public Player getWinner(){
        int index=0,score=0,steps=players.get(0).getSteps();
        for (int i=0;i<players.size();i++){
            if (players.get(i).getScore()==score&&players.get(i).getSteps()<steps){
                steps=players.get(i).getSteps();
                index=i;
            }
            if (players.get(i).getScore()>score){
                score=players.get(i).getScore();
                steps=players.get(i).getSteps();
                index=i;
            }
        }
        return players.get(index);
    }
}
