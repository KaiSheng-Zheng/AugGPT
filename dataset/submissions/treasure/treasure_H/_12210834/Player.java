public class Player {
    private static int nextId = 1;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private boolean ifLimited;
    private int maxStepAllowed;
    public Player(Map map, Position initialPosition) {
        this.id = generateUniqueId();
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.ifLimited = false;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = generateUniqueId();
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.ifLimited = true;
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
        if (!map.isActive() || steps <= 0 || (ifLimited && maxStepAllowed == 0)) {
            return false;
        }

        int newRow = position.getRow();
        int newCol = position.getCol();

        switch (direction) {
            case UP -> {
                while (steps > 0 && newRow > 0) {
                    newRow--;
                    steps--;
                    Position newPosition = new Position(newRow, newCol);
                    int treasureScore = map.hasTreasure(newPosition);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(newPosition);
                    }
                    this.steps++;
                    if (map.allTreasuresFound()) break;
                    if (this.ifLimited) {
                        maxStepAllowed--;
                        if (maxStepAllowed == 0) break;
                    }
                }
            }
            case DOWN -> {
                while (steps > 0 && newRow < map.getRows() - 1) {
                    newRow++;
                    steps--;
                    Position newPosition = new Position(newRow, newCol);
                    int treasureScore = map.hasTreasure(newPosition);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(newPosition);
                    }
                    this.steps++;
                    if (map.allTreasuresFound()) break;
                    if (this.ifLimited) {
                        maxStepAllowed--;
                        if (maxStepAllowed == 0) break;
                    }
                }
            }
            case LEFT -> {
                while (steps > 0 && newCol > 0) {
                    newCol--;
                    steps--;
                    Position newPosition = new Position(newRow, newCol);
                    int treasureScore = map.hasTreasure(newPosition);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(newPosition);
                    }
                    this.steps++;
                    if (map.allTreasuresFound()) break;
                    if (this.ifLimited) {
                        maxStepAllowed--;
                        if (maxStepAllowed == 0) break;
                    }
                }
            }
            case RIGHT -> {
                while (steps > 0 && newCol < map.getColumns() - 1) {
                    newCol++;
                    steps--;
                    Position newPosition = new Position(newRow, newCol);
                    int treasureScore = map.hasTreasure(newPosition);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(newPosition);
                    }
                    this.steps++;
                    if (map.allTreasuresFound()) break;
                    if (this.ifLimited) {
                        maxStepAllowed--;
                        if (maxStepAllowed == 0) break;
                    }
                }
            }
        }
        this.position = new Position(newRow, newCol);
        return(steps == 0);
    }

    public boolean equals(Object player) {
        if (this == player) {
            return true;
        }
        if (player == null || getClass() != player.getClass()) {
            return false;
        }
        Player other = (Player) player;
        return id == other.getId();
    }

    private static int generateUniqueId() {
        return nextId++;
    }
}
