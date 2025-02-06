import java.util.ArrayList;

public class GameSystem{
    public ArrayList<Player> playerArrayList=new ArrayList<>();
    public void addPlayer(Player player){
        playerArrayList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int max=0,num=0;
        for (int i = 0; i < playerArrayList.size(); i++) {
            if(playerArrayList.get(i).getScore()>max){
                max=playerArrayList.get(i).getScore();
                num=i;
            } else if (playerArrayList.get(i).getScore()==max&&playerArrayList.get(i).getSteps()<playerArrayList.get(num).getSteps()) {
                max=playerArrayList.get(i).getScore();
                num=i;
            }
        }
        return playerArrayList.get(num);
    }

}