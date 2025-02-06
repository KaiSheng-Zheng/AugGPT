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
        Player winner=players.get(0);
        for(int i=1;i<n;i++){
            if(players.get(i).getScore()>players.get(i-1).getScore()){
                winner=players.get(i);
            }else if(players.get(i).getScore()==players.get(i-1).getScore()){
                if(players.get(i).getSteps()<players.get(i-1).getSteps()){
                    winner=players.get(i);
                }
            }
        }
        return winner;
    }

}
