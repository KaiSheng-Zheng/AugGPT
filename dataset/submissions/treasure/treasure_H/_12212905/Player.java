
public class Player {
    private static int count = 0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private final Map map;
    private final int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, Integer.MAX_VALUE);
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = count++;
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

    public boolean move(Direction direction, int steps) {
        if (!map.isActive() || this.steps >= maxStepAllowed) {
            return false;
        }

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

        if (isValidMove(newRow, newCol)) {
            this.steps += steps;
            position = new Position(newRow, newCol);
            int treasureScore = map.hasTreasure(position);
            if (treasureScore > 0) {
                score += treasureScore;
                map.update(position);
            }
            return true;
        }

        return false;
    }

    private boolean isValidMove(int newRow, int newCol) {
        if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
            return false;
        }

        return true;
    }
    public boolean equals(Object player) {
        if (this == player) {
            return true;
        }
        if (player == null || getClass() != player.getClass()) {
            return false;
        }
        Player other = (Player) player;
        return this.id == other.id;
    }

}
