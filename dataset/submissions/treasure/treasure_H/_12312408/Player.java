public class Player {
    private final int id;
    private static int idCounter = 1;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition){
        id = idCounter++;
        this.map = map;
        position = initialPosition;
        this.score = 0;
        this.steps = 0;
        maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id = idCounter++;
        this.map = map;
        position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.score = 0;
        this.steps = 0;
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
        if (!map.isActive() || isOnBoundary(direction)) {
            return false;
        }
        else {
            switch (direction) {
                case UP:
                    while (steps > 0 && position.getRow() > 0 && this.steps < maxStepAllowed && map.isActive()) {
                        this.steps++;
                        position.setRow(position.getRow() - 1);
                        steps--;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    }
                    break;
                case DOWN:
                    while (steps > 0 && position.getRow() < map.getRows() - 1 && this.steps < maxStepAllowed && map.isActive()) {
                        this.steps++;
                        position.setRow(position.getRow() + 1);
                        steps--;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    }
                    break;
                case LEFT:
                    while (steps > 0 && position.getCol() > 0 && this.steps < maxStepAllowed && map.isActive()) {
                        this.steps++;
                        position.setCol(position.getCol() - 1);
                        steps--;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    }
                    break;
                case RIGHT:
                    while (steps > 0 && position.getCol() < map.getColumns() - 1 && this.steps < maxStepAllowed && map.isActive()) {
                        this.steps++;
                        position.setCol(position.getCol() + 1);
                        steps--;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    }
                    break;
            }
            return steps == 0;
        }
    }
    public boolean isOnBoundary(Direction direction){
        switch (direction){
            case DOWN:
                if (position.getRow() == map.getRows() - 1){
                    return true;
                }
                return false;
            case UP:
                if (position.getRow() == 0){
                    return true;
                }
                return false;
            case LEFT:
                if (position.getCol() == 0){
                    return true;
                }
                return false;
            case RIGHT:
                if (position.getCol() == map.getColumns() - 1){
                    return true;
                }
                return false;
        }
        return true;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.getId() == ((Player) this).getId()){
            return true;
        }
        return false;
    }
}
