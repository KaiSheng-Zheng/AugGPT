public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int count = 0;
    private int maxStepAllowed;

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
        this.position = initialPosition;
        this.map = map;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.position = initialPosition;
        this.map = map;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }


    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (this.steps >= maxStepAllowed) {
            return false;
        }
        switch (direction) {
            case UP: {
                for (int i = 1; i <= steps; i++) {
                    int newRow = position.getRow() - 1;
                    if (newRow < 0) {
                        return false;
                    }
                    if (this.steps >= maxStepAllowed) {
                        return false;
                    }
                    position.setRow(newRow);
                    this.steps += 1;
                    score += map.hasTreasure(position);
                    if (map.hasTreasure(position) > 0) {
                        map.update(position);
                    }
                    if (!map.isActive()) {
                        return false;
                    }
                }
                break;
            }
            case DOWN: {
                for (int i = 1; i <= steps; i++) {
                    int newRow = position.getRow() + 1;
                    if (newRow > map.getRows() - 1) {
                        return false;
                    }
                    if (this.steps >= maxStepAllowed) {
                        return false;
                    }
                    position.setRow(newRow);
                    this.steps += 1;
                    score += map.hasTreasure(position);
                    if (map.hasTreasure(position) > 0) {
                        map.update(position);
                    }
                    if (!map.isActive()) {
                        return false;
                    }
                }
                break;
            }
            case LEFT: {
                for (int i = 1; i <= steps; i++) {
                    int newColumn = position.getCol() - 1;
                    if (newColumn < 0) {
                        return false;
                    }
                    if (this.steps >= maxStepAllowed) {
                        return false;
                    }
                    position.setCol(newColumn);
                    this.steps += 1;
                    score += map.hasTreasure(position);
                    if (map.hasTreasure(position) > 0) {
                        map.update(position);
                    }
                    if (!map.isActive()) {
                        return false;
                    }
                }
                break;
            }
            case RIGHT: {
                for (int i = 1; i <= steps; i++) {
                    int newColumn = position.getCol() + 1;
                    if (newColumn > map.getColumns() - 1) {
                        return false;
                    }
                    if (this.steps >= maxStepAllowed) {
                        return false;
                    }
                    position.setCol(newColumn);
                    this.steps += 1;
                    score += map.hasTreasure(position);
                    if (map.hasTreasure(position) > 0) {
                        map.update(position);
                    }
                    if (!map.isActive()) {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        if (player == null) {
            return false;
        }
        Player p = (Player) player;
        if (id == p.id) {
            return true;
        } else {
            return false;
        }
    }
}
