public class Player{
    private final int id;
    private int score,steps,mxst;
    private static int ct=0;
    private Position position;
    private Map map;
    public Position getPosition(){return position;}
    public int getScore(){return score;}
    public int getSteps(){return steps;}
    public int getId(){return id;}
    public Player(Map mp,Position ps){
        id=++ct;position=ps;map=mp;score=steps=0;mxst=999999;
    }
    public Player(Map mp,Position ps,int maxStepAllowed){
        id=++ct;position=ps;map=mp;score=steps=0;mxst=maxStepAllowed;
    }
    public boolean move(Direction dir, int stp){
        while(stp-->0){
            if(!map.isActive()||steps==mxst)return false;
            int nr=position.getR()+dir.getRow(),nc=position.getC()+dir.getCol();
            if(nr<0||nr>=map.getR()||nc<0||nc>=map.getC())return false;
            position=new Position(nr,nc);++steps;
            int k=map.hasTreasure(position);
            if(k!=0){
                score+=k;map.update(position);
                if(!map.isActive())return false;
            }
        }
        return true;
    }
    public boolean equals(Object player){Player p=(Player)player;return id==p.id;}
}