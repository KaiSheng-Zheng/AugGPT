public class Player {
    private static int idCounter = 1;

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPos) {
        this.id = idCounter++;
        this.score = 0;
        this.steps = 0;
        this.map = map;
        this.position = initialPos;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPos, int maxStepAllowed) {
        this.id = idCounter++;
        this.score = 0;
        this.steps = 0;
        this.position = initialPos;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
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

    public Map getMap() {
        return map;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive() || steps <= 0 || maxStepAllowed <= 0 || this.steps == maxStepAllowed) {
            return false;
        }

        int newRow = position.getRow();
        int newCol = position.getCol();
        switch (direction) {
            case UP -> {
                for (int i = 0; i < steps; i++) {
                    if (newRow == 0 || this.steps == maxStepAllowed) {
                        return false;
                    }
                    newRow -= 1;
                    this.steps += 1;
                    position.setRow(newRow);
                    int treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                        if (!map.isActive()&&i!=steps-1){
                            return false;
                        }
                    }
                }
            }
            case DOWN -> {
                for (int i = 0; i < steps; i++) {
                    if (newRow == map.getRows() - 1 || this.steps == maxStepAllowed) {
                        return false;
                    }
                    newRow += 1;
                    this.steps += 1;
                    position.setRow(newRow);
                    int treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                        if (!map.isActive()&&i!=steps-1){
                            return false;
                        }
                    }
                }
            }
            case LEFT -> {
                for (int i = 0; i < steps; i++) {
                    if (newCol == 0 || this.steps == maxStepAllowed ) {
                        return false;
                    }
                    newCol -= 1;
                    this.steps += 1;
                    position.setCol(newCol);
                    int treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                        if (!map.isActive()&&i!=steps-1){
                            return false;
                        }
                    }
                }
            }
            case RIGHT -> {
                for (int i = 0; i < steps; i++) {
                    if (newCol == map.getColumns() - 1 || this.steps == maxStepAllowed) {
                        return false;
                    }
                    newCol += 1;
                    this.steps += 1;
                    position.setCol(newCol);
                    int treasureScore = map.hasTreasure(position);
                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(position);
                        if (!map.isActive()&&i!=steps-1){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return id == p.id;
    }
}
