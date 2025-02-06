import java.util.ArrayList;


public class GameSystem {
    ArrayList<Player> playerArrayList = new ArrayList<>();
    public void addPlayer(Player player){
        playerArrayList.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        Map gameMap = new Map(rows,columns,treasures);
        return gameMap;
    }

    public Player getWinner(){
        Player winner ;
        winner = playerArrayList.get(0);
        for (int i = 1; i < playerArrayList.size(); i++) {
            if (winner.getScore() < playerArrayList.get(i).getScore()){
                winner = playerArrayList.get(i);
            }else if (winner.getScore() == playerArrayList.get(i).getScore()){
                if (winner.getSteps() > playerArrayList.get(i).getSteps()){
                    winner = playerArrayList.get(i);
                }
            }
        }
        return winner;
    }

}