import java.util.ArrayList;
public class GameSystem {
    ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int highestScore = -1 ;
        int cnt = 0;
        for(Player i : players){
            if(i.getScore()>highestScore||(i.getScore()==highestScore && i.getSteps()<cnt)){
                highestScore=i.getScore();
                cnt=i.getSteps();
            }
        }
        Player winner = players.get(0);
        for(Player i: players){
            if(i.getScore()==highestScore && i.getSteps()==cnt){
                winner=i;
            }
        }
        return winner;
    }
}