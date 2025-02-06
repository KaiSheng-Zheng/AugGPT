import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures) {
        Treasure[] treasures1 = new Treasure[treasures.length];
        System.arraycopy(treasures, 0, treasures1, 0, treasures.length);
        return new Map(rows, columns, treasures1);
    }
    public Player getWinner() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size() - i - 1; j++) {
                if ((players.get(j).getScore() < players.get(j + 1).getScore()) || ((players.get(j).getScore() == players.get(j + 1).getScore()) && (players.get(j).getSteps() > players.get(j + 1).getSteps()))) {
                    Player temp = new Player(players.get(j).getId(), players.get(j).getScore(), players.get(j).getSteps(), players.get(j).getPosition(), players.get(j).getMap(), players.get(j).getMaxStepAllowed(), players.get(j).getStepAllowed());
                    players.set(j, new Player(players.get(j + 1).getId(), players.get(j + 1).getScore(), players.get(j + 1).getSteps(), players.get(j + 1).getPosition(), players.get(j + 1).getMap(), players.get(j + 1).getMaxStepAllowed(), players.get(j + 1).getStepAllowed()));
                    players.set(j + 1, new Player(temp.getId(), temp.getScore(), temp.getSteps(), temp.getPosition(), temp.getMap(), temp.getMaxStepAllowed(), temp.getStepAllowed()));
                }
            }
        }
        return players.get(0);
    }
}