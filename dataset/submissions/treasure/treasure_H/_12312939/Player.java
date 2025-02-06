public class Player {
    private static int increase = 0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
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
        return position;
    }
    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, -1);
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = ++increase;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
    }
    public boolean move(Direction direction, int steps) {
        if (!map.isActive() || (maxStepAllowed>0 && getSteps()>maxStepAllowed)) {
            return false;
        }
        Position newPosition = getPosition();
        if (direction == Direction.UP){
            newPosition.setRow(position.getRow() - steps);
        }
        if (direction == Direction.DONN){
            newPosition.setRow(position.getRow() + steps);
        }
        if (direction == Direction.RIGHT){
            newPosition.setCol(position.getCol() + steps);
        }
        if (direction == Direction.LEFT){
            newPosition.setCol(position.getCol() - steps);
        }
        if (newPosition.getRow() < 0) {
            newPosition.setRow(0);
            this.steps += position.getRow()- newPosition.getRow();
            this.position = newPosition;return false;
        }
        if (newPosition.getRow() >= map.getRows()) {
            newPosition.setRow(map.getRows()-1);
            this.steps -= position.getRow()- newPosition.getRow();
            this.position = newPosition;return false;
        }
        if (newPosition.getCol() < 0) {
            newPosition.setCol(0);
            this.steps += position.getCol()- newPosition.getCol();
            this.position = newPosition;
            return false;
        }
        if (newPosition.getCol() >= map.getColumns()) {
            newPosition.setRow(map.getColumns()-1);
            this.steps -= position.getCol()- newPosition.getCol();
            this.position = newPosition;return false;
        }
        int remainingSteps = steps;
        while (remainingSteps > 0 && map.hasTreasure(position)) {
            if (!map.update(position)) {
                break;
            }
            remainingSteps--;
        }
        if (remainingSteps > 0) {
            this.steps += remainingSteps;
            int newPositionRow=0;
            int newPositionCol=0;
            this.position = new Position(newPositionRow, newPositionCol);
            return true;
        } else {
            return false;
        }
    }
    public boolean equals(Object player) {
        Player other = (Player) player;
        return this.id == other.id;
    }
}
