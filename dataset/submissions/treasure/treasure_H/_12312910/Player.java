public class Player {
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = 999999999;
    private int stepAllowed = 999999;
    private static int counter = 0;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        id = counter;
        counter++;
        this.steps = 0;
        this.score = 0;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.stepAllowed = this.maxStepAllowed;
        id = counter;
        counter++;
    }

    public Player(int id, int score, int steps, Position position, Map map, int maxStepAllowed, int stepAllowed) {
        this.id = id;
        this.score = score;
        this.steps = steps;
        this.position = position;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
        this.stepAllowed = stepAllowed;
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

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
        this.stepAllowed = this.maxStepAllowed;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Player.counter = counter;
    }

    public int getStepAllowed() {
        return stepAllowed;
    }

    public void setStepAllowed(int stepAllowed) {
        this.stepAllowed = stepAllowed;
    }

    public boolean move(Direction direction, int step) {
        switch (Direction.toString(direction)) {
            case "UP":
                for (int i = 0; i < step; i++) {
                    if (this.position.getRow() == 0) {
                        return false;
                    } else if (!this.map.isActive()) {
                        return false;
                    } else if (this.getStepAllowed() <= 0) {
                        return false;
                    } else {
                        this.position.setRow(this.position.getRow() - 1);
                        this.steps++;
                        this.stepAllowed--;
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.getPosition());
                    }
                }
                return true;
            case "DOWN":
                for (int i = 0; i < step; i++) {
                    if (this.position.getRow() == this.map.getRows() - 1) {
                        return false;
                    } else if (!this.map.isActive()) {
                        return false;
                    } else if (this.getStepAllowed() <= 0) {
                        return false;
                    } else {
                        this.position.setRow(this.position.getRow() + 1);
                        this.steps++;
                        this.stepAllowed--;
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.getPosition());
                    }
                }
                return true;
            case "LEFT":
                for (int i = 0; i < step; i++) {
                    if (this.position.getCol() == 0) {
                        return false;
                    } else if (!this.map.isActive()) {
                        return false;
                    } else if (this.getStepAllowed() <= 0) {
                        return false;
                    } else {
                        this.position.setCol(this.position.getCol() - 1);
                        this.steps++;
                        this.stepAllowed--;
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.getPosition());
                    }
                }
                return true;
            case "RIGHT":
                for (int i = 0; i < step; i++) {
                    if (this.position.getCol() == this.map.getColumns() - 1) {
                        return false;
                    } else if (!this.map.isActive()) {
                        return false;
                    } else if (this.getStepAllowed() <= 0) {
                        return false;
                    } else {
                        this.position.setCol(this.position.getCol() + 1);
                        this.steps++;
                        this.stepAllowed--;
                        this.score += this.map.hasTreasure(this.position);
                        this.map.update(this.getPosition());
                    }
                }
                return true;
            default:
                return false;
        }
    }
    @Override
    public boolean equals(Object player) {
        Player p = (Player) player;
        return this.id == p.getId();
    }
}