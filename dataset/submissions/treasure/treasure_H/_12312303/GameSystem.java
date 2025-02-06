import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map newMap = new Map(rows, columns, treasures);
        return newMap;
    }

    public Player getWinner() {
        Player winner = players.get(0);
        Player second = players.get(0);
        for (Player i : players) {
            if (i.getScore() > winner.getScore()){
                winner = i;second=i;
            }
            else if(i.getScore()==winner.getScore()){
                if(i.getSteps()<=winner.getSteps()){
                    winner=i;second=i;
                }else if(i.getSteps()<second.getSteps()){
                    second=i;
                }
            }
        }
        return winner;
    }
}
