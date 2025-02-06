public class GameSystem {
    Player[] players=new Player[100];
    private int n=0;
    private Map map;
    public void addPlayer(Player player){
        this.players[++n]=player;
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        this.map=new Map(rows,columns,treasures);
        this.n=0;
        return map;
    }
    public Player getWinner(){
        Player winner=players[1];
        for(int i=2;i<=n;i++){
            if(players[i].getScore()> winner.getScore()) {
                winner=players[i];
            }
            else if(players[i].getScore()== winner.getScore() && players[i].getSteps()<winner.getSteps()){
                winner=players[i];
            }
        }
        return winner;
    }
}
