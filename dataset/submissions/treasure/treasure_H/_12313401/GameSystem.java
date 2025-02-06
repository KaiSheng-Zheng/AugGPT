import java.util.ArrayList;

public class GameSystem {
    public ArrayList<Player> players=new ArrayList<>();
    public ArrayList<Integer> scores=new ArrayList<>();
    public ArrayList<Integer> steps=new ArrayList<>();

    public void addPlayer(Player player) {
        this.players.add(player);
        this.scores.add(player.getScore());
        this.steps.add(player.getSteps());
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        int MaxScore = 0;
        ArrayList<Integer> ss = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            scores.add(players.get(i).getScore());
            steps.add(players.get(i).getSteps());
        }
        for (int s :
                scores) {
            if (s >= MaxScore) {
                MaxScore = s;
            }
        }
        for (int i = 0; scores.contains(MaxScore);
             i++) {
            ss.add(scores.indexOf(MaxScore));
            scores.set(scores.indexOf(MaxScore),-1 );
        }
        int MinSteps = steps.get(ss.get(0));
        for (int i = 0; i < ss.size(); i++) {
            if (steps.get(ss.get(i)) < MinSteps) {
                MinSteps = steps.get(ss.get(i));
            }
        }
        Player p = new Player();
        for (Player e : players) {
            if (e.getScore() == MaxScore && e.getSteps() == MinSteps) {
                p = e;
            }
        }
        return p;
    }
}
