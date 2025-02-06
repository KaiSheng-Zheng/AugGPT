import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> list=new ArrayList<>();
    public void addPlayer(Player player){
        list.add(player);
    }
    public Map newGame(int rows,int columns,Treasure...treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        ArrayList<Player> winners=new ArrayList<>();
        Player temp=null;
        for (int i = 0; i < list.size()-1; i++) {
           temp=list.get(i).getScore()>list.get(i+1).getScore()?list.get(i):list.get(i+1);
        } for (int i = 0; i < list.size(); i++) {
            if (temp.getScore()==list.get(i).getScore()){
                winners.add(list.get(i));
            }
        }
        if (winners.size()==1){
            return winners.get(0);
        }else {
            int tempi=0;
            for (int i = 0; i < winners.size()-1; i++) {
                tempi=winners.get(i).getSteps()<winners.get(i+1).getSteps()?i:i+1;
            }return winners.get(tempi);
        }
    }
}
