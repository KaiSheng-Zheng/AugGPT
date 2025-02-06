import java.util.ArrayList;

public class GameSystem {
    public static int playernumber = 0;
    public ArrayList<Player>players = new ArrayList<>();
    public static int[] scores = new int[100];
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows,int columns,Treasure... treasures){
        Map gamemap = new Map(rows,columns,treasures);
        playernumber = 0;
        for(int i = 0;i < players.size();i++) {
            players.remove(0);
        }
        return gamemap;
    }
    public Player getWinner(){
        int max = 0;
        int winnerID = -1;
        Player winner = players.get(0);
        for(int score : scores){
            if(score > max){
                max = score;
            }
        }
        for(int i = 0;i < scores.length;i++){
            if(scores[i] == max){
                winnerID = i;
                break;
            }
        }
        for(int i = 0;i < players.size();i++){
            Player maybewinner = players.get(i);
            if(maybewinner.getId() == winnerID){
                winner = players.get(i);
            }
        }
        return winner;
    }
    public static int updatePlayerNumber(){
        playernumber = playernumber + 1;
        return playernumber;
    }
}