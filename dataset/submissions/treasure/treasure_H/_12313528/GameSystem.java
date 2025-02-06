import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> playerlist=new ArrayList<>();
    public void addPlayer(Player player){
        playerlist.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        Map a=new Map (rows, columns, treasures);
        return a;
    }
    public Player getWinner(){
        for (int i = 0; i < playerlist.size(); i++) {
            for (int j = i+1; j < playerlist.size(); j++) {
                if (playerlist.get(i).getScore()-playerlist.get(j).getScore()>0){
                    Player a=playerlist.get(i);
                    Player b=playerlist.get(j);
                    playerlist.set(i,b);
                    playerlist.set(j,a);
                }
            }

        }
        for (int i = 0; i < playerlist.size(); i++) {
            for (int j = i+1; j < playerlist.size(); j++) {
                if (playerlist.get(i).getScore()-playerlist.get(j).getScore()==0){
                    if (playerlist.get(i).getSteps()<playerlist.get(j).getSteps()) {
                        Player a = playerlist.get(i);
                        Player b = playerlist.get(j);
                        playerlist.set(i, b);
                        playerlist.set(j, a);
                    }
                }
            }

        }
        return playerlist.get(playerlist.size()-1);
    }

}
