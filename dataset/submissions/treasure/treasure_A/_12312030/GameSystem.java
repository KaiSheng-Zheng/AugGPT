import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>();
    Map map;
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner() {
        int id=0,maxval=players.get(0).getScore(),minstep=players.get(0).getSteps();
        for(int i=1;i<players.size();i++) {
            if(players.get(i).getScore()>maxval) {
                id=i;
                maxval=players.get(i).getScore();
                minstep=players.get(i).getSteps();
            }else if(players.get(i).getScore()==maxval&&players.get(i).getSteps()<minstep){
                id=i;
                minstep=players.get(i).getSteps();
            }
            //System.out.println(id);
        }
        return players.get(id);
    }
}
