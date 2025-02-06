public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int count = 0;

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
        for (int i = 1; i <= steps; i++) {
            if (this.steps == maxStepAllowed) {
                return false;
            }
            if (map.isActive() == false) {
                return false;
            } else if (position.getRow() == 0 && direction == Direction.UP) {
                return false;
            } else if (position.getRow() == map.getRows() - 1 && direction == Direction.DOWN) {
                return false;
            } else if (position.getCol() == 0 && direction == Direction.LEFT) {
                return false;
            } else if (position.getCol() == map.getColumns() - 1 && direction == Direction.RIGHT) {
                return false;
            } else if (this.steps == maxStepAllowed) {
                return false;
            } else {
                this.steps++;
                switch (direction) {
                    case UP:
                        this.position.setRow(position.getRow() - 1);
                        break;
                    case DOWN:
                        this.position.setRow(position.getRow() + 1);
                        break;
                    case LEFT:
                        this.position.setCol(position.getCol() - 1);
                        break;
                    case RIGHT:
                        this.position.setCol(position.getCol() + 1);
                        break;
                }
                score += map.hasTreasure(position);
                map.update(position);

            }
        }
        return true;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return this.id == p.id;
    }


    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
