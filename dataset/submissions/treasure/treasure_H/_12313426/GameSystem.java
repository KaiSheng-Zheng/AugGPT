import java.util.ArrayList;

public class GameSystem
{
    private int capacity;
    private ArrayList<Player>players;
    public GameSystem()
    {
        players=new ArrayList<>();
    }
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    public Map newGame(int rows,int columns,Treasure[] treasures)
    {
        return new Map(rows,columns,treasures);
    }
    public Player getWinner()
    {
        Player winner=players.get(0);
        for(int i=1;i<players.size();i++)
        {
            if(winner.getScore()<players.get(i).getScore())
            {
                winner=players.get(i);
            }
            else if(winner.getScore()==players.get(i).getScore()&&winner.getSteps()>=players.get(i).getSteps())
            {
                winner=players.get(i);
            }
        }
        return winner;
    }
}
