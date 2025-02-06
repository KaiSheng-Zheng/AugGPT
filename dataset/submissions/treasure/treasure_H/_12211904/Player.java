public class Player {
    private final int id;
    private static int num = 1;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private final int maxStep;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = num;
        this.maxStep = -1;
        num++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = num;
        this.maxStep = maxStepAllowed;
        num++;
    }

    public int getId() {
        return this.id;
    }

    public int getScore() {
        return this.score;
    }

    public int getSteps() {
        return this.steps;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean move(Direction direction, int steps) {
        int step = this.steps;
        switch (direction) {
            case UP: {
                for (int i = 0; i < steps; i++) {
                    if (position.getRow() - 1 >= 0 && map.isActive() && (this.steps + 1 <= maxStep || maxStep == -1)) {
                        position.setRow(position.getRow() - 1);
                        this.steps++;
                        score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }
                break;
            }
            case DOWN: {
                for (int i = 0; i < steps; i++) {
                    if (position.getRow() + 1 < map.getRows() && map.isActive() && (this.steps + 1 <= maxStep || maxStep == -1)) {
                        position.setRow(position.getRow() + 1);
                        this.steps++;
                        score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }
                break;
            }
            case LEFT: {
                for (int i = 0; i < steps; i++) {
                    if (position.getCol() - 1 >= 0 && map.isActive() && (this.steps + 1 <= maxStep || maxStep == -1)) {
                        position.setCol(position.getCol() - 1);
                        this.steps++;
                        score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }
                break;
            }
            case RIGHT: {
                for (int i = 0; i < steps; i++) {
                    if (position.getCol() + 1 < map.getColumns() && map.isActive() && (this.steps + 1 <= maxStep || maxStep == -1)) {
                        position.setCol(position.getCol() + 1);
                        this.steps++;
                        score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }
                break;
            }
        }
        if (step - this.steps != 0) {
            return true;
        } else return false;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        if (p.getId() == this.getId()) {
            return true;
        } else return false;
    }
}
