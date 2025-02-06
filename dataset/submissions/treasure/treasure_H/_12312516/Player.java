public class Player {
    static int counter =0;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = -1;

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
        this.map = map;
        position = initialPosition;
        id=++counter;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        position = initialPosition;
        id=++counter;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        if (!(map.isActive())) return false;
        else {
            if ((this.steps + steps <= maxStepAllowed && maxStepAllowed >= 0) || maxStepAllowed == -1) {
                if (position.getCol() + direction.getCol() * steps > (map.getColumns() - 1)) {
                    for (int i = position.getCol()+1; i < map.getColumns(); i++) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(position.getRow(), i));
                        map.update(new Position(position.getRow(), i));
                        this.steps++;
                        position.setCol(position.getCol() + 1);
                    }
                    return false;
                }
                if (position.getCol() + direction.getCol() * steps < 0) {
                    for (int i = position.getCol()-1; i >= 0; i--) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(position.getRow(), i));
                        map.update(new Position(position.getRow(), i));
                        this.steps++;
                        position.setCol(position.getCol() - 1);
                    }
                    return false;
                }
                if (position.getRow() + direction.getRow() * steps > map.getRows() - 1) {
                    for (int i = position.getRow()+1; i < map.getRows(); i++) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(i, position.getCol()));
                        map.update(new Position(i, position.getCol()));
                        this.steps++;
                        position.setRow(position.getRow() + 1);
                    }
                    return false;
                }
                if (position.getRow() + direction.getRow() * steps < 0) {
                    for (int i = position.getRow()-1; i >= 0; i--) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(i, position.getCol()));
                        map.update(new Position(i, position.getCol()));
                        this.steps++;
                        position.setRow(position.getRow() - 1);
                    }
                    return false;
                } else {
                    for (int i = 1; i <= steps; i++) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(position.getRow() + direction.getRow(), position.getCol() + direction.getCol()));
                        map.update(new Position(position.getRow() + direction.getRow(), position.getCol() + direction.getCol()));
                        this.steps++;
                        position.setRow(position.getRow() + direction.getRow());
                        position.setCol(position.getCol() + direction.getCol());
                    }
                    return true;
                }
            } else {
                if (position.getCol() + direction.getCol() * (maxStepAllowed - this.steps) > map.getColumns() - 1) {
                    for (int i = position.getCol()+1; i < map.getColumns(); i++) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(position.getRow(), i));
                        map.update(new Position(position.getRow(), i));
                        this.steps++;
                        position.setCol(position.getCol() + 1);
                    }
                }
                if (position.getCol() + direction.getCol() * (maxStepAllowed - this.steps) < 0) {
                    for (int i = position.getCol()-1; i >= 0; i--) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(position.getRow(), i));
                        map.update(new Position(position.getRow(), i));
                        this.steps++;
                        position.setCol(position.getCol() - 1);
                    }
                }
                if (position.getRow() + direction.getRow() * (maxStepAllowed - this.steps) > map.getRows() - 1) {
                    for (int i = position.getRow()+1; i < map.getRows(); i++) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(i, position.getCol()));
                        map.update(new Position(i, position.getCol()));
                        this.steps++;
                        position.setRow(position.getRow() + 1);
                    }
                }
                if (position.getRow() + direction.getRow() * (maxStepAllowed - this.steps) < 0) {
                    for (int i = position.getRow()-1; i >= 0; i--) {
                        if (!(map.isActive())) break;
                        score += map.hasTreasure(new Position(i, position.getCol()));
                        map.update(new Position(i, position.getCol()));
                        this.steps++;
                        position.setRow(position.getRow() - 1);
                    }
                } else {
                    int difference=maxStepAllowed-this.steps;
                    for (int i = 1; i <=difference; i++) {
                        if(!(map.isActive()))break;
                        score += map.hasTreasure(new Position(position.getRow() + direction.getRow(), position.getCol() + direction.getCol()));
                        map.update(new Position(position.getRow() + direction.getRow(), position.getCol() + direction.getCol()));
                        this.steps++;
                        position.setRow(position.getRow() + direction.getRow());
                        position.setCol(position.getCol() + direction.getCol());
                    }
                }
                return false;
            }
        }
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return this.id == p.getId();
    }
}
