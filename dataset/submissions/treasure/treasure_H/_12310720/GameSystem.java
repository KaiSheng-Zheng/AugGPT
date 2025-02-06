import java.util.ArrayList;

public class GameSystem {
        ArrayList<Player> PLAYERS = new ArrayList<>();

    public void addPlayer(Player player){
        PLAYERS.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int ssssp = 0;
        int pppps=10000;
        Player best = null;
        for (int i = 0; i <PLAYERS.size() ; i++) {
            if (PLAYERS.get(i).getScore()>ssssp)
            {
                ssssp=PLAYERS.get(i).getScore();
                pppps=PLAYERS.get(i).getSteps();
                best = PLAYERS.get(i);
            } else if (PLAYERS.get(i).getScore()==ssssp&&PLAYERS.get(i).getSteps()<pppps) {
                ssssp=PLAYERS.get(i).getScore();
                pppps=PLAYERS.get(i).getSteps();
                best = PLAYERS.get(i);
            }
        }
        return best;
    }










}