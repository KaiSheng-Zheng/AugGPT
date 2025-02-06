public class GameSystem {
    private int countPlayer = 0;
    private Player[] playerList = new Player[128];
    public void addPlayer(Player player) {
        playerList[countPlayer++] = player;
    }
    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }
    public Player getWinner() {
        int winnerI = 0;
        for (int i = 1; i < countPlayer; i++) {
            if (playerList[i].getScore() > playerList[winnerI].getScore() ||
                    (playerList[i].getScore() == playerList[winnerI].getScore()
                            && playerList[i].getSteps() < playerList[winnerI].getSteps())) winnerI = i;
        }
        return playerList[winnerI];
    }
}
