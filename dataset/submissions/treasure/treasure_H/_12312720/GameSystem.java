//package A4_2;

import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> p=new ArrayList<Player>();
    public void addPlayer(Player player)
    {
        p.add(player);
        return;
    }
    public Map newGame(int rows, int columns, Treasure... treasures)
    {
//        Treasure[] trea=new Treasure[100005];
//        int cur=0;
//        for(Treasure i:treasures)
//        {
//            trea[++cur]=i;
//        }
        return new Map(rows,columns,treasures);
    }

    public Player getWinner()
    {
        int mas=0,mis=2147483647,wid=0;
        for(int i=0;i<p.size();i++)
        {
            if(p.get(i).getScore()>mas)
            {
                mas=p.get(i).getScore();
                mis=p.get(i).getSteps();
                wid=i;
                continue;
            }
            if(p.get(i).getScore()==mas&&p.get(i).getSteps()<mis)
            {
                mis=p.get(i).getSteps();
                wid=i;
                continue;
            }
        }
        return p.get(wid);
    }
}
