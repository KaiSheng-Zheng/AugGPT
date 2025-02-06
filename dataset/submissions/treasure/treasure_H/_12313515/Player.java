public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int count=0;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.id=++count;
        this.maxStepAllowed=Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.id=++count;
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps) {
        if(!map.isActive()){
            return false;
        }
        int realRow=position.getRow();
        int realCol=position.getCol();
        for (int i = 0; i < steps; i++) {
            if (direction == Direction.UP) {
                if (this.steps ==maxStepAllowed) return false;
                if (realRow == 0) return false;
                realRow--;
            }
            else if (direction == Direction.DOWN) {
                if (this.steps == maxStepAllowed) return false;
                if (realRow == map.getRows()-1) return false;
                realRow++;
            }
                else if (direction == Direction.LEFT) {
                if (this.steps ==maxStepAllowed) return false;
                if (realCol == 0) return false;
                realCol--;
            }
            else if (direction == Direction.RIGHT) {
                if (this.steps == maxStepAllowed) return false;
                if (realCol == map.getColumns()-1) return false;
                realCol++;
            }
            position = new Position(realRow, realCol);
            this.steps++;
            this.score+=map.hasTreasure(position);
            map.update(new Position(realRow,realCol));
            if (!map.isActive() && this.steps < maxStepAllowed) {
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        return this.id==p.id;
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

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

