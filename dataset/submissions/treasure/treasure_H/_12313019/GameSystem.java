
import java.util.ArrayList;

public class GameSystem
{
    static ArrayList<Player> playerList = new ArrayList<>();

    static Map mapNow;
    public void addPlayer(Player player)
    {
        playerList.add(player);
    }
    public Map newGame(int rows,int columns,Treasure... treasures)
    {
        Treasure.cnt=treasures.length;
        Player.count=0;
        playerList=new ArrayList<>();
        return mapNow= new Map(rows,columns,treasures);
    }

    public Player getWinner()
    {
        Player winner =playerList.get(0);
        for(Player p:playerList)
        {
            if (p.getScore()>winner.getScore())
            {
                winner=p;
            }
            else if(p.getScore()==winner.getScore())
            {
                if(p.getSteps()<winner.getSteps())
                    winner=p;
            }
        }
        return winner;
    }
}
