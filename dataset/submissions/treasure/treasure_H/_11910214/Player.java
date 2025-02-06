import java.security.UnresolvedPermission;

public class Player {
    private static int idCounter = 0;
    private final int id;
    private final int maxStepsAllowed;
    private int score;
    private int steps;
    private Position position;
    private final Map map;


    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, Integer.MAX_VALUE);
    }
    public Player(Map map, Position initialPosition, int maxStepsAllowed) {
        this.id = idCounter++;
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStepsAllowed = maxStepsAllowed;

        }

    // getters and setters

    Position newPosition = null;
    public boolean move(Direction direction, int steps) {

        if (direction == Direction.UP) {
            newPosition = new Position(position.getRow() - steps, position.getCol());
        }
        if (direction == Direction.DOWN) {
            newPosition = new Position(position.getRow() + steps, position.getCol());
        }
        if (direction == Direction.LEFT) {
            newPosition = new Position(position.getRow(), position.getCol() - steps);
        }
        if (direction == Direction.RIGHT) {
            newPosition = new Position(position.getRow(), position.getCol() + steps);
        }

        if (steps > maxStepsAllowed) {
            return false;
        }
        if (map.isValid(newPosition)) {
            position = newPosition;
            this.steps += steps;
            int score = map.hasTreasure(position);
            this.score += score;
            map.update(position);
            return true;
        }
        return false;
    }



    public boolean equals(Object player) {
        if (player instanceof Player p) {
            return this.id == p.id;
        }
        return false;
    }
    public int getId() { return id; }
    public int getScore() { return score; }
    public int getSteps() { return steps; }
    public Position getPosition() { return position; }
    public void setScore(int score) { this.score = score; }
    public void setSteps(int steps) { this.steps = steps; }
    public void setPosition(Position position) { this.position = position; }


}
