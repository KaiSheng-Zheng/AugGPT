public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position pos;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPos) {
        this.id = generateUniqueId();
        this.map = map;
        this.pos = initialPos;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed = -1; // Default value indicating unlimited steps
    }

    public Player(Map map, Position initialPos, int maxStepAllowed) {
        this(map, initialPos);
        this.maxStepAllowed = maxStepAllowed;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPos() {
        return pos;
    }

    public boolean move(Position direction, int steps) {
        if (!map.isActive()) {
            return false;
        }

        if (maxStepAllowed != -1 && this.steps + steps > maxStepAllowed) {
            return false;
        }

        for (int i = 0; i < steps; i++) {
            Position newPos = calculateNewPosition(Direction.direction);
            if (!isValidPosition(newPos)) {
                return false;
            }
            this.pos = newPos;
            this.steps++;
        }
        return true;
    }

    private Position calculateNewPosition(Position direction) {
        int newRow = pos.getRow();
        int newCol = pos.getCol();

        if(Direction.UP) {
            newRow--;
        }if (Direction.DOWN) {
            newRow++;
        }if (Direction.LEFT){
            newCol--;
        }if (Direction.RIGHT){
            newCol++;
        }
        return new Position(newRow, newCol);
    }

    private boolean isValidPosition(Position newPos) {
        return newPos.getRow() >= 0 && newPos.getRow() < map.getRows() &&
                newPos.getCol() >= 0 && newPos.getCol() < map.getColumns();
    }

    public boolean equals(Object player) {
        if (player instanceof Player) {
            return this.id == ((Player) player).getId();
        }
        return false;
    }

    private static int uniqueId = 0;

    private int generateUniqueId() {
        return uniqueId++;
    }
}
