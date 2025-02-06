import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class GameSystem {

    public Player[] lis=new Player[10010];
    int tmp=0;
    public void addPlayer(Player player){
        lis[tmp]=player;
        tmp+=1;
    }
    public Map newGame(int row, int column, Treasure[] treasures){
        Map ma=new Map(row,column,treasures);
        return ma;
    }
    public Player getWinner(){
        int ma=-1;int mai=-1;
        for(int i=0;i<tmp;i++){
            if(lis[i].getScore()>ma){
                ma=lis[i].getScore();mai=i;
            }

        }
        for(int i=0;i<tmp;i++){
            //if(ma>=lis[i].getScore()){
            if(ma == lis[i].getScore()) {
                if(lis[mai].getSteps()>lis[i].getSteps()){
                    mai=i;
                }
            }
        }
        return lis[mai];
    }

}
