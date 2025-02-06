import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player>players;

    public GameSystem(){
        players=new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        int n= players.size();
        int p=0;
        for(int i=1;i<n;i++){
            if(players.get(i).getScore()>players.get(p).getScore()){
                p=i;
            }else if(players.get(i).getScore()==players.get(p).getScore()){
                if(players.get(i).getSteps()<players.get(p).getSteps()){
                    p=i;
                }
            }
        }
        return players.get(p);
    }

}
