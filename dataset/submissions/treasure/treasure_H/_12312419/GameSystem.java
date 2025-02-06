import java.util.ArrayList;

public class GameSystem {
    private static ArrayList<Player> playerlist=new ArrayList<Player>();
    public void addPlayer(Player player){
        playerlist.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map=new Map(rows,columns,treasures);
        playerlist.clear();
        return map;
    }
    public Player getWinner(){
        int[] check=new int[playerlist.size()];
        for (int i=0;i<playerlist.size();i++){
            check[i]=0;
        }
        Player winner =playerlist.get(0);
        for (int i=0;i<playerlist.size();i++){
            if (winner.getScore()<playerlist.get(i).getScore()){
                winner=playerlist.get(i);
            }
            else if (winner.getScore()==playerlist.get(i).getScore()) {
                if (winner.getSteps()>playerlist.get(i).getSteps()){
                    winner=playerlist.get(i);
                }
            }
        }
        return winner;
        }

    public static ArrayList<Player> getPlayerlist() {
        return playerlist;
    }
}

