import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> players = new ArrayList<Player>();
    private static int num;

    public GameSystem() {
        num = 1;
        Player.setCount(1);
        }

    public void addPlayer(Player player){
        players.add(player);
        num += 1;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner() {
        Player winner = null;
        for (int i = 0; i < num-2; i++) {
            if (players.get(i).getScore() > players.get(i + 1).getScore()) {
                winner = players.get(i);
            }
            if (players.get(i).getScore() == players.get(i + 1).getScore() && players.get(i).getSteps() < players.get(i + 1).getSteps()) {
                winner = players.get(i);
            }
        }
        return winner;
    }
}
