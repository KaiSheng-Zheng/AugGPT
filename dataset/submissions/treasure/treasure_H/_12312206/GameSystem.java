import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> play=new ArrayList<Player>();
    public void addPlayer(Player player){
        play.add(player);
    }
    public Map newGame(int row, int column, Treasure[]treasure){
        Map m=new Map( row, column, treasure);
        return m;
    }
    public Player getWinner(){
        for (int i = 1; i < play.size() ; i++) {
            Player   ptem=play.get(i);
            int j=i;
            while(j>0 && ptem.getScore()<play.get(j-1).getScore()){
                play.set(j,play.get(j-1));
                j--;
            }
            while (j>0 && ptem.getScore()==play.get(j-1).getScore()){
                if(play.get(i).getSteps()>play.get(j-1).getSteps()){
                    play.set(j,play.get(j-1));
                    j--;
                }
                else{
                    break;
                }
            }
            if(j!=i){
                play.set(j,ptem);
            }
        }
        return play.get(play.size()-1);
    }
}