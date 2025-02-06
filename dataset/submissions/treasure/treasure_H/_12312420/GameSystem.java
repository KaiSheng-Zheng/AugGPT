public class GameSystem {
    static int cnt=0;
    static Player[] ind;

    public void addPlayer(Player player){
        ind[++cnt]= player;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        ind = new Player[100010];cnt=0;
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player res = new Player();
        res.setScore(-1);
        res.setSteps(0x3f3f3f3f);
        for(int i=1;i<=cnt;i++){
            int score=ind[i].getScore(),step=ind[i].getSteps(),id=ind[i].getId();
            if(score>res.getScore()||
                    (score==res.getScore()&&step<res.getSteps())){
                res.setScore(score);
                res.setSteps(step);
                res.setId(id);
            }
        }
        return res;
    }
}
