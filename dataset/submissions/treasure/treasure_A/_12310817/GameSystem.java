public class GameSystem {
    public int n=0;
    private Player[] players=new Player[100];
    public void addPlayer(Player player){
        players[n]=player;
        n++;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int max=players[0].getScore();
        int id=0;
        for(int i=0;i<n;i++){
            if(max<players[i].getScore()){
                id=i;
                max=players[i].getScore();
            }
            else if(max==players[i].getScore()){
                if(players[id].getSteps()>players[i].getSteps()){
                    id=i;
                }
            }
        }
        return players[id];
    }
}
