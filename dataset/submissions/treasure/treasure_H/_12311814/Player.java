public class Player {
    private static int currentId = 0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.id = currentId;
        currentId++;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = currentId;
        currentId++;
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

        for (int i = 0; i < steps; i++) {
            if (!this.map.isActive()) {
                return false;
            }
            // check boundary
            int posX = this.position.getRow() + direction.getRow();
            int posY = this.position.getCol() + direction.getCol();
            if (posX < 0 || posX >= this.map.getRows() || posY < 0 || posY >= this.map.getColumns()
                    || this.steps == this.maxStepAllowed) {
                return false;
            }
            // update position
            this.position = new Position(posX, posY);
            // update steps
            this.steps++;
            // update score
            this.score += this.map.hasTreasure(this.position);
            this.map.update(this.position);

        }
        return true;

    }

    public boolean equals(Object player) {
        if (player == null) {
            return false;
        }
        if (((Player) player).getId() == this.id) {
            return true;
        } else {
            return false;
        }
    }

}
