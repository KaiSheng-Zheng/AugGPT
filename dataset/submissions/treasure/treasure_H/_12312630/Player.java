public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxstep = Integer.MAX_VALUE;
    static int count = 0;

    public Player(Map map, Position initialPosition) {
        this.id = ++count;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map, initialPosition);
        this.maxstep = maxStepAllowed;
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
        int newRow = position.getRow();
        int newCol = position.getCol();
        int treasureScore;

        switch (direction) {
            case UP -> {
                while (steps > 0) {
                    steps--;

                    if ((newRow - 1) < 0) return false;
                    if (this.steps + 1 > maxstep) return false;
                    if (!map.isActive()) return false;

                    newRow = newRow - 1;
                    this.steps++;
                    this.position.setRow(newRow);
                    treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                    }
                }
                return true;
            }
            case DOWN -> {
                while (steps > 0) {
                    steps--;
                    if ((newRow + 1) > map.getRows() - 1) return false;
                    if (this.steps + 1 > maxstep) return false;
                    if (!map.isActive()) return false;

                    newRow = newRow + 1;
                    this.steps++;
                    this.position.setRow(newRow);
                    treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                    }
                }
                return true;
            }
            case LEFT -> {
                while (steps > 0) {
                    steps--;
                    if ((newCol - 1) < 0) return false;
                    if (this.steps + 1 > maxstep) return false;
                    if (!map.isActive()) return false;
                    newCol = newCol - 1;
                    this.steps++;
                    this.position.setCol(newCol);
                    treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                    }
                }
                return true;
            }
            case RIGHT -> {
                while (steps > 0) {
                    steps--;
                    if ((newCol + 1) > map.getColumns() - 1) return false;
                    if (this.steps + 1 > maxstep) return false;
                    if (!map.isActive()) return false;

                    newCol = newCol + 1;
                    this.steps++;
                    this.position.setCol(newCol);
                    treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object player) {
            Player p = (Player) player;
            return id == p.getId();
    }
}
