import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>();


    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        int imax = 0;
        int smallStep = players.get(0).getSteps();
        int maxScore = players.get(0).getScore();
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getScore() > maxScore) {
                maxScore = players.get(i).getScore();
                imax = i;
                smallStep = players.get(i).getSteps();
            } else if (players.get(i).getScore() ==maxScore) {
                if (players.get(i).getSteps() < smallStep){
                    imax = i;
                    smallStep = players.get(i).getSteps();
                }
            }
        }
        return players.get(imax);
    }
}
