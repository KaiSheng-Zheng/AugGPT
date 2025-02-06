public class Player implements Comparable<Player> {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int count;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.position = initialPosition;
        this.map = map;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        int row = position.getRow();
        int col = position.getCol();
        int row1 = map.getRows();
        int col1 = map.getColumns();
        for (int i = 0; i < steps; i++) {
            if (this.steps + 1 > maxStepAllowed) {
                return false;
            }
            if (!map.isActive()) {
                return false;
            }
            if (direction == Direction.UP) {
                row--;
            }
            if (direction == Direction.DOWN) {
                row++;
            }
            if (direction == Direction.LEFT) {
                col--;
            }
            if (direction == Direction.RIGHT) {
                col++;
            }
            if (row > (row1 - 1) || col > (col1 - 1) || row < 0 || col < 0) {
                return false;
            }
            Position p1 = new Position(row, col);
            this.position = new Position(row, col);
            this.steps++;
            if (map.hasTreasure(p1) != 0) {
                score += map.hasTreasure(p1);
                map.update(p1);
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        if (player.getClass() == this.getClass()) {
            Player p = (Player) player;
            return this.id == p.id;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int compareTo(Player other) {
        if (this.getScore() != other.getScore()) {
            return this.getScore() - other.getScore();
        } else {
            return other.getSteps() - this.getSteps();
        }
    }

    public int getId() {
        return id;
    }
}
