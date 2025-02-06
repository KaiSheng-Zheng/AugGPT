import java.util.ArrayList;
public class GameSystem {
    ArrayList<Player> players=new ArrayList<>();
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
        Player max=players.get(0);
        for(Player i:players)
        {
            if(i.getScore()>max.getScore())
            {
                max=i;
            }
            if(i.getScore()==max.getScore())
            {
                if(i.getSteps()<max.getSteps())
                    max=i;
            }
        }
        return max;
    }
}
