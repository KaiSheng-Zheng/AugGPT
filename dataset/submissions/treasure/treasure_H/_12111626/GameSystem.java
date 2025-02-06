public class GameSystem {
    private Map map;
    private Player[] players;

    public Map newGame(int rows, int columns, Treasure... treasures) {
        map = new Map(rows, columns, treasures);
        return map;
    }

    public void addPlayer(Player player) {
        if (players == null) {
            players = new Player[1];
            players[0] = player;
        } else {
            Player[] temp = new Player[players.length + 1];
            System.arraycopy(players, 0, temp, 0, players.length);
            temp[players.length] = player;
            players = temp;
        }
    }

    public Player getWinner() {
        Player winner = players[0];
        if (players.length != 1) {
            for (int i = 1; i < players.length; i++) {
                if (players[i].getScore() > winner.getScore()) {
                    winner = players[i];
                } else if (players[i].getScore() == winner.getScore()) {
                    if (players[i].getSteps() < winner.getSteps()) {
                        winner = players[i];
                    }
                }
            }
        }
        return winner;
    }
}