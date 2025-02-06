public class GameSystem{
    Player[] p;int ct;
    GameSystem(){ct=0;p=new Player[1007];}
    public void addPlayer(Player player){p[ct++]=player;}
    public Map newGame(int r,int c,Treasure... t){return new Map(r,c,t);}
    public Player getWinner(){
        int id=0;
        for(int i=0;i<ct;++i){
            if(p[i].getScore()>p[id].getScore())id=i;
            else if(p[id].getScore()==p[i].getScore()&&p[id].getSteps()>p[i].getSteps())id=i;
        }
        return p[id];
    }
}
