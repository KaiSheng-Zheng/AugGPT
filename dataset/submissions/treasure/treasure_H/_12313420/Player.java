public class Player {
    private final int id;
    private int score;
    private int steps = 0;
    private Position position;
    private Map map;
    private static int count = 0;
    private int maxStepAllowed = -1;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        boolean judge = true;
        if (map.isActive() == false) {
            judge = false;
        }
        if (maxStepAllowed == 0) {
            judge = false;
        } else {
            if (judgeBoundary(position, direction, steps, map) == false) {
                setPosition(hitBoundary(position, direction, map));
                judge = false;
            } else {
                setPosition(afterMove(position, direction, steps));
            }
        }
        if (maxStepAllowed > 0 && this.steps == maxStepAllowed) {
            judge = false;
        }

        return judge;
    }

    public boolean equals(Object player) {
        Player targetPlayer = (Player) player;
        if (targetPlayer.id == this.id) {
            return true;
        } else {
            return false;
        }
    }

    public Position afterMove(Position position, Direction direction, int steps) {
        Position afterMove = new Position(position.getRow(), position.getCol());
        if (maxStepAllowed > 0 && maxStepAllowed - this.steps < steps) {
            steps = maxStepAllowed - this.steps;
        }
        switch (direction) {
            case UP:
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setRow(position.getRow() - i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setRow(position.getRow() + i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
            case LEFT:
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setCol(position.getCol() - i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setCol(position.getCol() + i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
        }
        return afterMove;
    }

    public Position hitBoundary(Position position, Direction direction, Map map) {
        Position afterMove = new Position(position.getRow(), position.getCol());
        int steps;
        switch (direction) {
            case UP:
                steps = position.getRow();
                if (maxStepAllowed > 0 && maxStepAllowed - this.steps < steps) {
                    steps = maxStepAllowed - this.steps;
                }
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setRow(position.getRow() - i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
            case DOWN:
                steps = map.getRows() - position.getRow() - 1;
                if (maxStepAllowed > 0 && maxStepAllowed - this.steps < steps) {
                    steps = maxStepAllowed - this.steps;
                }
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setRow(position.getRow() + i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
            case LEFT:
                steps = position.getCol();
                if (maxStepAllowed > 0 && maxStepAllowed - this.steps < steps) {
                    steps = maxStepAllowed - this.steps;
                }
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setCol(position.getCol() - i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
            case RIGHT:
                steps = map.getColumns() - position.getCol() - 1;
                if (maxStepAllowed > 0 && maxStepAllowed - this.steps < steps) {
                    steps = maxStepAllowed - this.steps;
                }
                for (int i = 0; i <= steps; i++) {
                    if (getMap().isActive() == true) {
                        afterMove.setCol(position.getCol() + i);
                        this.score = this.score + map.hasTreasure(afterMove);
                        map.update(afterMove);
                        if (i != 0) {
                            this.steps++;
                        }
                    }
                }
                break;
        }
        return afterMove;
    }

    public static boolean judgeBoundary(Position position, Direction direction, int steps, Map map) {
        switch (direction) {
            case UP:
                if ((position.getRow() - steps) < 0) {
                    return false;
                }
                break;
            case DOWN:
                if ((position.getRow() + steps) >= map.getRows()) {
                    return false;
                }
                break;
            case LEFT:
                if ((position.getCol() - steps) < 0) {
                    return false;
                }
                break;
            case RIGHT:
                if ((position.getCol() + steps) >= map.getColumns()) {
                    return false;
                }
                break;
        }
        return true;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Player.count = count;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }
}