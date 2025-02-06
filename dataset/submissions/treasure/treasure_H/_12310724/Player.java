public class Player {
    private final int id;
    static int playercnt=0;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    private int limstep=10000007;
    static int[][] Dir=new int[][]{{0,0},{0,-1},{0,1},{-1,0},{1,0}};

    public Player(Map map, Position initialPosition){
        this.map=map;this.position=initialPosition;
        this.id=++playercnt;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;this.position=initialPosition;this.limstep=maxStepAllowed;
        this.id=++playercnt;
    }
    public Player(int score,int steps){
        this.score=score;this.id=323321;this.steps=steps;
    }
    public int getId(){return id;}
    public boolean Check(Position now,int nowstep){
        int tmpx=now.getRow(),tmpy=now.getCol(),bx=map.Getrows(),by=map.Getcols();
//        System.out.printf("%d %d %d %d Check",tmpx,tmpy,bx,by);
        return (tmpx>=0 && tmpx<bx &&tmpy>=0 && tmpy<by && nowstep<=limstep);
    }
    public boolean move(Direction direction,int stp){
        int tmp=direction.Getv();
        int nowx=position.getRow(),nowy=position.getCol();
        for(int i=1;i<=stp;++i){
//            System.out.printf("%d %d %d %d %d %d\n",nowx,nowy,nowx+Dir[tmp][0],nowy+Dir[tmp][1],steps,limstep);
            if(!map.isActive()){
                return false;
            }
            Position t=new Position(nowx+Dir[tmp][0],nowy+Dir[tmp][1]);
//            System.out.printf("????Check %d %d %d %d\n",t.getRow(),t.getCol(),nowx+Dir[tmp][0],nowy+Dir[tmp][1]);
//            System.out.println("QAqqqqqqqq?");
            if(Check(t,steps+1)){
//                System.out.printf("%d %d???\n",nowx,nowy);
                nowx+=Dir[tmp][0];
                nowy+=Dir[tmp][1];
                score+=map.hasTreasure(new Position(nowx,nowy));
                map.update(new Position(nowx,nowy));
                steps++;
//                System.out.printf("%d %d ?????\n",nowx,nowy);
                position.setRow(nowx);
                position.setCol(nowy);
            }
            else{
                return false;
            }
        }

//        System.out.printf("%d %d %d %d\n",position.getRow(),position.getCol(),steps,limstep);
        return true;
    }
    public int getScore(){return score;}
    public Position getPosition(){return position;}
    public boolean equals(Object player){
        Player p=(Player) player;
        return (this.id==p.getId());
    }
    public int getSteps(){return steps;}
//    public void setMap(Map map){this.map=map;}

}
