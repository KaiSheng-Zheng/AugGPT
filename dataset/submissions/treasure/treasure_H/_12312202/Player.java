public class Player {
    private static int tot;
    private final int id = ++tot;
    private int score;
    private int steps;
    private Position position;
    private final int maxsteps;
    private Map map;

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

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.maxsteps = -1;
        this.steps = 0;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxsteps = maxStepAllowed;
        this.steps = 0;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) return false;
        int x = position.getRow();
        int y = position.getCol();
        switch (direction) {
            case UP -> {
                for (int i = 1; i <= steps; i++) {
                    if (this.steps == maxsteps) return false;
                    if (!map.isActive()) return false;
                    if (x - 1 < 0) return false;
                    int now = map.hasTreasure(new Position(x - 1, y));
                    score += now;
                    if (now != 0) map.update(new Position(x - 1, y));
                    this.steps++;
                    position.setRow(--x);
                }
            }
            case DOWN -> {
                for (int i = 1; i <= steps; i++) {
                    if (this.steps == maxsteps) return false;
                    if (!map.isActive()) return false;
                    if (x + 1 >= map.getRows()) return false;
                    int now = map.hasTreasure(new Position(x + 1, y));
                    score += now;
                    if (now != 0) map.update(new Position(x + 1, y));
                    this.steps++;
                    position.setRow(++x);
                }
            }
            case LEFT -> {
                for (int i = 1; i <= steps; i++) {
                    if (this.steps == maxsteps) return false;
                    if (!map.isActive()) return false;
                    if (y - 1 < 0) return false;
                    int now = map.hasTreasure(new Position(x, y - 1));
                    score += now;
                    if (now != 0) map.update(new Position(x, y - 1));
                    this.steps++;
                    position.setCol(--y);
                }
            }
            case RIGHT -> {
                for (int i = 1; i <= steps; i++) {
                    if (this.steps == maxsteps) return false;
                    if (!map.isActive()) return false;
                    if (y + 1 >= map.getColumns()) return false;
                    int now = map.hasTreasure(new Position(x, y + 1));
                    score += now;
                    if (now != 0) map.update(new Position(x, y + 1));
                    this.steps++;
                    position.setCol(++y);
                }
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        Player temp = (Player) player;
        if (temp.id == this.id) return true;
        return false;
    }
}
