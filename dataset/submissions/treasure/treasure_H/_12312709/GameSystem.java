import java.util.ArrayList;

public class GameSystem {
    public ArrayList<Player> playerList=new ArrayList<>();
    public void addPlayer(Player player){
        this.playerList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player winner=playerList.get(0);
        for(Player pl : playerList){
            if(pl.getScore()>winner.getScore()){
                winner=pl;
            } else if (pl.getScore()==winner.getScore()) {
                if(pl.getSteps()<winner.getSteps()){
                    winner=pl;
                }
            }
        }
        return winner;
    }
}
