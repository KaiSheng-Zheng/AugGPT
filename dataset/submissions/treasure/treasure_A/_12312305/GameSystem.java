

import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> p = new ArrayList<>();
    private int n = -1;

    public void addPlayer(Player player) {
        n++;
       p.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }
    public Player getWinner(){
        Player max = p.get(0);
        for(int i = 0;i<p.size()-1;i++){
            if(p.get(i).getScore()>max.getSteps()){
                max = p.get(i);
            }else if(p.get(i).getScore()==max.getScore()){
                if(p.get(i).getSteps()< p.get(i + 1).getSteps()){
                    max = p.get(i);
                }else{max = p.get(i + 1);}
            }
        }
        return max;
    }
}
