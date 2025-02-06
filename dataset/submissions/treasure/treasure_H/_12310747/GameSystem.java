import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player>playerlist=new ArrayList<Player>();

    public void addPlayer(Player player){
        playerlist.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        Map map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        int winnerindex=0;
        ArrayList<Integer>winnerindexlist=new ArrayList<Integer>();
        for (int i = 0; i < playerlist.size(); i++) {
            if (playerlist.get(i).getScore()
                    > playerlist.get(winnerindex).getScore()){
                winnerindex=i;
            }

        }
        for (int i = 0; i <playerlist.size() ; i++) {
            if (playerlist.get(i).getScore()
                    ==playerlist.get(winnerindex).getScore()){
                winnerindexlist.add(i);
            }
        }
        if (winnerindexlist.size()==1){
            return playerlist.get(winnerindex);
        }else {
            int finalwinnerindex=winnerindexlist.get(0);
            for (int i = 0; i <winnerindexlist.size() ; i++) {
                if (playerlist.get(winnerindexlist.get(i)).getSteps()
                        <playerlist.get(finalwinnerindex).getSteps()){
                    finalwinnerindex=winnerindexlist.get(i);
                }
            }
            return playerlist.get(finalwinnerindex);
        }


    }

}