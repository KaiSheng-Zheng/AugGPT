public class Player {
    private final int id;
    private int score;
    private int steps;
    private int maxStepAllowed = -999;
    private Position position;
    private Map map;
    private static int players = 0;
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
    public Player(Map map, Position position) {
        players++;
        this.id = players;
        this.map = map;
        this.position = position;
    }
    public Player(Map map, Position position, int maxStepAllowed) {
        players++;
        this.id = players;
        this.map = map;
        this.position = position;
        this.maxStepAllowed = maxStepAllowed;
    }
    public boolean onTheBoundary(Direction direction) {
        switch (direction) {
            case UP: return this.position.getRow() == 0;
            case DOWN: return this.position.getRow() == this.map.getRows() - 1;
            case LEFT: return this.position.getCol() == 0;
            case RIGHT: return this.position.getCol() == this.map.getColumns() - 1;
        }
        return false;
    }
    public boolean haveSteps() {
        if (this.maxStepAllowed == -999) return true;
        else return this.steps < this.maxStepAllowed;
    }
    public boolean move(Direction direction, int steps) {
        while (steps > 0) {
            if (!this.map.isActive() || onTheBoundary(direction) || !haveSteps()) return false;
            switch (direction) {
                case UP: {
                    this.position.setRow(this.position.getRow() - 1);
                    if (this.map.hasTreasure(this.position) != 0) {
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                    }
                    this.steps++;
                    steps--;
                    continue;
                }
                case DOWN: {
                    this.position.setRow(this.position.getRow() + 1);
                    if (this.map.hasTreasure(this.position) != 0) {
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                    }
                    this.steps++;
                    steps--;
                    continue;
                }
                case LEFT: {
                    this.position.setCol(this.position.getCol() - 1);
                    if (this.map.hasTreasure(this.position) != 0) {
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                    }
                    this.steps++;
                    steps--;
                    continue;
                }
                case RIGHT: {
                    this.position.setCol(this.position.getCol() + 1);
                    if (this.map.hasTreasure(this.position) != 0) {
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                    }
                    this.steps++;
                    steps--;
                }
            }
        }
        return true;
    }
    public boolean equals(Object player) {
        Player p = (Player) player;
        return p.getId() == this.id;
    }
}
