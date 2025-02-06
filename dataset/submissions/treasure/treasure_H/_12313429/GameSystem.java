import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public GameSystem(ArrayList<Player> players) {
        this.players = players;
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        
        Map gameMap = new Map(rows, columns, treasures);

       
        for (Player player : players) {
            
            player.getMap().update(player.getPosition());
            player.setScore(0);
            player.setSteps(0);
        }

        return gameMap;
    }

    public Player getWinner() {
        if (players.isEmpty()) {
            
            return null;
        }

       
        Player winner = players.get(0);

        for (int i = 1; i < players.size(); i++) {
            Player current = players.get(i);

           
            if (current.getScore() > winner.getScore()) {
                winner = current;
            } else if (current.getScore() == winner.getScore()) {
               
                if (current.getSteps() < winner.getSteps()) {
                    winner = current;
                }
            }
        }

        return winner;
    }
}
