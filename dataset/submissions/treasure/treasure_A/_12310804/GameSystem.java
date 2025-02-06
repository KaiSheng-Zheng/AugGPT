import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GameSystem
{
    ArrayList<Player>players;
    GameSystem()
    {
        players=new ArrayList<Player>();
    }
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures)
    {
        return new Map(rows,columns,treasures);
    }
    public Player getWinner()
    {
        Collections.sort(players, new Comparator<Player>()
        {
            @Override
            public int compare(Player o1, Player o2)
            {
                return o1.getScore()==o2.getScore()?o1.getSteps()-o2.getSteps():o2.getScore()-o1.getScore();
            }
        });
        return players.get(0);
    }
}
