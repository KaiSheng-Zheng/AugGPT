public class Player {
    private final int id;
    private static int nextId = 1;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private final int maxStepAllowed;
    private boolean isactive = true;

    public Player(Map map, Position initialPosition) {
        this.id = nextId;
        nextId++;
        this.score = 0;
        this.steps = 0;
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = -1;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = nextId++;
        this.score = 0;
        this.steps = 0;
        this.map = map;
        this.position = initialPosition;
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

    public Map getMap() {
        return map;
    }

    public boolean move(Direction direction, int steps) {






        for (int i = 0; i < steps; i++) {
            if (!map.isActive()) {
            return false;
        }

            if (maxStepAllowed >= 0 && this.steps >= maxStepAllowed) {
                return false;
            }

            Position newPosition = calculateNewPosition(direction, 1);


            if (!isValidPosition(newPosition)) {

                return false;
            }


            this.position = newPosition;
            this.steps++;


            int treasureScore = map.hasTreasure(newPosition);

            if (treasureScore > 0) {
                score += treasureScore;
                map.update(newPosition);
            }
        }

        return true;
    }

    private Position calculateNewPosition(Direction direction, int steps) {

        int Row = position.getRow();
        int Col = position.getCol();

        switch (direction) {
            case UP:
                Row -= steps;
                break;
            case DOWN:
                Row += steps;
                break;
            case LEFT:
                Col -= steps;
                break;
            case RIGHT:
                Col += steps;
                break;
        }

        return new Position(Row, Col);
    }

    private boolean isValidPosition(Position newPosition) {
        
        return newPosition.getRow() >= 0 && newPosition.getRow() < map.getRows()
                && newPosition.getCol() >= 0 && newPosition.getCol() < map.getColumns();
    }

    @Override
    public boolean equals(Object player) {

        Player p = (Player) player;
        return this.id == p.getId();
    }

    public void setScore(int i) {
        this.score = score;
    }

    public void setSteps(int i) {
        this.steps = steps;
    }
}
