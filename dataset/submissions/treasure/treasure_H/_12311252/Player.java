public class Player {
    private static int count=0;
    private final int id;
    private  int maxStepAllowed;
    private int score;
    private int steps;
    private Position pos;
    private Map map;
    public Player(Map map,Position initialPos){
        this.map=map;
        this.pos=initialPos;
        this.id=++count;
    }
    public Player(Map map,Position initialPos,int maxStepAllowed){
        this.id=++count;
        this.score=0;
        this.steps=0;
        this.pos=initialPos;
        this.map=map;
        this.maxStepAllowed=maxStepAllowed;
    }
    public int getId() {
        return id;
    }
    public int getScore() {
        return score;
    }
    public int getSteps() {
        return steps;
    }
    public Position getPosition() {
        return pos;
    }
    public boolean move(Direction direction,int steps){
        if(!map.isActive()||steps>maxStepAllowed||isBoundary(direction,steps)){
            return false;
        }else {
            return true;
        }
   }
   private boolean isBoundary(Direction direction,int steps){
        return false;
   }
   public boolean equals(Object player){
        if(this.id == id){
            return true;
        }else {
            return false;
        }
   }
}

