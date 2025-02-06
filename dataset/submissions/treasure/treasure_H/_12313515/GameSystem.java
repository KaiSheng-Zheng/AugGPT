import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;
    private Player winner;

    public GameSystem(){
        players=new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        int playerScore=0;
        int maxscore;
        for (Player i:players) {
            if(i.getScore()>playerScore){
                playerScore=i.getScore();
            }
        }
        ArrayList<Player> maxPlayer=new ArrayList<>();
        for (Player i:players) {
            if(i.getScore()==playerScore){
                maxPlayer.add(i);
            }
        }
        maxscore=maxPlayer.get(0).getScore();
        if (maxPlayer.size()>1){
            int newSteps=maxPlayer.get(0).getSteps();
            for (Player i:maxPlayer) {
                if(i.getSteps()<newSteps){
                    newSteps=i.getSteps();
                }
            }
            for (Player i:players) {
                if(i.getSteps()==newSteps&&i.getScore()==maxscore){
                    this.winner=i;
                }
            }
            }
        else {
            this.winner=maxPlayer.get(0);
        }
        return winner;
    }


}
