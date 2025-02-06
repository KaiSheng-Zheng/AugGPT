public class GameSystem {
    private Player[] players=new Player[1000];
    private Map map;
    private int num=0;
    public void addPlayer(Player player){
        players[num]=player;
        num+=1;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        int max=players[0].getScore();
        int min=players[0].getSteps();
        int a=0;
        for(int i=0;i<num;i++){
            if(players[i].getScore()>max){
                max=players[i].getScore();
                min=players[i].getSteps();
                a=i;
            }else if(players[i].getScore()==max&players[i].getSteps()<min){
                max=players[i].getScore();
                min=players[i].getSteps();
                a=i;
            }
        }
        return players[a];
    }
}
