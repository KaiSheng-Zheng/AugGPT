public class GameSystem{
    private Player[] playerlist=new Player[100];
    private static int times=0;
    public void addPlayer(Player player){
        playerlist[times]=player;
        times++;
    }
    public Map newGame(int rows,int columns,Treasure[] treasures){
        Map map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        Player a=playerlist[0];
        for(int i=1;i<times;i++){
            if(a.getScore()<playerlist[i].getScore()){
                a=playerlist[i];
            }
            if(a.getScore()==playerlist[i].getScore()&&a.getSteps()>playerlist[i].getSteps()){
                a=playerlist[i];
            }
        }
        return a;
    }
}