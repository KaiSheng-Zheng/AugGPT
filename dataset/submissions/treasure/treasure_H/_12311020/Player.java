public class Player {
    private final int id;
    private static int n = 1;
    private int score = 0;
    private int steps;
    private Position position;
    private Map map;
    private Direction direction;
    private int maxStepsAllowed = 999999;
    private int totalSteps = 0;

    public Player(Map map, Position initialposition) {
        this.position = initialposition;
        this.map = map;
        this.id = n;
        n += 1;
    }

    public Player(Map map, Position initialposition, int maxStepsAllowed) {
        this.position = initialposition;
        this.map = map;
        this.id = n;
        this.maxStepsAllowed = maxStepsAllowed;
        n += 1;
    }

    public Map getMap() {
        return map;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return totalSteps;
    }

    public void setScore(int score) {
        this.score = score + this.score;
    }

    public Position getPosition() {
        return position;
    }

    public boolean equals(Object player) {
        Player playerGiven = (Player) player;
        if (this.id == playerGiven.getId()) return true;
        else return false;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (totalSteps == maxStepsAllowed) {
            return false;
        }
        if (direction.equals(Direction.UP)) {
            if (position.getRow() >= steps) {
                for (int i = 0; i < steps; i++) {
                    if (totalSteps == maxStepsAllowed) {
                        return false;
                    }if (!map.isActive()) {
                        return false;
                    }
                    up(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return true;
            } else {
                for (int i = position.getRow(); i > 0; i--) {
                    if (totalSteps == maxStepsAllowed) {
                        return false;
                    }if (!map.isActive()) {
                        return false;
                    }
                    up(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return false;
            }
        }
        if (direction.equals(Direction.DOWN)) {
            if (map.getRows() - 1 - position.getRow() >= steps) {
                for (int i = 0; i < steps; i++) {
                    if (getSteps() == maxStepsAllowed) {
                        return false;
                    }if (!map.isActive()) {
                        return false;
                    }
                    down(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return true;
            } else {
                for (int i = position.getRow(); i < map.getRows() - 1; i++) {
                    if (getSteps() == maxStepsAllowed) {
                        return false;
                    }if (!map.isActive()) {
                        return false;
                    }
                    down(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return false;
            }
        }
        if (direction.equals(Direction.LEFT)) {
            if (position.getCol() >= steps) {
                for (int i = 0; i < steps; i++) {
                    if (getSteps() == maxStepsAllowed) {
                        return false;
                    }if (!map.isActive()) {
                        return false;
                    }
                    left(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return true;
            } else {
                for (int i = position.getCol(); i > 0; i--) {
                    if (totalSteps == maxStepsAllowed) {
                        return false;
                    }if (!map.isActive()) {
                        return false;
                    }
                    left(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return false;
            }
        }
        if (direction.equals(Direction.RIGHT)) {
            if (map.getColumns() - 1 - position.getCol() >= steps) {
                for (int i = 0; i < steps; i++) {
                    if (getSteps() == maxStepsAllowed) {
                        return false;
                    } if (!map.isActive()) {
                        return false;
                    }
                    right(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return true;
            } else {
                for (int i = position.getCol() + 1; i < map.getColumns(); i++) {
                    if (totalSteps == maxStepsAllowed) {
                        return false;
                    }if (!map.isActive()) {
                        return false;
                    }
                    right(position);
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                }
                return false;
            }
        }
        return false;
    }

    public void left(Position position) {
        position.setCol(position.getCol() - 1);
        totalSteps += 1;
    }

    public void right(Position position) {
        position.setCol(position.getCol() + 1);
        totalSteps += 1;
    }

    public void up(Position position) {
        position.setRow(position.getRow() - 1);
        totalSteps += 1;
    }

    public void down(Position position) {
        position.setRow(position.getRow() + 1);
        totalSteps += 1;
    }
}



