public class Player {
    private static int idCounter = 0;
    private final Map map;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private int maxStepsAllowed = Integer.MAX_VALUE;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        id = ++idCounter;
    }

    public Player(Map map, Position initialPosition, int maxStepsAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStepsAllowed = maxStepsAllowed;
        id = ++idCounter;
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
        if (steps > maxStepsAllowed) {
            return false;
        }
        if (!map.isActive()) {
            return false;
        }
        int origin_row = position.getRow();
        int origin_col = position.getCol();
        boolean check = true;
        switch (direction) {
            case RIGHT:
                if (position.getCol() + steps >= map.getColumns()) {
                    check = false;
                } else if (this.steps + steps > maxStepsAllowed) {
                    check = false;
                }
                // check if there is a treasure
                if (map.getTreasures() != null) {
                    int route;
                    if (check) route = steps;
                    else if (this.steps + steps > maxStepsAllowed) route = maxStepsAllowed - this.steps;
                    else route = map.getColumns() - 1 - origin_col;
                    for (int i = 1; i <= route; i++) {
                        int index = map.hasTreasure(new Position(position.getRow(), position.getCol() + i));
                        if (index != 0) {
                            score += index;
                            map.update(new Position(position.getRow(), position.getCol() + i));
                        }
                        this.steps++;
                        if (map.getTreasures() == null) {
                            this.position.setCol(position.getCol() + i);
                            break;
                        }
                    }
                    if (map.getTreasures() != null) this.position.setCol(position.getCol() + route);
                } else check = false;
                break;
            case LEFT:
                if (position.getCol() - steps < 0) {
                    check = false;
                } else if (this.steps + steps > maxStepsAllowed) {
                    check = false;
                }
                // check if there is a treasure
                if (map.getTreasures() != null) {
                    int route;
                    if (check) route = steps;
                    else if (this.steps + steps > maxStepsAllowed) route = maxStepsAllowed - this.steps;
                    else route = origin_col;
                    for (int i = 1; i <= route; i++) {
                        int index = map.hasTreasure(new Position(position.getRow(), position.getCol() - i));
                        if (index != 0) {
                            score += index;
                            map.update(new Position(position.getRow(), position.getCol() - i));
                        }
                        this.steps++;
                        if (map.getTreasures() == null) {
                            this.position.setCol(position.getCol() - i);
                            break;
                        }
                    }
                    if (map.getTreasures() != null) this.position.setCol(position.getCol() - route);
                } else check = false;
                break;
            case UP:
                if (position.getRow() - steps < 0) {
                    check = false;
                } else if (this.steps + steps > maxStepsAllowed) {
                    check = false;
                }
                // check if there is a treasure
                if (map.getTreasures() != null) {
                    int route;
                    if (check) route = steps;
                    else if (this.steps + steps > maxStepsAllowed) route = maxStepsAllowed - this.steps;
                    else route = origin_row;
                    for (int i = 1; i <= route; i++) {
                        int index = map.hasTreasure(new Position(position.getRow() - i, position.getCol()));
                        if (index != 0) {
                            score += index;
                            map.update(new Position(position.getRow() - i, position.getCol()));
                        }
                        this.steps++;
                        if (map.getTreasures() == null) {
                            this.position.setRow(position.getRow() - i);
                            break;
                        }
                    }
                    if (map.getTreasures() != null) this.position.setRow(position.getRow() - route);
                } else check = false;
                break;
            case DOWN:
                if (position.getRow() + steps >= map.getRows()) {
                    check = false;
                } else if (this.steps + steps > maxStepsAllowed) {
                    check = false;
                }
                // check if there is a treasure
                if (map.getTreasures() != null) {
                    int route;
                    if (check) route = steps;
                    else if (this.steps + steps > maxStepsAllowed) route = maxStepsAllowed - this.steps;
                    else route = map.getRows() - 1 - origin_row;
                    for (int i = 1; i <= route; i++) {
                        int index = map.hasTreasure(new Position(position.getRow() + i, position.getCol()));
                        if (index != 0) {
                            score += index;
                            map.update(new Position(position.getRow() + i, position.getCol()));
                        }
                        this.steps++;
                        if (map.getTreasures() == null) {
                            this.position.setRow(position.getRow() + i);
                            break;
                        }
                    }
                    if (map.getTreasures() != null) this.position.setRow(position.getRow() + route);
                } else check = false;
                break;
        }

        return check;
    }

    public boolean equals(Object player) {
        if (player instanceof Player p) {
            return p.getPosition() == position;
        }
        return false;
    }
}
