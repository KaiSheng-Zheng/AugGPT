public class Player {
    private static int cnt = 0;
    private final int id;
    private int score;
    private int steps;
    private int maxStep;
    private Position position;
    private Map map;
    public Player(Map map, Position initialPosition){
        ++cnt;
        this.id = cnt;
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStep = 1 << 30;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        ++cnt;
        this.id = cnt;
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStep = maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        if(!this.map.isActive())
            return false;
        int dX, dY;
        if(direction == Direction.DOWN){
            dX = 1;
            dY = 0;
        }
        else if(direction == Direction.UP){
            dX = -1;
            dY = 0;
        }
        else if(direction == Direction.LEFT){
            dX = 0;
            dY = -1;
        }
        else{
            dX = 0;
            dY = 1;
        }
        while(steps > 0){
            if(this.steps == this.maxStep){
                return false;
            }
            Position nxt = new Position(this.position.getRow() + dX, this.position.getCol() + dY);
            if(nxt.getRow() < 0)
                return false;
            if(nxt.getCol() < 0)
                return false;
            if(nxt.getRow() >= this.map.getRows())
                return false;
            if(nxt.getCol() >= this.map.getColumns())
                return false;
            this.position.setRow(nxt.getRow());
            this.position.setCol(nxt.getCol());
            if(this.map.hasTreasure(this.position) > 0){
                this.score += this.map.hasTreasure(this.position);
                this.map.update(this.position);
            }
            steps -= 1;
            this.steps += 1;
            if(steps == 0) 
                return true;
            if(!this.map.isActive())
                return false;
        }
        return true;
    }
    public int getId(){
        return this.id;
    }
    public int getScore(){
        return this.score;
    }
    public int getSteps(){
        return this.steps;
    }
    public Position getPosition(){
        return this.position;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return p.id == this.id;
    }
}
