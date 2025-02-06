public class GameSystem {
    private static int uid=0;
    public Position[] positions=new Position[1000000];
    private Player[] players=new Player[1000000];
    public void addPlayer(Player player){

        player.setUid(this.uid);
        players[uid]=player;
        positions[uid]=player.getPosition();
        uid++;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map m=new Map(rows,columns,treasures);
        return m;
    }
    public Player getWinner(){
        for (int i = 0; i < uid; i++) {
            for (int j = 0; j <uid-1 ; j++) {
                if(players[j].getScore()<players[j+1].getScore()){
                    swap(players,j,j+1);
                }
                if(players[j].getScore()==players[j=1].getScore()){
                    if(players[j].getSteps()>players[j+1].getSteps()){
                        swap(players,j,j+1);
                    }
                }
            }
        }

        return players[0];
    }

    public static void swap(Player[] player,int i,int j){
        Player temp1=player[i];
        Player temp2=player[j];
        player[i]=temp2;
        player[j]=temp1;
    }

}
