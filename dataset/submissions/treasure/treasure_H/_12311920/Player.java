public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private final int maxStepAllowed;
    private static int id_number = 0;
    private static int step_number = 0;
    private int step_id;

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = -1;
        score = map.hasTreasure(position);
        map.update(position);
        id = id_number;
        id_number++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        score = map.hasTreasure(position);
        map.update(position);
        id = id_number;
        id_number++;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMap(Map map) {
        this.map = map;
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

    public boolean move(Direction direction, int steps){
        boolean key = false;
        for (int step = 0; step < steps; step++) {
            key = go(direction, steps);
            if (key == false){
                return key;
            }
        }
        return key;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return p.getId() == id;
    }

    private boolean go(Direction direction, int steps){
            if (map.isActive() == false){
            return false;
        }
        else if (position.getRow() + direction.add_row < 0 || position.getRow() + direction.add_row >= map.getRows() || position.getCol() + direction.add_col < 0 || position.getCol() + direction.add_col >= map.getColumns()) {
            return false;
        }
        else if (maxStepAllowed >= 0 && this.steps >= maxStepAllowed){
            return false;
        }
        this.position.setRow(this.position.getRow() + direction.add_row);
        this.position.setCol(this.position.getCol() + direction.add_col);
        score += map.hasTreasure(position);
        map.update(position);
        this.steps++;
        step_number++;
        step_id = step_number;
        return true;
    }
}
