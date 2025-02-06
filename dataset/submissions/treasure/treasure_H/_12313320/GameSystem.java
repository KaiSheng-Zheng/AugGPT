import java.util.ArrayList;

public class GameSystem {
    int playernums=0;
    ArrayList<Player> list=new ArrayList<>();
    public void addPlayer(Player player){
        playernums++;
        list.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        Map current=new Map(rows,columns,treasures);
        Player.players=0;
        return current;
    }
    public Player getWinner(){
        int highestscore=-1,num=0,higheststeps=0;
        for(int i=0;i<playernums;i++){
            Player temp=list.get(i);
            if(temp.getScore()>highestscore)
            {
                highestscore=temp.getScore();
                higheststeps=temp.getSteps();
                num=i;
            }
            else if(temp.getScore()==highestscore)
            {
                if(temp.getSteps()<higheststeps)
                {
                    highestscore=temp.getScore();
                    higheststeps=temp.getSteps();
                    num=i;
                }
            }
        }
        return list.get(num);
    }
}
