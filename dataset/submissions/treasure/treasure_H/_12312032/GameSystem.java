import java.util.ArrayList;

public class GameSystem
{
    private ArrayList<Player> players;
    public GameSystem()
    {
        this.players = new ArrayList<>();
    }
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures)
    {
        return new Map(rows, columns, treasures);
    }
    public Player getWinner()
    {
        Player WIENER = players.get(0);
        for(int x=1; x<players.size()+1; x++)
        {
            if(WIENER.getScore()<players.get(x).getScore())
            {
                WIENER = players.get(x);
            }
            else if(WIENER.getScore()==players.get(x).getScore())
            {
                if(players.get(x).getSteps()<WIENER.getSteps())
                {
                    WIENER = players.get(x);
                }
            }
        }
        return WIENER;
    }
}
