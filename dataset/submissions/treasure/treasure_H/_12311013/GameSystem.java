
import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players=new ArrayList<>();

    public void addPlayer(Player player){players.add(player);}
    public Map newGame(int rows, int columns, Treasure[] treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player sw;
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size()-1; j++) {
                if(players.get(j).getScore()<players.get(j+1).getScore()){
                sw= players.get(j);
                players.set(j,players.get(j+1));
                players.set(j+1,sw);
                }
            }
        }
        int t=0;
        while(players.get(t).getScore()==players.get(t+1).getScore()){
            if(t<players.size()-2){
            t++;}
        }
        for (int i = 0; i < t+1; i++) {
            for (int j = 0; j < t; j++) {
                if(players.get(j).getSteps()>players.get(j+1).getSteps()){
                    sw= players.get(j);
                    players.set(j,players.get(j+1));
                    players.set(j+1,sw);
                }
            }
        }
        return players.get(0);
    }
}
