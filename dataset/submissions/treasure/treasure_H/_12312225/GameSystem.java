import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerArrayList=new ArrayList<>();
    public void addPlayer(Player player)
    {
        this.playerArrayList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures)
    {
        return new Map(rows,columns,treasures);
    }
    public Player getWinner()
    {
        Player winner=playerArrayList.get(0);
        for(Player i:playerArrayList)
        {
            if(winner.getScore()<i.getScore())
            {
                winner=i;
            }
            else if(winner.getScore()==i.getScore()
            &&winner.getSteps()>i.getSteps())
            {
                winner=i;
            }
        }
        return winner;
    }
}