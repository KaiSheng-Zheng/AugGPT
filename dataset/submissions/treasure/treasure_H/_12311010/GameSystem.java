import java.util.ArrayList;


public class GameSystem {


    ArrayList<Player> Playerlist = new ArrayList<Player>();
    int count = 0;
    public void addPlayer(Player player){
        Playerlist.add(player);

    };
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }

    public Player getWinner() {
        Player winner = Playerlist.get(0);
        ArrayList<Player> HighestScorePlayerlist = new ArrayList<Player>();
        int maxscore = 0;
        int minstep = 9999;
        for (Player p:Playerlist
             ) {
            if (p.getScore() >= maxscore){
                 maxscore = p.getScore();
            }
        }
        for (Player p:Playerlist
             ) {
            if (p.getScore() == maxscore){
                HighestScorePlayerlist.add(p);
            }
        }
        for (Player p :HighestScorePlayerlist
             ) {
            if (p.getSteps()<= minstep){
                minstep = p.getSteps();
            }
        }
        for (Player p :HighestScorePlayerlist
        ) {
            if(p.getSteps() == minstep){
                winner = p;
                break;
            }
        }

        return winner;
    }



}
