import java.util.*;
public class GameSystem
{
    ArrayList<Player> playerlist=new ArrayList<>();
    public void addPlayer(Player player)
    {
        playerlist.add(player);
    }
    public Map newGame(int rows,int columns,Treasure[] treasures)
    {
        return new Map(rows,columns,treasures);
    }
    public Player getWinner()
    {
        int l=playerlist.size();
        int maxscore=0,pos=0,minsteps=9999999;
        for(int i=0;i<l;i++)
        {
            if(playerlist.get(i).getScore()>maxscore)
            {
                maxscore=playerlist.get(i).getScore();
                pos=i;
                minsteps=playerlist.get(i).getSteps();
            }
            else if(playerlist.get(i).getScore()==maxscore)
                if(playerlist.get(i).getSteps() < minsteps)
                {
                    pos=i;
                    minsteps=playerlist.get(i).getSteps();
                }
        }
        return playerlist.get(pos);
    }
}
