public class GameSystem {
    private final Player[] players = new Player[10000];

    public void addPlayer(Player player) {
        this.players[player.getId() - 10000*gameNum - 1] = player;
    }

    private static int gameNum = 0;

    public Map newGame(int rows, int columns, Treasure... treasures) {
        gameNum++;
        for (int i = 0; i < 10000; i++) {
            this.players[i] = new Player(new Map(0,0,new Treasure[0]),new Position(0,0));
        }
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        int[] scores = new int[10000];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = players[i].getScore();
        }
        int maxScore = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        int[] preWinner = new int[10000];
        int a = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                preWinner[a] = i;
                a++;
            }
        }
        Player winner = players[preWinner[0]];
        for (int i = 0; i < a; i++) {
            if (winner.getSteps() > players[preWinner[i]].getSteps()) {
                winner = players[preWinner[i]];
            }
        }
        return winner;
    }
}
