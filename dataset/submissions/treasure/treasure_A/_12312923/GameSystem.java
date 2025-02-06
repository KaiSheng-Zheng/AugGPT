import java.util.ArrayList;

public class GameSystem
{
    Map map;
    ArrayList<Player> players=new ArrayList<>();

    public void addPlayer(Player player)
    {
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures)
    {
        this.map=new Map(rows,columns,treasures);
        return this.map;
    }
    public Player getWinner()
    {
        int maxscore=0;
        int winnersteps=0;
        Player winner = null;
        for(Player a:players)
        {
            if(a.getScore()>maxscore)
            {
                maxscore=a.getScore();
                winner=a;
                winnersteps=a.getSteps();
            }
            else if(a.getScore()==maxscore&&a.getSteps()<winnersteps)
            {
                winner=a;
                winnersteps=a.getSteps();
            }
        }
        return winner;
    }
}
