public class Player{
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, -1);
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = generateUniqueId();
        this.score = 0;
        this.steps = 0;
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

    public Position getPosition() {
        return position;
    }

    public Map getMap() {
        return map;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }

        int remainingSteps = steps;
        while (remainingSteps > 0) {
            if (maxStepAllowed >= 0 && this.steps >= maxStepAllowed) {
                return false;
            }

            Position newPosition = calculateNewPosition(direction, this.position);
            if (!isValidPosition(newPosition)) {
                return false;
            }

            this.position = newPosition;
            this.steps++;
            remainingSteps--;
        }

        return true;
    }

    public boolean equals(Object player) {
        if (player instanceof Player) {
            Player p = (Player) player;
            return this.id == p.getId();
        }
        return false;
    }

    private static int nextPlayerId = 1;

    private static int generateUniqueId() {
        return nextPlayerId++;
    }

    private Position calculateNewPosition(Direction direction, Position currentPosition) {
        int newRow = currentPosition.getRow();
        int newCol = currentPosition.getCol();

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

        return new Position(newRow, newCol);
    }

    private boolean isValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();

        return row >= 0 && row < map.getRows() && col >= 0 && col < map.getColumns();
    }

}
