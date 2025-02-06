public class Player {

    private final int id;

    private int score;

    private int steps;

    private Position position;

    private Map map;

    private static int count;

    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        count++;
        id = count;
        this.maxStepAllowed = 9999999;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.steps = 0;
        count++;
        id = count;
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

    public void setScore(int score) {
        this.score = score;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (this.steps == this.maxStepAllowed) {
            return false;
        }
        if ((direction.equals(Direction.RIGHT) && this.position.getCol() == map.getColumns() - 1) || (direction.equals(Direction.UP) && this.position.getRow() == 0) || (direction.equals(Direction.LEFT) && this.position.getCol() == 0) || (direction.equals(Direction.DOWN) && this.position.getRow() == map.getRows() - 1)) {
            return false;
        }
        for (int i = 0; i < steps; i++) {
            if ((direction.equals(Direction.RIGHT) && this.position.getCol() == map.getColumns() - 1) || (direction.equals(Direction.UP) && this.position.getRow() == 0) || (direction.equals(Direction.LEFT) && this.position.getCol() == 0) || (direction.equals(Direction.DOWN) && this.position.getRow() == map.getRows() - 1)) {
                return false;
            } else {
                if (this.steps == this.maxStepAllowed) {
                    return false;
                }
                if (!map.isActive()) {
                    return false;
                }
                if (direction.equals(Direction.RIGHT)) {
                    this.position.setCol(Math.min(this.position.getCol() + 1, map.getColumns() - 1));
                    this.score += this.map.hasTreasure(this.position);
                    this.steps++;
                    this.map.update(this.position);
                } else if (direction.equals(Direction.UP)) {
                    this.position.setRow(Math.max(this.position.getRow() - 1, 0));
                    this.score += this.map.hasTreasure(this.position);
                    this.steps++;
                    this.map.update(this.position);
                } else if (direction.equals(Direction.LEFT)) {
                    this.position.setCol(Math.max(this.position.getCol() - 1, 0));
                    this.score += this.map.hasTreasure(this.position);
                    this.steps++;
                    this.map.update(this.position);
                } else if (direction.equals(Direction.DOWN)) {
                    this.position.setRow(Math.min(this.position.getRow() + 1, map.getRows() - 1));
                    this.score += this.map.hasTreasure(this.position);
                    this.steps++;
                    this.map.update(this.position);
                }

            }

        }
        return true;
    }

    public boolean equals(Object player) {
        Player player1 = (Player) player;
        if (this.id == player1.id) {
            return true;
        } else {
            return false;
        }
    }

}
