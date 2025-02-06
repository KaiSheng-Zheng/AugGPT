public class Player {
    private int id;
    static int tot=0;
    private int score;
    private int steps,mx=0x3f3f3f3f;
    private Position position;
    private Map map;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.score=0;
        this.id=++tot;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.mx=maxStepAllowed;
        this.score=0;
        this.id=++tot;
    }
    public Player(){}
    public boolean move(Direction direction,int steps){
        if(!map.isActive())return false;
        for(int i=1;i<=steps;i++){
            if(!map.isActive()||this.steps==mx)return false;
            position.move(direction.getRow(),direction.getCol());
            if(position.getRow()>map.getRows()||position.getCol()>map.getColumns()
                    ||position.getRow()<0||position.getCol()<0){
                position.move(-direction.getRow(),-direction.getCol());
                return false;
            }
            score+=map.hasTreasure(position);
            map.update(position);
            this.steps++;
        }
        return true;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        return p.getId()==this.id;
    }
    public int getScore() {return score;}
    public int getId() {return id;}
    public int getSteps() {return steps;}
    public Position getPosition() {return position;}
    public void setScore(int score) {this.score = score;}
    public void setSteps(int steps) {this.steps = steps;}
    public void setId(int id) {this.id = id;}
    public int getTot() {return tot;}
    public void setTot(int tot) {tot=0;}
}
