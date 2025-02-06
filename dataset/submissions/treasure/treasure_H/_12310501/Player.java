public class Player {
    private final int id;
    private static int nextId = 0;
    private int score;
    private int steps;
    private int maxStepAllowed;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition){
        this.id = ++nextId;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed = -1; //For infinity maxstep
        this.map = map;
        this.position = initialPosition; //No treasure at initial position
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id = ++nextId;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed = maxStepAllowed;
        this.map = map;
        this.position = initialPosition; //No treasure at initial position
    }

    public int getId(){ return this.id; }
    public int getScore(){ return this.score; }
    public int getSteps(){ return this.steps; }
    public Position getPosition(){ return this.position; }

    public boolean move(Direction direction, int steps){
        int rowChange = direction.getRowChange();
        int colChange = direction.getColChange();

        for(; steps > 0; steps--){
            if((!this.map.isActive()) || this.map.isPositionInvalid(position,rowChange,colChange) || exceedMaxStep()){
                return false;
            }
            this.position.setRow(rowChange + this.position.getRow());
            this.position.setCol(colChange + this.position.getCol());
            int treasureFound = this.map.hasTreasure(this.position);

            if(treasureFound != 0){
                this.map.update(this.position);
            }
            
            this.score += treasureFound;
            this.steps++;
        }
        return true;
    }

    public boolean equals(Object player){
        Player p = (Player)player;
        return (this.id == p.getId());
    }

    public boolean exceedMaxStep(){
        return (this.maxStepAllowed >= 0 && this.steps >= this.maxStepAllowed);
    }
}
