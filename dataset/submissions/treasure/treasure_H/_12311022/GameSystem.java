
import java.util.Arrays;

public class GameSystem {
    private Player[] players=new Player[100];
    private int playersNumber;
    public void addPlayer(Player player){
        players[playersNumber++]=player;

    }
    public Map newGame(int rows,int columns,Treasure...treasures){
        return new Map( rows,columns,treasures);
    }
    public  Player getWinner(){
       Player winner=players[0];
        int[] score=new int[playersNumber];
        for(int i=0;i<playersNumber;i++){
            score[i]=players[i].getScore();
        }
        for(int j=0;j<playersNumber-1;j++){
            for(int i=0;i<playersNumber-1-j;i++){
                if(score[i]>score[i+1]){
                    int tep =score[i+1];
                    score[i+1]=score[i];
                    score[i]=tep;
                    Player player=players[i+1];
                    players[i+1]=players[i];
                    players[i]=player;
                }
            }
        }
        int winnerSameScoreNumber=0;
        for(int i=playersNumber-1;i>=0;i--){
            if(score[i]==score[playersNumber-1]){
                winnerSameScoreNumber++;
            }
        }
        Player[] winnerSameScore=new Player[winnerSameScoreNumber];
        int order=0;
        for(int i=playersNumber-1;i>=0;i--){
         if(score[i]==score[playersNumber-1]){
             winnerSameScore[order]=players[i];
             order++;
         }
        }
        int[] winnerStep=new int[winnerSameScoreNumber];
        for(int i=0;i<winnerSameScoreNumber;i++){
            winnerStep[i]=winnerSameScore[i].getSteps();
        }
        Arrays.sort(winnerStep);
        for(int i=0;i<winnerSameScoreNumber;i++){
            if(winnerSameScore[i].getSteps()==winnerStep[0]){
                winner=winnerSameScore[i];

            }
        }
        return winner; }
    }

