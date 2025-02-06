public class Player {

    private static int count;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.id = ++count;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = 0x7fffffff;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = ++count;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
    }


    public boolean move(Direction direction, int steps) {
        for (int step = 0; step < steps; step++) {
            if (!map.isActive() || this.steps == maxStepAllowed)
                return false;
            switch (direction) {
                case UP:
                    if (position.getRow() == 0)
                        return false;
                    position.setRow(position.getRow() - 1);
                    break;
                case DOWN:
                    if (position.getRow() == map.getRows() - 1)
                        return false;
                    position.setRow(position.getRow() + 1);
                    break;
                case LEFT:
                    if (position.getCol() == 0)
                        return false;
                    position.setCol(position.getCol() - 1);
                    break;
                case RIGHT:
                    if (position.getCol() == map.getColumns() - 1)
                        return false;
                    position.setCol(position.getCol() + 1);
                    break;
            }
            ++this.steps;
            int v = map.hasTreasure(position);
            score += v;
            map.update(position);
        }
        return true;
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

    public boolean equals(Object player) {
        return player instanceof Player && getId() == ((Player) player).getId();
    }
}

enum Direction {UP, DOWN, LEFT, RIGHT}
