public class Player {
    static int cnt=0;
    private final int id;
    private int score;
    private int steps=0;
    private final int maxstep;
    private final Position position;
    private final Map map;
    public Player(Map map, Position initialPosition){
        this.map=map;this.position=initialPosition;this.id=++cnt;maxstep=-1;score=0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;this.position=initialPosition;maxstep=maxStepAllowed;this.id=++cnt;score=0;
    }
    public int getScore(){return score;}
    public int getSteps(){return steps;}

    public Position getPosition() {return position;}

    public int getId() {return id;}
    public boolean move(Direction direction,int s){

        int dx=direction.getDx();
        int dy=direction.getDy();
        while(s>0){
            if(steps==maxstep) return false;
            if(!map.isActive()) return false;
            int nx=position.getRow()+dx,ny=position.getCol()+dy;
            if(!map.hav(nx,ny)) return false;
            s--;steps++;
            position.setRow(nx);
            position.setCol(ny);
            score+=map.hasTreasure(position);
            map.update(position);
        }
        return true;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        return p.getId()==id;
    }
}
