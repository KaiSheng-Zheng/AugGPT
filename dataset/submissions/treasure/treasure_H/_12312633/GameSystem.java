import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int highestscore = 0;
        Player winner = null;
        for (Player player : players){
            if (player.getScore()>highestscore){
                highestscore = player.getScore();
            }
        }int smalleststeps = 0;
        for (Player player:players){
            if (player.getScore()==highestscore){
                if (player.getAnothersum()<=smalleststeps||smalleststeps==0)
                    smalleststeps = player.getAnothersum();
            }
        }for (Player player:players){
            if (player.getScore()==highestscore&&player.getAnothersum()==smalleststeps)
                winner = player;
        }return winner;
    }
}
