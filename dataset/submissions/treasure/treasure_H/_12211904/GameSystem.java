import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Map map;
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        this.map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        Player winner=players.get(0);
        for (int i=1;i<players.size();i++){
            if(winner.getScore()<players.get(i).getScore()){
                winner=players.get(1);
            } else if (winner.getScore()==players.get(i).getScore()) {
                if(winner.getSteps()>players.get(i).getSteps()){
                    winner=players.get(i);
                }
            }
        }
        return winner;
    }
}
