import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;

    public GameSystem(){
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }
    
    public Map newGame(int rows, int columns, Treasure[] treasures){
        return new Map(rows, columns, treasures);
    }

    public Player getWinner(){
        if(players.isEmpty()){
            return null;
        }

        Player winner = this.players.get(0);

        for(Player player : this.players){

            if(player.getScore() > winner.getScore()){
                winner = player;
            }
            else if(player.getScore() == winner.getScore() && player.getSteps() < winner.getSteps()){
                winner = player;
            }
        }
        return winner;
    }
}
