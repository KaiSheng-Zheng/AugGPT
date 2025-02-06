public class Player {
    private final int id;
    protected int count=0;
    private int score=0;
    private int steps=0;
    private Position pos;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPos){
        count++;
        this.id=count;
        setMap(map);
        setPos(initialPos);
        maxStepAllowed=999999;
    }
    public Player(Map map, Position initialPos, int maxStepAllowed){
        count++;
        this.id=count;
        setMap(map);
        setPos(initialPos);
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        if(map.isActive()&&steps>getMaxStepAllowed()){
            if(direction==Direction.LEFT){
                if(getPosition().getCol()==0){
                    return false;
                }
                else {
                    if(getPosition().getCol()-steps>=0){
                    setPos(getPosition().getRow(),getPosition().getCol()-steps);
                    setSteps(getSteps()+steps);
                    }
                    else{
                        setPos(getPosition().getRow(),0);
                        setSteps(getSteps()+getPosition().getCol());
                    }
                    setScore(getScore()+ getMap().hasTreasure(getPosition()));
                    return true;}
            }
            else if(direction==Direction.RIGHT){
                if(getPosition().getCol()==map.getColumns()){
                    return false;
                }
                else {
                    if(getPosition().getCol()+steps>=map.getColumns()){
                        setPos(getPosition().getRow(),getPosition().getCol()+steps);
                        setSteps(getSteps()+steps);
                    }
                    else{
                        setPos(getPosition().getRow(),map.getColumns());
                        setSteps(getSteps()+map.getColumns()-getPosition().getCol());
                    }
                    setScore(getScore()+ getMap().hasTreasure(getPosition()));
                    return true;}
            }
            else if(direction==Direction.UP){
                if(getPosition().getRow()==0){
                    return false;
                }
                else {
                    if(getPosition().getRow()-steps>=0){
                        setPos(getPosition().getRow()-steps,getPosition().getCol());
                        setSteps(getSteps()+steps);
                    }
                    else{
                        setPos(0,getPosition().getCol());
                        setSteps(getSteps()+getPosition().getRow());
                    }
                    setScore(getScore()+ getMap().hasTreasure(getPosition()));
                    return true;}
            }
            else {
                if(getPosition().getRow()==map.getRows()){
                    return false;
                }
                else {
                    if(getPosition().getRow()+steps>=map.getRows()){
                        setPos(getPosition().getRow()+steps,getPosition().getCol());
                        setSteps(getSteps()+steps);
                    }
                    else{
                        setPos(map.getRows(),getPosition().getCol());
                        setSteps(getSteps()+map.getRows()-getPosition().getRow());
                    }
                    setScore(getScore()+ getMap().hasTreasure(getPosition()));
                    return true;}
            }
        }
        else {return false;}
    }
    public boolean equals(Object player) {
        Player p = (Player) player;
        if (this == player) {
            return true;
        }
        else {
            return false;
        }
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public int getId() {
        return id;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }
    public void setPos(int a,int b) {
        this.pos= new Position(a,b);
    }
    public Position getPosition() {
        return pos;
    }
    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }
    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    public int getSteps() {
        return steps;
    }

    public Map getMap() {
        return map;
    }
}