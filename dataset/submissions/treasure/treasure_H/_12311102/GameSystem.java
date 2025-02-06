public class GameSystem {
    private int count = 0;
    public Player[] players;
    public void addPlayer(Player player) {
        players[count] = player;
        count += 1;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        for (int counter1 = 0;counter1 < players.length;counter1++) {
            for (int counter2 = 0;counter2 < treasures.length;counter2++) {
                if (players[counter1].getPosition() == treasures[counter2].getPosition()) {
                    players[counter1].setScore(treasures[counter2].getScore());
                    treasures[counter2] = null;
                }
            }
        }
        return null;
    }
    public Player winner;
    public Player getWinner() {
        Player first = players[0];
        for (int counter = 1;counter < players.length;counter++) {
            if (players[0].getScore() < players[counter].getScore()) {
                first = players[counter];
            }
        }
        return winner = first;
    }
}