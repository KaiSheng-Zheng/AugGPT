public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    private static int num = 1;

    public int getId() {
        return this.id;
    }
    public int getScore() {
        return this.score;
    }
    public int getSteps() {
        return this.steps;
    }
    public Position getPosition() {
        return this.position;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id = num;
        num++;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
    }
    public Player(Map map, Position initialPosition){
        this.id = num;
        num++;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = -1;
    }

    public boolean move(Direction direction, int steps){
        for(int i = 1; i <= steps; i++) {
            if (this.steps >= this.maxStepAllowed && this.maxStepAllowed >= 0) {
                return false;
            }
            if (!this.map.getisActive()) {
                return false;
            }
            if (!this.movement(direction, 1)) {
                return false;
            }
            this.steps++;
            this.setPosition(this.ToStep(direction, 1));
            for (int ii = 0; ii < this.map.getTreasures().length; ii++) {
                if (this.position.equals(this.map.getTreasures()[ii].getPosition())){
                    if(map.getTreasures()[ii].getCheck() == 1) {
                        map.getTreasures()[ii].setCheck(0);
                        this.score += map.getTreasures()[ii].getScore();
                        this.map.update(this.position);
                    }
                    break;
                }
            }
        }
        return true;
    }

    public boolean movement(Direction direction, int steps){
        switch (direction) {
            case UP:
                if(this.ToStep(direction, steps).getRow() < 0)
                    return false;
                return true;
            case DOWN:
                if(this.ToStep(direction, steps).getRow() > this.map.getRows() - 1)
                    return false;
                return true;
            case LEFT:
                if(this.ToStep(direction, steps).getCol() < 0)
                    return false;
                return true;
            default:
                if(this.ToStep(direction, steps).getCol() > this.map.getColumns() - 1)
                    return false;
                return true;
        }
    }

    public Position ToStep(Direction direction, int steps){
        Position temp = new Position(0,0);
            switch (direction) {
                case UP:
                    temp.setRow(this.position.getRow() - steps);
                    temp.setCol(this.position.getCol());
                    break;
                case DOWN:
                    temp.setRow(this.position.getRow() + steps);
                    temp.setCol(this.position.getCol());
                    break;
                case LEFT:
                    temp.setRow(this.position.getRow());
                    temp.setCol(this.position.getCol() - steps);
                    break;
                default:
                    temp.setRow(this.position.getRow());
                    temp.setCol(this.position.getCol() + steps);
                    break;
            }
        return temp;
    }

    public boolean equals(Object player){
        Player temp = (Player) player;
        if(temp.getId() == this.getId()){
            return true;
        }
        return false;
    }
}