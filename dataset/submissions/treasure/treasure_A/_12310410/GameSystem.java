import java.util.ArrayList;
import java.util.List;

class GameSystem {
    private final List<Player> players;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map newmap=new Map(rows,columns,treasures);
        return newmap;
    }

    public Player getWinner() {
        int Winner=0;
        for(int i=0;i<players.size();i++){
            if(players.get(Winner).getScore()<players.get(i).getScore()){
                Winner=i;
            }
            else if(players.get(Winner).getScore()==players.get(i).getScore() && players.get(Winner).getSteps()>players.get(i).getSteps()){
                Winner=i;
            }
        }
        return players.get(Winner);
    }
}