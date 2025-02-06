import java.util.ArrayList;
import java.util.Comparator;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getScore() == o2.getScore()) {
                    return o2.getSteps() - o1.getSteps();
                } else {
                    return o1.getScore() - o2.getScore();
                }
            }
        });
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getScore() + " " + players.get(i).getSteps());
        }
        return players.get(players.size() - 1);
    }
}
