
import java.util.ArrayList;
public class GameSystem {
    private  ArrayList<Player> playerArrayList=new ArrayList<>();
    public void addPlayer(Player player){
        playerArrayList.add(player);
    }
    public Map newGame(int rows, int columns,Treasure[] treasures){
        Map map=new Map( rows,  columns, treasures);
        return map;
    }
    public Player getWinner(){
        int n=playerArrayList.size();
        for(int i=0;i<n-1;i++){
            for(int h=0;h<n-i-1;h++){
                int a=playerArrayList.get(h).getScore();
                int b=playerArrayList.get(h+1).getScore();
                int c=playerArrayList.get(h).getSteps();
                int d=playerArrayList.get(h+1).getSteps();
                if(a>b||(a==b&&c<d)){
                    Player temp=playerArrayList.get(h);
                    playerArrayList.set(h,playerArrayList.get(h+1));
                    playerArrayList.set(h+1,temp);
                }
            }
        }
        return playerArrayList.get(n-1);
    }
}
