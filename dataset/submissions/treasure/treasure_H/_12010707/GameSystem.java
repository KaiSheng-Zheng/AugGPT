import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players=new ArrayList<>();
    Map map;


    public void addPlayer(Player player){
        players.add(player);
        player.setMap(map);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
       this.map=new Map(rows,columns,treasures);
       return this.map;
    }
    public Player getWinner(){
        Player winner=players.get(0);
        for(int i=1;i<players.size();i++){
            if(winner.getScore()<players.get(i).getScore()){
                winner=players.get(i);
            } else if (winner.getScore()==players.get(i).getScore()) {
                if(winner.getMaxsteps()>players.get(i).getMaxsteps()){
                    winner=players.get(i);
                }
            }
        }
        return winner;
    }
}
