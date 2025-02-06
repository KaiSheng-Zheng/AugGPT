public class GameSystem {
    private Player[] players;

    private int counter;
    public void addPlayer(Player player){
if (counter==0){
    players=new Player[Player.getCounter()];
}
        players[counter]=player;
        counter++;
    }
    public Map newGame(int rows,int columns,Treasure... treasures){

        Map map=new Map(rows,columns,treasures);
        return map;
    }

    public Player[] setPlayers(Player player){
        Player[] p=new Player[players.length+1];
        for (int i=0;i<players.length;i++){
            p[i]=players[i];
        }
        p[p.length-1]=player;
        return p;
    }
    public GameSystem() {
        Player.setCounter();
    }

    public Player getWinner(){
        int winner=0;
        int max=-1;
        for (int i=0;i<counter;i++){
            if (players[i].getScore()>max){
                winner=i;
                max=players[i].getScore();
            } else if (players[i].getScore()==max){
                if (players[i].getSteps()<players[winner].getSteps()){
                    winner=i;
                }
            }
        }
        return players[winner];

    }
}
