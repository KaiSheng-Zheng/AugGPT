public class Player {
    private static int num = 1;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int MaxStep;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = num;
        this.MaxStep = -1;
        num++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.MaxStep = maxStepAllowed;
        this.id = num;
        num++;
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

    public int getId() {
        return id;
    }


    public boolean move(Direction direction, int steps) {
        if (map.isActive() && this.steps <= MaxStep) {
            switch (direction) {
                case UP -> {
                    for (int i = 0; i < steps; i++) {
                        if (position.getRow() - 1 >= 0 && map.isActive() && (this.steps + 1 <= MaxStep || MaxStep == -1)) {
                            position.setRow(position.getRow() - 1);
                            this.steps++;
                            score += map.hasTreasure(position);
                            map.update(position);
                        }
                    }
                }
                case DOWN -> {
                    for (int i = 0; i < steps; i++) {
                        if (position.getRow() + 1 <= map.getRows() && map.isActive() && (this.steps + 1 <= MaxStep || MaxStep == -1)) {
                            position.setRow(position.getRow() + 1);
                            this.steps++;
                            score += map.hasTreasure(position);
                            map.update(position);
                        }
                    }
                }
                case LEFT -> {
                    for (int i = 0; i < steps; i++) {
                        if (position.getCol() - 1 >= 0 && map.isActive() && (this.steps + 1 <= MaxStep || MaxStep == -1)) {
                            position.setCol(position.getCol() - 1);
                            this.steps++;
                            score += map.hasTreasure(position);
                            map.update(position);
                        }
                    }
                }
                case RIGHT -> {
                    for (int i = 0; i < steps; i++) {
                        if (position.getCol() + 1 <= map.getColumns() && map.isActive() && (this.steps + 1 <= MaxStep || MaxStep == -1)) {
                            position.setCol(position.getCol() + 1);
                            this.steps++;
                            score += map.hasTreasure(position);
                            map.update(position);
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Player player) {
        return this.id == player.id;
    }
}