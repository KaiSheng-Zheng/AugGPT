public class Player {
    public static int count=0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private final Map map;
    private final int maxStepAllowed;

    public Player(Map map,Position initialPosition) {
        this.map=map;
        this.position=initialPosition;
        this.score=0;this.steps=0;
        this.id=++count;
        this.maxStepAllowed=-1;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed) {
        this.maxStepAllowed=maxStepAllowed;
        this.map=map;
        this.position=initialPosition;
        this.score=0;this.steps=0;
        this.id=++count;
    }

    public static boolean isMove(Position position,Map map){
        if(position.getRow()>= map.getRows()||position.getCol()>= map.getColumns()||position.getRow()<0||position.getCol()<0){
            return false;
        }
        return true;
    }
    public boolean move(Direction direction,int steps){
        int x=0,y=0;
        switch (direction){
            case UP:
                y=-1;
                break;
            case DOWN:
                y=1;
                break;
            case RIGHT:
                x=1;
                break;
            default:
                x=-1;
        }

        while(steps>0) {
            if (this.steps == this.maxStepAllowed)return false;
            if(!this.map.isActive())return false;
            this.position.setRow(this.position.getRow()+y);
            this.position.setCol(this.position.getCol()+x);
            if(isMove(position,map)){
                steps--;this.setSteps(this.getSteps()+1);
                int score=this.map.hasTreasure(this.position);
                if(score>0){
                    this.score+=score;
                    map.update(position);
                }
            }else{
                this.position.setRow(this.position.getRow()-y);
                this.position.setCol(this.position.getCol()-x);
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object player){
        if(player instanceof Player){
            Player p=(Player) player;
            if(p==null)return false;
            if(p.getId()==this.getId())return true;
        }
        return false;
    }
    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }
}