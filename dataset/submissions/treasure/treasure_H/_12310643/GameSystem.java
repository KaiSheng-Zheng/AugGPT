import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> plays;
    public GameSystem(){
        plays=new ArrayList<>();
    }
    public void addPlayer(Player player){
        plays.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player win=null;
        ArrayList<Player>win1=new ArrayList<>();
        int maxscore=0;
        int minstep;
        for(Player p:plays){
            maxscore=Math.max(maxscore,p.getScore());
        }
        for(Player p:plays){
            if(p.getScore()==maxscore)
                win1.add(p);
        }
        minstep=win1.get(0).getSteps();
        for(Player p:win1){
            minstep=Math.min(minstep,p.getSteps());
        }
        for(Player p:win1){
            if(p.getSteps()==minstep)
                win=p;
        }
        return win;
    }
}
