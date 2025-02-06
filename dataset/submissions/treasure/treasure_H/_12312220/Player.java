public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int count = 0;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.steps = 0;
        this.score = 0;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.steps = 0;
        this.score = 0;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;

    }

    public boolean move(Direction direction, int steps) {
        if (this.map.isActive() && this.steps < maxStepAllowed) {
            switch (direction) {
                case UP:
                    if (this.position.getRow() - steps >= 0) {
                        for (int i = 0; i < steps; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setRow(this.position.getRow() - 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return true;
                    } else {
                        int temp = this.position.getRow();
                        for (int i = 0; i < temp; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setRow(this.position.getRow() - 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return false;
                    }
                case DOWN:
                    if (this.position.getRow() + steps < this.map.getRows()) {
                        for (int i = 0; i < steps; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setRow(this.position.getRow() + 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return true;
                    } else {
                        int temp = this.map.getRows() - 1 - this.position.getRow();
                        for (int i = 0; i < temp; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setRow(this.position.getRow() + 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return false;
                    }
                case LEFT:
                    if (this.position.getCol() - steps >= 0) {
                        for (int i = 0; i < steps; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setCol(this.position.getCol() - 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return true;
                    } else {
                        int temp = this.position.getCol();
                        for (int i = 0; i < temp; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setCol(this.position.getCol() - 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return false;
                    }
                case RIGHT:
                    if (this.position.getCol() + steps < this.map.getColumns()) {
                        for (int i = 0; i < steps; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setCol(this.position.getCol() + 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return true;
                    } else {
                        int temp = this.map.getColumns() - 1 - this.position.getCol();
                        for (int i = 0; i < temp; i++) {
                            if (this.steps + 1 > this.maxStepAllowed || !this.map.isActive()) {
                                return false;
                            } else {
                                this.position.setCol(this.position.getCol() + 1);
                                score += this.map.hasTreasure(this.position);
                                this.map.update(this.position);
                                this.steps += 1;
                            }
                        }
                        return false;
                    }
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return this.id == p.id;
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
    }

    
}
