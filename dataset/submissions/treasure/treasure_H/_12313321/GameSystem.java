import java.util.ArrayList;

public class GameSystem {
    public ArrayList<Player> players=new ArrayList<>();
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner() {
        Player winner = players.get(0);
        int size=players.size();
        for (int i=0;i<size;i++) {
            if (winner.getScore()<players.get(i).getScore() || (winner.getScore() == players.get(i).getScore() && winner.getSteps() > players.get(i).getSteps()))
                winner=players.get(i);
            }
        return winner;
    }
}