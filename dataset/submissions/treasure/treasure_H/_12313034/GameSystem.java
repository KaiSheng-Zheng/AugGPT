import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure...treasures){
        return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        Player winner = players.get(0);
        for(Player player :players){
            if (player.getScore()> winner.getScore()||(player.getScore()== winner.getScore()&&player.getSteps()< winner.getSteps())){
                winner = player;
            }
        }
        return winner;
    }

}
