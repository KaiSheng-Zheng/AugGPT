public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private int maxStepAllowed;
    private Position position;
    private Map map;
    public static int cnt=0;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=100000000;
        this.id=++cnt;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        this.id=++cnt;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public int getSteps() {
        return steps;
    }
    public boolean move(Direction direction, int steps){
        int xc=direction.rowchange();
        int yc=direction.colchange();
        int x=position.getRow();
        int y=position.getCol();
        for(int i=1;i<=steps;i++){
            if(map.isActive()==false) return false;
            if(this.steps>=this.maxStepAllowed) return false;
            x=x+xc;
            y=y+yc;
            if(map.pd(x,y)==false) return false;
            this.steps++;
            position.setRow(x);
            position.setCol(y);
            if(map.hasTreasure(new Position(x,y))>0){
                this.score=this.score+map.hasTreasure(new Position(x,y));
                map.update(new Position(x,y));
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        if(this.id==p.getId()) return true;
        return false;
    }
}
