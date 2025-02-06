import java.util.ArrayList;

public class GameSystem {
    public ArrayList<Player> players=new ArrayList<>();
    Map map;

    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Player.num=0;
        return this.map=new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int k=0;
        for (int i = 1; i < players.size(); i++) {
            if(players.get(i).getScore()==players.get(k).getScore()){
                if(players.get(i).getSteps()<players.get(k).getSteps()){
                    k=i;
                }
            }if(players.get(i).getScore()>players.get(k).getScore()){
                k=i;
            }
        }
        return players.get(k);
    }
}
