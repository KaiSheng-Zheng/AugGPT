
public class Player {
    private static int count = 0;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = Integer.MAX_VALUE;

    public Player(Map map, Position initialPosition) {
        this.id = count++ + 1;
        this.position = initialPosition;
        this.map = map;


    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = count++ + 1;
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
        return this.position;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) return false;
        switch (direction) {
            case UP:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    Position newPosition = new Position(this.position.getRow() - 1, this.position.getCol());
                    if (isValidMovement(newPosition)) return false;
                }
                return true;
            case DOWN:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    Position newPosition = new Position(this.position.getRow() + 1, this.position.getCol());
                    if (isValidMovement(newPosition)) return false;
                }
                return true;
            case LEFT:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    Position newPosition = new Position(this.position.getRow(), this.position.getCol() - 1);
                    if (isValidMovement(newPosition)) return false;
                }
                return true;
            case RIGHT:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    Position newPosition = new Position(this.position.getRow(), this.position.getCol() + 1);
                    if (isValidMovement(newPosition)) return false;
                }
                return true;
            default:
                return false;
        }
    }

    private boolean isValidMovement(Position newPosition) {
        if (map.isValidPosition(newPosition) && this.steps < maxStepAllowed) {
            this.position = newPosition;
            this.steps++;
            score += map.hasTreasure(this.position);
            map.update(this.position);
        } else {
            return true;
        }
        return false;
    }

    public boolean equals(Object player) {
        return this.getId() == ((Player) player).getId();
    }
}
