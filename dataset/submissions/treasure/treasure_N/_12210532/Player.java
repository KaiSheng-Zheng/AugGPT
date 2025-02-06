import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private final Map map;

    private final int maxStepAllowed;

    public Player(Map map, Position initialPos) {
        this(map, initialPos, Integer.MAX_VALUE);
    }

    public Player(Map map, Position initialPos, int maxStepAllowed) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.map = map;
        this.position = initialPos;
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

    public boolean move(Direction direction, int stepsToMove) {
        if (!map.isActive()) {
            return false;
        }
        int newRow = position.getRow();
        int newCol = position.getCol();
        for (int i = 0; i < stepsToMove; i++) {
            if (this.steps >= this.maxStepAllowed) {
                return false;
            }
            switch (direction) {
                case UP:
                    if (newRow == 0) return false;
                    newRow--;
                    break;
                case DOWN:
                    if (newRow == map.getRows() - 1) return false;
                    newRow++;
                    break;
                case LEFT:
                    if (newCol == 0) return false;
                    newCol--;
                    break;
                case RIGHT:
                    if (newCol == map.getColumns() - 1) return false;
                    newCol++;
                    break;
            }

            position = new Position(newRow, newCol);
            this.steps++;

            int treasureScore = map.hasTreasure(new Position(newRow, newCol));
            if (treasureScore > 0) {
                this.score += treasureScore;
                map.update(new Position(newRow, newCol));
                if(!map.isActive()&&steps<maxStepAllowed) {
                    return false;
                }
            }
        }
        return true;
    }





    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return id == player.id;
    }
}
