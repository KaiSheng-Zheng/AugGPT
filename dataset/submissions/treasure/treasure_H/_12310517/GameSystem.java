import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player>players = new ArrayList<>();
    public void addPlayer (Player player) {
        players.add(player);
    }

    public Map newGame (int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner () {
        for (int i = 1; i < players.size(); ++i) {
            boolean flag = true;
            for (int j = 0; j < players.size() - i; ++j) {
                boolean flg = false;
                if (players.get(j).getScore() < players.get(j + 1).getScore()) flg = true;
                if (players.get(j).getScore() == players.get(j + 1).getScore()) if (players.get(j).getSteps() > players.get(j + 1).getSteps()) flg = true;
                if (flg) {
                    Player tmp = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, tmp);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        return players.get(0);
    }
}
