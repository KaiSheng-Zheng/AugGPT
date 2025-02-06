public class Player {
    private static int count = 0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player (Map map, Position initialPosition) {
        id = ++count;
        score = 0;
        steps = 0;
    //    Position a = new Position(initialPosition.getRow(), initialPosition.getCol());
        position = initialPosition;
        this.map = map;
        maxStepAllowed = Integer.MAX_VALUE;
    }
    public Player (Map map, Position initialPosition, int maxStepAllowed) {
        id = ++count;
        score = 0;
        steps = 0;
    //    Position a = new Position(initialPosition.getRow(), initialPosition.getCol());
        position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
    }

    public int getId () {
        return id;
    }

    public int getScore () {
        return score;
    }

    public int getSteps () {
        return steps;
    }

    public Position getPosition () {
        return position;
    }

    public boolean move (Direction direction, int steps) {
        if (!map.isActive()) return false;
        int dx = 0;
        int dy = 0;
        switch (direction) {
            case UP : {
                dx = -1;
            //    dy = 0;
                break;
            }
            case DOWN: {
                dx = 1;
            //    dy = 0;
                break;
            }
            case LEFT: {
            //    dx = 0;
                dy = -1;
                break;
            }
            case RIGHT: {
            //    dx = 0;
                dy = 1;
                break;
            }
        }

        while (steps > 0) {
            if (!map.isActive()) return false;
            if (maxStepAllowed == 0) return false;
            int tx = position.getRow() + dx;
            int ty = position.getCol() + dy;
            if (tx < 0 || tx >= map.getRows() || ty < 0 || ty >= map.getColumns()) {
                return false;
            }
            position.setRow(tx);
            position.setCol(ty);
            int getScore = map.hasTreasure(position);
            if (getScore > 0) {
                map.update(position);
                score += getScore;

            }
            this.steps++;
            steps--;
            maxStepAllowed--;
        }
        return true;
    }

    public boolean equals (Object player) {
        if (player == null) return false;
        if (!(player instanceof Player a)) return false;
        return a.id == id;
    }
}