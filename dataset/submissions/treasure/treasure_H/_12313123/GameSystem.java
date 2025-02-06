import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerList=new ArrayList<Player>();
    public void addPlayer(Player player){
        playerList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map newmap=new Map(rows,columns,treasures);
        return newmap;
    }
    public Player getWinner(){
        int maxscore=0;
        int minsteps=10000000;
        ArrayList<Player> fistSelection=new ArrayList<Player>();
        for(Player player:playerList){
            if(player.getScore()>maxscore){
                maxscore= player.getScore();
            }
        }
        for(Player player:playerList){
            if(player.getScore()==maxscore){
                fistSelection.add(player);
            }
        }

        for(Player player:fistSelection){
            if(player.getSteps()<minsteps){
                minsteps= player.getSteps();
            }
        }
        for(Player player:fistSelection){
            if(player.getSteps()==minsteps){
                return player;
            }
        }
        return playerList.get(100000);

    }


}

