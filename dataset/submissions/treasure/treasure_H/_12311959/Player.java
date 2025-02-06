import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private final Map map;
    private final int maxStepAllowed;

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = idGenerator.incrementAndGet();
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed = maxStepAllowed;
    }

    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, Integer.MAX_VALUE);
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive() || this.steps + steps > maxStepAllowed) {
            return false;
        }

        int newRow = position.getRow();
        int newCol = position.getCol();

        switch (direction) {
            case UP -> newRow -= steps;
            case DOWN -> newRow += steps;
            case LEFT -> newCol -= steps;
            case RIGHT -> newCol += steps;
        }

        if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
            return false;
        }

        Position newPosition = new Position(newRow, newCol);
        this.position = newPosition;
        this.steps += steps;

        int treasureScore = map.hasTreasure(newPosition);
        if (treasureScore > 0) {
            score += treasureScore;
            map.update(newPosition);
        }

        return true;
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

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return id == player.id;
    }
}
