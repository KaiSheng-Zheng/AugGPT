public class GameSystem {
    private Player []players=new Player[100];
    private int num=0;
    public void addPlayer(Player player){
        players[num] = player;
        num++;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map = new Map(rows, columns, treasures);
        return map;
    }
    public Player getWinner(){
        Player winner=players[0];
        int score=players[0].getScore();
        int step=players[0].getSteps();
        for (int i=1;i<num;i++){
            if (players[i].getScore() > score || (players[i].getScore() == score && players[i].getSteps() <step)) {
                score = players[i].getScore();
                step = players[i].getSteps();
                winner = players[i];
            }
        }
        return winner;
    }
}
