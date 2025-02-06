
public class Player {
    private final int id;
    private static int nextId = 1;
    private int score ;
    private int steps ;
    private Position position;
    private Map map;
    private int maxStepAllowed = Integer.MAX_VALUE;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = nextId++;
        this.score=0;
        this.steps=0;
    }

    public Player(Map map, Position position, int maxStepAllowed) {
        this.map = map;
        this.position = position;
        this.maxStepAllowed = maxStepAllowed;
        this.id = nextId++;
        this.score=0;
        this.steps=0;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }

        for (int i = 0; i < steps; i++) {
            if (isMaxStepsReached()) {
                break;
            }

            Position newPosition = calculateNewPosition(direction);
            if (!map.isValidPosition(newPosition)) {
                return false;
            }

            position = newPosition;
            this.steps++;
            int treasureScore = map.hasTreasure(position);
            if (treasureScore > 0) {
                this.score += treasureScore;
                map.update(position);
            }
           if (this.steps == maxStepAllowed) {
                break;
            }
        }

        return false;
    }
    public boolean equals(Object player) {
        if (this == player) {
            return true;
        }
        if (!(player instanceof Player)) {
            return false;
        }
        Player otherPlayer = (Player) player;
        return id == otherPlayer.id;
    }
    private boolean isMaxStepsReached() {
        return this.steps == maxStepAllowed;
    }

    public Position getPosition() {
        return position;
    }

    public int getSteps() {
        return steps;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public void resetScore() {
        score = 0;
    }

    public void resetSteps() {
        steps = 0;
    }

    private int generateUniqueId() {
        return 0;
    }

    private Position calculateNewPosition(Direction direction) {
        int newY = position.getCol();
        int newX = position.getRow();

        switch (direction) {
            case UP:
                newX--;
                break;
            case DOWN:
                newX++;
                break;
            case LEFT:
                newY--;
                break;
            case RIGHT:
                newY++;
                break;
        }

        return new Position(newX, newY);
    }
}
