
public class Player {
    static private int nextId = 0;

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private Integer maxStepAllowed = null; // Optional maximum steps

    // Constructor without maxStepAllowed
    public Player(Map map, Position initialPosition) {
        this.id = nextId;
        nextId++;
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
    }

    // Constructor with maxStepAllowed
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map, initialPosition);
        this.maxStepAllowed = maxStepAllowed;
    }

    // Getters
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

    private void takeTreasure(int newRow, int newCol) {
        Position newPosition = new Position(newRow, newCol);
        if (!newPosition.equals(position)) {
            position = newPosition;
            int treasureScore = map.hasTreasure(position);
            if (treasureScore > 0) {
                score += treasureScore;
                map.update(position); // Remove the treasure from the map
            }
            this.steps += 1; // Increment only the number of steps actually moved
        }
    }

    // Move method
    public boolean move(Direction direction, int stepCount) {
        if (!map.isActive() || (maxStepAllowed != null && this.steps >= maxStepAllowed)) {
            return false; // Map inactive or max steps exceeded
        }

        int newRow = position.getRow();
        int newCol = position.getCol();
        int stepsMoved = 0;

        while (map.isActive() && stepsMoved < stepCount && (maxStepAllowed == null || this.steps < maxStepAllowed)) {
            boolean breakout = false;
            if (direction == Direction.UP) {
                if (newRow - 1 < 0) {
                    break; // Hit boundary, stop moving
                } else {
                    newRow--;
                }
            } else if (direction == Direction.DOWN) {
                if (newRow + 1 >= map.getRows()) {
                    break; // Hit boundary, stop moving
                } else {
                    newRow++;
                }
            } else if (direction == Direction.LEFT) {
                if (newCol - 1 < 0) {
                    break; // Hit boundary, stop moving
                } else {
                    newCol--;
                }
            } else if (direction == Direction.RIGHT) {
                if (newCol + 1 >= map.getColumns()) {
                    break; // Hit boundary, stop moving
                } else {
                    newCol++;
                }
            }
            stepsMoved++; // Decrement stepsToMove after each iteration
            takeTreasure(newRow, newCol);
        }


        if (stepsMoved == stepCount) {
            return true;
        }
        return false; // Return false if the position didn't change
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return id == player.id;
    }
}
