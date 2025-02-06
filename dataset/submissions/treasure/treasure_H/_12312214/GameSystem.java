import java.util.Arrays;
public class GameSystem {
    private  Player []players=new Player[0];
    public void addPlayer(Player player){
        players=Arrays.copyOf(players,players.length+1);
        players[players.length-1]=player;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int maxScore=Integer.MIN_VALUE;
        int maxI=0;
        for (int i=0;i< players.length;i++){
            if(players[i].getScore()>maxScore){
                maxScore=players[i].getScore();
                maxI=i;
            }
            else if (players[i].getScore()==maxScore) {
                if (players[i].getSteps()<players[maxI].getSteps()){
                    maxScore=players[i].getScore();
                    maxI=i;
                }

            }
        }
        return players[maxI];
    }
}
