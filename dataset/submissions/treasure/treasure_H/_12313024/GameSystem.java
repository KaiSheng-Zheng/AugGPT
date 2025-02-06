public class GameSystem {
    private Player[] players = new Player[10000];
    int num = 0;
    public void addPlayer (Player plr) {
        players[num] = plr;
        num++;
    }
    public Map newGame (int rs, int cs, Treasure[] trs) {
        Map m = new Map(rs, cs, trs);
        return m;
    }
    public Player getWinner () {
        int x = -1000000000;
        int x2 = 1000000000;
        int plc = 0;
        for (int i = 0; i < num; i++) {
            if (players[i].getScore() > x) {
                x = players[i].getScore();
                continue;
            }
        }
        for (int i = 0; i < num; i++) {
            if (players[i].getScore() == x) {
                if (players[i].getSteps() < x2) {
                    x2 = players[i].getSteps();
                    plc = i;
                }
            }
        }
        return players[plc];
    }
}
