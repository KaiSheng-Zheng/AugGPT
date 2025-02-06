public class Player {
    private final int id = this.hashCode();
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = -1;
        this.steps = 0;
        this.score = 0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.steps = 0;
        this.score = 0;
    }


    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public boolean move(Direction direction, int steps){
        this.map.setActive(this.map.checkActive(map.getTreasures()));
        if (maxStepAllowed == -1){//2 fields constructor
            return moveToNextPosition(direction,steps);
        }
        //3 fields constructor
        else if (maxStepAllowed == 0) {
            return false;
        }
        else {
            if (this.steps < maxStepAllowed){
                return moveToNextPosition(direction,steps);
            }
            else {return false;}
        }
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if (this == p){return true;}
        else {return false;}
    }

    public void Operation(Direction direction,Position position){
        switch (direction){
            case UP: {position.setRow(position.getRow() - 1);break;}
            case DOWN: {position.setRow(position.getRow() + 1);break;}
            case LEFT: {position.setCol(position.getCol() - 1);break;}
            case RIGHT: {position.setCol(position.getCol() + 1);break;}
        }
    }

    public boolean moveToNextPosition(Direction direction,int steps){//maxSteps > 0 and steps < maxStepAllowed / no maxSteps
        for (int i = 0; i < steps; i++) {//complete steps
            if (map.isActive()){
                Position tempPosition = new Position(position.getRow(),position.getCol());//check if next step causes out of boundary
                Operation(direction,tempPosition);
                if ((tempPosition.getRow() >= 0 && tempPosition.getRow() <= this.map.getRows() - 1) &&
                        (tempPosition.getCol() >= 0 && tempPosition.getCol() <= this.map.getColumns() - 1)){
                    if (maxStepAllowed == -1){this.steps++;}
                    else {
                        if (this.steps < maxStepAllowed){this.steps++;}
                        else {return false;}
                    }
                    Operation(direction,this.position);
                    score += map.hasTreasure(position);
                    map.update(position);
                    this.map.setActive(this.map.checkActive(map.getTreasures()));
                }
                else {return false;}
            }
            else {return false;}
        }
        return true;
    }
}