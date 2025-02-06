import java.util.ArrayList;

public class GameSystem {

    private ArrayList<Player> playerArrayList =new ArrayList<>();

    public void addPlayer(Player player) {
        playerArrayList.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows, columns, treasures);
    }

    public Player getWinner(){
        Player winner = playerArrayList.get(0);
        for (int i = 1; i < playerArrayList.size(); i++){
            if(playerArrayList.get(i).getScore() > winner.getScore()) {
                winner = playerArrayList.get(i);
            } else if(playerArrayList.get(i).getScore() == winner.getScore() && playerArrayList.get(i).getSteps() < winner.getSteps() ){
                winner = playerArrayList.get(i);
            }
        }
        return winner;
    }
}