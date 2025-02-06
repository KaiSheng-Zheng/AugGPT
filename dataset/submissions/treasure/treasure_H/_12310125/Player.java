public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    static int count = 0;
    private int maxStepAllowed;
    int step = 0;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.id = ++count;
        this.maxStepAllowed = -1;

    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        int row = position.getRow();
        int col = position.getCol();

        switch (direction) {
            case UP -> {
                for (int i = 0; i < steps; i++) {
                    row -= 1;
                    step++;
                    if (!map.getisActive()||(step > maxStepAllowed && maxStepAllowed != -1) || row < 0 || row >= map.getRows() || col < 0 || col >= map.getColumns()) {
                        row += 1;
                        step--;
                        position.setCol(col);
                        position.setRow(row);
                        map.update(position);
                        return false;
                    } else {
                        position.setCol(col);
                        position.setRow(row);

                        score = score + map.hasTreasure(position);
                        map.update(position);

                    }
                }
            }
            case DOWN -> {
                for (int i = 0; i < steps; i++) {
                    row += 1;
                    step++;
                    if (!map.getisActive()||(step > maxStepAllowed && maxStepAllowed != -1) || row < 0 || row >= map.getRows() || col < 0 || col >= map.getColumns()) {
                        row -= 1;
                        step--;
                        position.setCol(col);
                        position.setRow(row);
                        map.update(position);
                        return false;
                    } else {
                        position.setCol(col);
                        position.setRow(row);
                        score = score + map.hasTreasure(position);
                        map.update(position);

                    }
                }
            }
            case LEFT -> {
                for (int i = 0; i < steps; i++) {
                    col -= 1;
                    step++;
                    if (!map.getisActive()||(step > maxStepAllowed && maxStepAllowed != -1) || row < 0 || row >= map.getRows() || col < 0 || col >= map.getColumns()) {
                        col += 1;
                        step--;
                        position.setCol(col);
                        position.setRow(row);
                        map.update(position);
                        return false;
                    } else {
                        position.setCol(col);
                        position.setRow(row);

                        score = score + map.hasTreasure(position);
                        map.update(position);

                    }
                }
            }
            case RIGHT -> {
                for (int i = 0; i < steps; i++) {
                    col += 1;
                    step++;
                    if (!map.getisActive()||(step > maxStepAllowed && maxStepAllowed != -1) || row < 0 || row >= map.getRows() || col < 0 || col >= map.getColumns()) {
                        col -= 1;
                        step--;
                        position.setCol(col);
                        position.setRow(row);
                        map.update(position);
                        return false;
                    } else {
                        position.setCol(col);
                        position.setRow(row);
                        score = score + map.hasTreasure(position);
                        map.update(position);

                    }
                }
            }
        }
        return true;

    }

    public boolean equals(Object player) {
        if (player instanceof Player) {
            Player p = (Player) player;
            return this.id == p.getId();
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return step;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

}
