import java.util.ArrayList;

public class GameSystem
{
    ArrayList<Player> players=new ArrayList<Player>();
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
        int minStep=2147483647,maxScore=-1;
        Player winner=players.get(0);
        for(Player player:players)
        {
            if(player.getScore()>maxScore)
            {
                maxScore=player.getScore();
                minStep=player.getSteps();
                winner=player;
            }
            else if(player.getScore()==maxScore&&player.getSteps()<minStep)
            {
                minStep=player.getSteps();
                winner=player;
            }
        }
        return winner;
    }
}
