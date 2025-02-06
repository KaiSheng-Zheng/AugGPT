import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players=new ArrayList<>();
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int maxScore=scoreSort(players);
        return playerSort(players,maxScore);
    }
    public static int scoreSort(ArrayList<Player> players){
        int maxScore=players.get(0).getScore();
        for (int i = 0; i < players.size()-1; i++) {
            for (int j = 0; j < players.size()-1; j++) {
                maxScore= Math.max(maxScore, players.get(j + 1).getScore());
            }
        }
        return maxScore;
    }
    public static Player playerSort(ArrayList<Player> players,int maxScore){
        ArrayList<Player> winners=new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (maxScore==players.get(i).getScore()){
                winners.add(players.get(i));
            }
        }
        Player  winner=winners.get(0);
        for (int i = 0; i < winners.size()-1; i++) {
            for (int j = 0; j < winners.size()-1; j++) {
                winner=winner.getSteps()<winners.get(j+1).getSteps()?winner:winners.get(j+1);
            }
        }
        return winner;
    }
}
