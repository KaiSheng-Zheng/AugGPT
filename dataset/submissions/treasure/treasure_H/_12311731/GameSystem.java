import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerList = new ArrayList<>();
    public void addPlayer(Player player){
        playerList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }

   public Player getWinner(){
        int max = playerList.get(0).getScore();
        Player winner = playerList.get(0);
        for (int i = 0; i < playerList.size(); i++) {
           if(playerList.get(i).getScore() > max ){
               max = playerList.get(i).getScore();
               winner = playerList.get(i);
           }
        }
       for (int i = 0; i < playerList.size(); i++) {
           if(playerList.get(i).getScore() == max && playerList.get(i).getSteps() < winner.getSteps()){
               max = playerList.get(i).getScore();
               winner = playerList.get(i);
           }
       }
        return winner;
    }
}