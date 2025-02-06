import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        Player winner = players.get(0);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() > winner.getScore()) {
                winner = players.get(i);
            }
            if (players.get(i).getScore() == winner.getScore() && players.get(i).getSteps() < winner.getSteps()) {
                winner = players.get(i);
            }
        }
        return winner;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}