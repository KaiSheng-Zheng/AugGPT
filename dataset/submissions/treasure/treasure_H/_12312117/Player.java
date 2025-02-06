public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;

    private Map map;
    private static int idCount = 0;
    private int maxStepAllowed;
    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, -1);
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = ++idCount;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
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


    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }else {
        int newRow = position.getRow();
        int newCol = position.getCol();
        switch (direction) {
            case UP:
                newRow -= steps;
                break;
            case DOWN:
                newRow += steps;
                break;
            case LEFT:
                newCol -= steps;
                break;
            case RIGHT:
                newCol += steps;
                break;
        }
        if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
            return false;
        }
            int remainingSteps = getMaxStepAllowed() - this.steps;
            int actualSteps = Math.min(steps, remainingSteps);
            if (actualSteps <= 0) {
                return false;
            }
        if (newRow + actualSteps >= map.getRows() ) {
            actualSteps = map.getRows()  - newRow - 1;
        }
        if (newCol + actualSteps >= map.getColumns()) {
            actualSteps = map.getColumns() - newCol - 1;
        }
        position.setRow(newRow + actualSteps);
        position.setCol(newCol + actualSteps);
        int treasureScore = map.hasTreasure(position);

            score += treasureScore;
            map.update(position);

        this.steps += actualSteps;
        return true;}
    }

    public boolean equals(Object player) {
        if (player instanceof Player) {
            Player otherPlayer = (Player) player;
            return this.id == otherPlayer.getId();
        }
        return false;
    }
}