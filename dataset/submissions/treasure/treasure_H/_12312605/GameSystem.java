public class GameSystem {
    Map map;
    private int countPlayer=0;
    private Player[] players=new Player[1000+5];
//    private int[] ifAdd=new int[1000+5];
    public void addPlayer(Player player){
        countPlayer++;
//        System.out.println("countPlayer: "+countPlayer);
        players[countPlayer]=player;


    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        int n=countPlayer;
        for(int i=countPlayer-1;i>=1;i--){
//            if(players[i]==null){
//                continue;
//            }
             if(players[i].getScore()>players[n].getScore()||(players[i].getScore()==players[n].getScore()&&players[i].getSteps()<players[n].getSteps())){
                n=i;
            }
        }
        return players[n];
    }
}
