

public class Player {
    private int score=0;
    private int steps=0;
    private final int maxStep;
    private final int id;
    private Position position;
    private Map map;
    private static int count=0;
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map=map;
        position=initialPosition;
        maxStep=maxStepAllowed;
        id=count;
        count++;
    }
    public Player(Map map,Position initialPosition){
        this(map,initialPosition,-1);
    }
    public int getScore(){
        return score;
    }
    public int getSteps(){
        return steps;
    }
    public int getId(){
        return id;
    }
    public Position getPosition(){
        return position;
    }
    public boolean move(Direction direction,int steps){
        if(!map.isActive())
            return false;
        for(int i=1;i<=steps;i++){
            if(this.steps==maxStep)
                return false;
            if(Position.sum(position,direction.vector).isOutside(map.getRows(),map.getColumns()))
                return false;
            position.add(direction.vector);
            this.steps++;
            score+=map.getScore(position);
            map.update(position);
        }
        return true;
    }
    public boolean isBetterThan(Player player){
        if(score>player.score)
            return true;
        else if(score<player.score)
            return false;
        else
            return steps<=player.steps;
    }
    public boolean equals(Object object){
        if(object==null)
            return false;
        if(!(object instanceof Player))
            return false;
        Player player=(Player)object;
        return this.id==player.id;
    }
}
