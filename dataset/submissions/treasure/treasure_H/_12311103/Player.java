public class Player {
    public static int ids = 1;
    private final int id = ids;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = 9999999;

    public Player(Map map, Position initialPosition) {
        ids++;
        this.map = map;
        this.position = initialPosition;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        ids++;
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        int count = this.steps + steps;
        switch (direction) {
            case UP -> {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getRow() > 0 &&
                            this.steps < this.maxStepAllowed && map.isActive()) {
                        this.position.UP();
                        this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                    }
                }
            }
            case DOWN -> {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getRow() < map.getRows() - 1 &&
                            this.steps < this.maxStepAllowed && map.isActive()) {
                        this.position.DOWN();
                        this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                    }
                }
            }
            case LEFT -> {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getCol() > 0 &&
                            this.steps < this.maxStepAllowed && map.isActive()) {
                        this.position.LEFT();
                        this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                    }
                }
            }
            case RIGHT -> {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getCol() < map.getColumns() - 1 &&
                            this.steps < this.maxStepAllowed && map.isActive()) {
                        this.position.RIGHT();
                        this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                    }
                }
            }
            default -> {
            }
        }
        return (this.steps == count);
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return p.getId() == this.id;
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
}