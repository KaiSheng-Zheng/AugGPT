import java.util.ArrayList;

public class GameSystem
{
    private ArrayList<Player> players;
    public void addPlayer(Player player)
    {
        Player newplayer = (Player) player;
        players.add(newplayer);
    }
    public Map newGame(int rows,int columns,Treasure... treasures)
    {
        players = new ArrayList<>();
        Treasure[] treasure = new Treasure[treasures.length];
        int count = 0;
        for (Treasure i : treasures)
            treasure[count++] =  (Treasure) i;
        Map map = new Map(rows,columns,treasure);
        return map;
    }
    public Player getWinner()
    {
        Player max = players.get(0);
        int score = players.get(0).getScore();
        for (Player i : players)
            if (i.getScore() > score || (i.getScore() == score && i.getSteps() < max.getSteps()))
            {
                score = i.getScore();
                max = i;
            }
        return max;
    }
}
