

import java.util.ArrayList;

public class GameSystem {
    public Player getPlayer() {
        return player;
    }
    public  ArrayList<Player> list = new ArrayList<>();

    private Player player;

    private  ArrayList<Player> getList() {
        return list;
    }

    public GameSystem(){

    }
    public void addPlayer(Player player){
        list.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int max1 = list.get(0).getScore();
        int max2 = list.get(0).getSteps();
        int s = 0;
        for (int i = 0;i<list.size();i++){
            if (list.get(i).getScore()>max1){
                max1 = list.get(i).getScore();
                max2 = list.get(i).getSteps();
                 s = i;
            }
            if (list.get(i).getScore()==max1&&list.get(i).getSteps()<max2){
                s = i;
                max2 = list.get(i).getSteps();

            }
        }
        return list.get(s);
    }
}
