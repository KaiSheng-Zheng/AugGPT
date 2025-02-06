public class Player {
    private static int ID_COUNTER = 0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private  int maxStepAllowed;
    public Player(Map map, Position initialPosition){
        this.id = ID_COUNTER++;
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed =0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id = ID_COUNTER++;
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed =maxStepAllowed;
        this.score = 0;
        this.steps = 0;
    }
    public int getId() {
        return id;
    }
    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        int newRow = position.getRow();
        int newCol = position.getCol();
        if(maxStepAllowed != 0) {
            int remainingSteps = Math.min(steps, maxStepAllowed - this.steps);
            if (remainingSteps <= 0) {
                return false;
            }
            for (int i = 0; i < remainingSteps; i++) {
                int originalRow = newRow;
                int originalCol = newCol;
                switch (direction) {
                    case UP:
                        newRow--;
                        break;
                    case DOWN:
                        newRow++;
                        break;
                    case LEFT:
                        newCol--;
                        break;
                    case RIGHT:
                        newCol++;
                        break;
                }
                position.setRow(newRow);
                position.setCol(newCol);
                int treasureScore = map.hasTreasure(position);
                if (treasureScore > 0) {
                    score += treasureScore;
                    map.update(position);
                }
                if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
                    this.steps += i ;
                    position.setRow(originalRow);
                    position.setCol(originalCol);
                    return false;
                }
            }
            this.steps += remainingSteps;
            return true;
        }else {
            for (int i = 0; i < steps; i++) {
                int originalRow = newRow;
                int originalCol = newCol;
                switch (direction) {
                    case UP:
                        newRow--;
                        break;
                    case DOWN:
                        newRow++;
                        break;
                    case LEFT:
                        newCol--;
                        break;
                    case RIGHT:
                        newCol++;
                        break;
                }
                position.setRow(newRow);
                position.setCol(newCol);
                int treasureScore = map.hasTreasure(position);
                if (treasureScore > 0) {
                    score += treasureScore;
                    map.update(position);
                }
                if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
                    this.steps += i;
                    position.setRow(originalRow);
                    position.setCol(originalCol);
                    return false;
                }
            }
            this.steps += steps;
            return true;
        }
    }
    public int getSteps() {
        return steps;
    }
    public int getScore() {

        return score;
    }
    public Position getPosition() {
        return position;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if (this.id == p.getId()){
            return true;
        }
        return false;
    }

}
