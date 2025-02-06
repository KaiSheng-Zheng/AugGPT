public class GameSystem {
    private Player[] players=new Player[114514];
    private int cnt=0;
    public void addPlayer(Player player){
        players[++cnt]=player;
    }
    public Map newGame(int rows,int columns,Treasure... treasures){
        Map a=new Map(rows,columns,treasures);
        return a;
    }
    public Player getWinner(){
        Player winner=players[1];
        int v1=players[1].getScore(),v2=players[1].getStp();
        for(int i=2;i<=cnt;i++){
            if(players[i].getScore()>v1){
                winner=players[i];
                v1=players[i].getScore();
                v2=players[i].getStp();
            }
            else if(players[i].getScore()==v1&&players[i].getStp()<v2){
                winner=players[i];
                v2=players[i].getStp();
            }
        }
        return  winner;
    }
}
