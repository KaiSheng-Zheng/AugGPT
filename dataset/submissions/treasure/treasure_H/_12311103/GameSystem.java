import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerArrayList;

    public void addPlayer(Player player) {
        playerArrayList.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures) {
        playerArrayList = new ArrayList<>();
        Map map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        Player winner = playerArrayList.get(0);
        for (int i = 1; i < playerArrayList.size(); i++) {
            if (winner.getScore() < playerArrayList.get(i).getScore())
                winner = playerArrayList.get(i);
            else {
                if (winner.getScore() == playerArrayList.get(i).getScore()
                        && winner.getSteps() > playerArrayList.get(i).getSteps())
                    winner = playerArrayList.get(i);
            }
        }
        return winner;
    }
}