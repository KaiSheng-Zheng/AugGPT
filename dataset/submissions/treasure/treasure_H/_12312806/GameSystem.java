import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> Player = new ArrayList();
    public void addPlayer(Player player){
      Player.add(player);
    }
    public Map newGame( int rows, int columns,Treasure[] treasures) {
        return new Map(rows,columns,treasures);
    }
    public Player getWinner() {
        int maxScore = Integer.MIN_VALUE;
        Player maxPlayer = null;
        for (int i = 0; i < Player.size(); i++) {
            int currentScore = Player.get(i).getScore();
            if (currentScore > maxScore){
                maxScore = currentScore;
                maxPlayer = Player.get(i);
            } else if (currentScore == maxScore) {
                if (maxPlayer.getSteps() < Player.get(i).getSteps()){
                }else {maxPlayer = Player.get(i);}
            }
        }
        return maxPlayer;
    }
}
