

public class Player {
    private static int curId = 1;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = Integer.MAX_VALUE;
    public Player(Map map, Position initialPosition){
        this.id = curId++;
        this.map = map;
        this.position = initialPosition;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this(map, initialPosition);
        // this.id = curId++;
        // this.map = map;
        // this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
    }
    public int getId() { return id; }
    public int getScore() { return score; }
    public int getSteps() { return steps; }
    public Position getPosition() { return position; }
    private Position nextPosition(Direction direction) {
        int newRow = this.position.getRow();
        int newCol = this.position.getCol();

        switch (direction) {
            case UP:
                newRow -= 1;
                break;
            case DOWN:
                newRow += 1;
                break;
            case LEFT:
                newCol -= 1;
                break;
            case RIGHT:
                newCol += 1;
                break;
        }

        return new Position(newRow, newCol);
    }
    public boolean move(Direction direction, int steps) {
        if (!map.isActive() || (this.steps >= maxStepAllowed)) {
            return false;
        }

        int cnt = 0;
        while (cnt < steps) {
            if (!map.isActive()) {
                return false;
            }
            Position nextPosition = nextPosition(direction);
            if (nextPosition.getRow() < 0 || nextPosition.getRow() >= map.getRows() ||
                    nextPosition.getCol() < 0 || nextPosition.getCol() >= map.getColumns()) {
                return false;
            }
            if (this.steps >= maxStepAllowed) {
                return false;
            }

            this.position = nextPosition;

            int treasureScore = map.hasTreasure(position);
            if (treasureScore > 0) {
                this.score += treasureScore;
                map.update(position);
            }

            cnt++;
            this.steps++;
        }

        return true;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if (this.id == p.id) {
            return true;
        } return false;
    }
}
