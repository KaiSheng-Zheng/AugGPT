public class Player {
    private final int id;
    private static int temp = 0;
    private int score;// the current scores of the player

    private int steps;
    private int maxStepAllowed;
    private Position position;//the current position of the player
    //remember that multiple players can be the same position at the same time
    private Map map;
    //the current map player own

    public Player(Map map, Position position) {
        this.map = map;
        this.position = position;
        this.score = 0;
        this.steps = 0;
        id = temp++;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position position, int maxStepAllowed) {
        this(map, position);
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

    public boolean move(Direction direction, int steps) {

        if (this.steps + steps > maxStepAllowed){
            for (int i = 0; i < steps&&this.steps < this.maxStepAllowed
                    && map.isActive(); i++) {
                switch (direction){
                    case UP:
                        if (this.position.getRow() - 1 >= 0) {
                            this.position.setRow(this.position.getRow() - 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                    case DOWN:
                        if (this.position.getRow() + 1 <= map.getRows() - 1) {
                            this.position.setRow(this.position.getRow() + 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                    case LEFT:
                        if (this.position.getCol() - 1 >= 0) {
                            this.position.setCol(this.position.getCol() - 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                    case RIGHT:
                        if (this.position.getCol() + 1 <= map.getColumns() - 1) {
                            this.position.setCol(this.position.getCol() + 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                }
            }
            return false;
        }else {
            for (int i = 0; i < steps
                    && this.steps < this.maxStepAllowed
                    && map.isActive(); i++) {
                switch (direction) {
                    case UP:
                        if (this.position.getRow() - 1 >= 0) {
                            this.position.setRow(this.position.getRow() - 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                    case DOWN:
                        if (this.position.getRow() + 1 <= map.getRows() - 1) {
                            this.position.setRow(this.position.getRow() + 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                    case LEFT:
                        if (this.position.getCol() - 1 >= 0) {
                            this.position.setCol(this.position.getCol() - 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                    case RIGHT:
                        if (this.position.getCol() + 1 <= map.getColumns() - 1) {
                            this.position.setCol(this.position.getCol() + 1);
                            score += map.hasTreasure(this.position);
                            map.update(this.position);
                            this.steps++;
                        } else {
                            return false;
                        }
                        break;
                }
            }
            // bug: implementation error
            // The step should be valid even if it takes the treasure and makes the map inactive.
            if (this.steps <= this.maxStepAllowed && map.isActive())
                return true;
            else return false;
        }
    }
    @Override
    public boolean equals(Object player) {
        Player p = (Player) player;
        return p.id == this.id;
    }
}