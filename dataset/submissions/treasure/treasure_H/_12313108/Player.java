public class Player {
    private final int id;
    private int score;
    private int steps = 0;
    private Position position;
    private Map map;
    int maxStepAllowed;
    private static int count = 0;

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }

    public int getId() {
        return id;
    }

    public Player(Map map, Position initialPosition) {
        this.id = ++count;
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = -1;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ++count;
    }

    public boolean move(Direction direction, int steps) {
        switch (direction) {
            case UP:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    if (position.getRow() == 0 || this.steps == maxStepAllowed) return false;
                    position.setRow(position.getRow() - 1);
                    this.steps++;
                    score += map.hasTreasure(position);
                    map.update(position);
                    map.checkActive();
                }
                return true;
            case DOWN:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    if (position.getRow() == map.getRows() - 1 || this.steps == maxStepAllowed) return false;
                    position.setRow(position.getRow() + 1);
                    this.steps++;
                    score += map.hasTreasure(position);
                    map.update(position);
                    map.checkActive();
                }
                return true;
            case LEFT:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    if (position.getCol() == 0 || this.steps == maxStepAllowed) return  false;
                    position.setCol(position.getCol() - 1);
                    this.steps++;
                    score += map.hasTreasure(position);
                    map.update(position);
                    map.checkActive();
                }
                return true;
            case RIGHT:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) return false;
                    if (position.getCol() == map.getColumns() - 1 || this.steps == maxStepAllowed) return  false;
                    position.setCol(position.getCol() + 1);
                    this.steps++;
                    score += map.hasTreasure(position);
                    map.update(position);
                    map.checkActive();
                }
                return true;
        }
        return false;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        boolean row = position.getRow() == p.getPosition().getRow();
        boolean col = position.getCol() == p.getPosition().getCol();
        return row && col;
    }
}
