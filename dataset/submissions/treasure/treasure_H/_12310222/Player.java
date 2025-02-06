public class Player{
    private static int iid=0;
    private final int id;
    private int score;
    private int steps=0,maxs=100000000;
    private Map map;
    private Position position;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        iid+=1;
        id=iid;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxs=maxStepAllowed;
        iid+=1;
        id=iid;
    }

    public boolean move(Direction direction, int steps){
        int x=position.getRow()+direction.getX();
        int y=position.getCol()+direction.getY();
        if(this.map.isActive()&&this.steps<maxs&&
                x>=0&& y>=0&& x<this.map.getRows()&& y<this.map.getColumns()){
            position.setRow(x);
            position.setCol(y);
            score+= map.hasTreasure(position);
            map.update(position);
            this.steps+=1;
//            System.out.println(id+" "+x+" "+y+" "+score+" "+map.cnt);
//            map.getTreasures();
//            System.out.println();

            if(steps==1){return true;}
            return move(direction,steps-1);
        }
        return false;
    }

    public boolean equals(Object player){
        Player temp=(Player) player;
        return temp.getId()==this.getId();
    }
    public int getId() {return id;}
    public int getScore() {return score;}
    public int getSteps() {return steps;}
    public Position getPosition() {return position;}
}