import java.util.ArrayList;

public class GameSystem{
    ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        int winnerid = 0;
        int minstep = 0;
        int maxscore = 0;
        Player winner=players.get(0);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore()>maxscore && players.get(i).getScore()!=0){
                maxscore =players.get(i).getScore();
                winnerid = players.get(i).getId();
                minstep = players.get(i).getSteps();
                winner = players.get(i);
            }
            else if (players.get(i).getScore()==maxscore && players.get(i).getScore()!=0){
                if (players.get(i).getSteps()<minstep){
                    winnerid = players.get(i).getId();
                    minstep=players.get(i).getSteps();
                    winner = players.get(i);
                }
            }
        }
        return winner;
    }
}
