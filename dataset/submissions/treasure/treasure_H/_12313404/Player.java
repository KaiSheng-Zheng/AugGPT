import java.util.Random;

public class Player {

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private final int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, Integer.MAX_VALUE);
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        id = new Random().nextInt();
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        for (var i = 0; i < steps; i++) {
            if (!map.isActive()) {
                return false;
            }
            var newPos = position.updatePos(direction, map);
            if (newPos == null) {
                return false;
            }
            if (this.steps >= maxStepAllowed) {
                return false;
            }
            position = newPos;
            this.steps++;
            score += map.hasTreasure(position);
            map.update(position);
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
    public boolean equals(Object obj) {
        if (obj instanceof Player player) {
            return id == player.id;
        }
        return false;
    }
}
