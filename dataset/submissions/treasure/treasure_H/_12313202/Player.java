public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    static private int cur = 0;

    public Player(Map map, Position initialPosition) {
        this.id = ++cur;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = 0x3f3f3f3f;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id = ++cur;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
    }

    public int getId() { return this.id; }

    public boolean move(Direction direction, int steps) {
        if(this.steps == this.maxStepAllowed) return false;
        if(!this.map.getIsActive()) return false;
        for(int i = 1; i <= steps; i++){
            if(this.steps == this.maxStepAllowed) return false;
            if(!this.map.isActive()) return false;
            int cx = this.position.getCol(), cy = this.position.getRow();
            if(direction == Direction.UP){
                if(cy == 0) return false;
                cy--;
                this.position.setRow(cy);
            }
            else if(direction == Direction.DOWN){
                if(cy == this.map.getRows()) return false;
                cy++;
                this.position.setRow(cy);
            }
            else if(direction == Direction.LEFT){
                if(cx == 0) return false;
                cx--;
                this.position.setCol(cx);
            }
            else{
                if(cx == this.map.getColumns()) return false;
                cx++;
                this.position.setCol(cx);
            }
            this.steps++;
            this.score += map.hasTreasure(this.position);
            this.map.update(this.position);
        }
        return true;
    }

    @Override
    public boolean equals(Object player){
        Player p = (Player) player;
        return p.getId() == this.id;
    }

    public int getScore() { return this.score; }
    public int getSteps() { return this.steps; }
    public Position getPosition() { return this.position; }
}

enum Direction {
    UP, DOWN, LEFT, RIGHT;
}