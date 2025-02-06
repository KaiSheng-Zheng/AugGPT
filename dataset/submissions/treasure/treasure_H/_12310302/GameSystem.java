import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> playeee=new ArrayList<>();
    private Map map;
    public void addPlayer(Player player){
        playeee.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        int sum=playeee.get(0).getScore();int k=0;
        for(int i=1;i<playeee.size();i++){
            if(playeee.get(i).getScore()>sum){
                sum=playeee.get(i).getScore();k=i;
            }
            else {
                if(playeee.get(i).getScore()==sum){
                    if(playeee.get(i).getSteps()<playeee.get(k).getSteps()){
                        k=i;
                    }
                }
            }
        }
        return playeee.get(k);
    }
}
