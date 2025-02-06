import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameSystem {
    private List<Player> players=new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map=new Map(rows,columns, treasures);
        return map;
    }
    public Player getWinner(){
        List<Player> winners=getPlayers();
        List<Player> winner=new ArrayList<>();
        int max=0;
        int min=0;
        for(Player i:players){
            if(max<=i.getScore())
            max=i.getScore();
        }
        System.out.println(max);
        int num=0;
        for(int i=0;i<players.size();i++){
            if(max==players.get(i).getScore()){
                winner.add(players.get(i));
                num++;
                min=players.get(i).getSteps();
            }
        }
        for(Player i:winner){
            if(i.getSteps()<=min){
                min=i.getSteps();
            }
        }
        for(Player i:winner){
            if(min==i.getSteps()){
                return i;
            }
        }
        return winners.get(0);
    }




}
