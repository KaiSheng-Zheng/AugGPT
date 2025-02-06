//package class_task_6_2;

public class GameSystem {
    private int maxn = 10005;
    private int cnt,cntmap;
    private Player players[]=new Player[100];
    private int maptreaurecnt[]=new int[maxn];
    private Map maps[]=new Map[maxn];
    public void addPlayer(Player player){
        players[++cnt]=new Player();
        players[cnt]=player;
    }
    public Map newGame(int rows,int columns,Treasure ...treasures){
        maps[++cntmap]=new Map(rows,columns,treasures);
        cnt=0;
        return maps[cntmap];
    }
    public Player getWinner(){
        int maxvalue=-maxn,maxstep=maxn,purpose=-1;
        for(int i=1;i<=cnt;i++){
            if(players[i].getScore()>maxvalue){
                maxvalue=players[i].getScore();
                maxstep=players[i].getSteps();
                purpose=i;
            }
            else{
                if(players[i].getScore()==maxvalue){
                    if(maxstep>players[i].getSteps()){
                        maxstep=players[i].getSteps();
                        purpose=i;
                    }
                }
            }
        }
        return players[purpose];
    }

}
