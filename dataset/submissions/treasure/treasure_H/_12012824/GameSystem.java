import java.util.ArrayList;

public class GameSystem {

    private ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Player> getPlayers() {return players;};

    public void addPlayer(Player player){
        players.add(player);
    }

    private Map map;

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }


    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map( rows,  columns, treasures);
        return map;
    }

    public Player getWinner(){
        Player winner = players.get(0);
        for (int i = 0; i<players.size(); i++){
            if (players.get(i).getScore()>winner.getScore()){
                winner = players.get(i);
            } else if (players.get(i).getScore()==winner.getScore()) {
                if (winner.getSteps()>players.get(i).getSteps()){
                    winner = players.get(i);
                }
            }
        }
        return winner;
    }
}