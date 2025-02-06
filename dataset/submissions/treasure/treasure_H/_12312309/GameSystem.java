import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerArrayList = new ArrayList<>();

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }

    public void setPlayerArrayList(ArrayList<Player> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }

    public void addPlayer(Player player) {
        playerArrayList.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map gameMap = new Map(rows,columns,treasures);
        return gameMap;
    }

    public Player getWinner() {
        int maxScore = playerArrayList.get(0).getScore();
        int index = 0;
        for (int i = 0; i < playerArrayList.size(); i++) {
            if (playerArrayList.get(i).getScore() > maxScore) {
                maxScore = playerArrayList.get(i).getScore();
                index = i;
            }
        }
        int minSteps = playerArrayList.get(index).getSteps();
        for (int i = 0; i < playerArrayList.size(); i++) {
            if (playerArrayList.get(i).getScore() == maxScore) {
                if (playerArrayList.get(i).getSteps() < minSteps) {
                    index = i;
                }
            }
        }
        return playerArrayList.get(index);
    }
}
