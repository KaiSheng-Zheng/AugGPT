public class Player {
    private static int playerCounter = 0;
    private final int id = 1 + playerCounter;
    private int score = 0;
    private int steps = 0;
    private Map map;
    private Position position;
    private int maxStepAllowed = -1;
    private int totalSteps = 0;


    public Player(Map map, Position position) {
        this.map = map;
        this.position = position;
        playerCounter++;
    }

    public Player(Map map, Position position, int maxStepAllowed) {
        this.map = map;
        this.position = position;
        this.maxStepAllowed = maxStepAllowed;
        playerCounter++;
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

    public Map getMap() {
        return map;
    }

    public Position getPosition() {
        return position;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public boolean move(Direction direction, int steps) {
        totalSteps = 0;
        boolean canMove = true;
        if (!map.isActive())
            canMove = false;
        else {
            switch (direction) {
            case UP:
                if (position.getRow() == 0)
                    canMove = false;
                break;
            case DOWN:
                if (position.getRow() == map.getRows() - 1)
                    canMove = false;
                break;
            case LEFT:
                if (position.getCol() == 0)
                    canMove = false;
                break;
            case RIGHT:
                if (position.getCol() == map.getColumns() - 1)
                    canMove = false;
                break;
            }
        }
        if (canMove) {
            if (maxStepAllowed != -1) {
                if (this.steps == maxStepAllowed) {
                    canMove = false;
                    return canMove;
                }
                else {
                    if (this.steps + steps > maxStepAllowed) {
                        steps = maxStepAllowed - this.steps;
                        canMove  = false;
                    }
                }
            }
            int i;
            switch (direction) {
                case UP:
                    i = 1;
                    while (i <= steps) {
                        position.setRow(position.getRow() - 1);
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        totalSteps++;
                        i++;
                        if (position.getRow() == 0 && i <= steps) {
                            canMove = false;
                            break;
                        }
                        if (!map.isActive() && i <= steps) {
                            canMove = false;
                            break;
                        }
                    }
                    break;
                case DOWN:
                    i = 1;
                    while (i <= steps) {
                        position.setRow(position.getRow() + 1);
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        totalSteps++;
                        i++;
                        if (position.getRow() == map.getRows() - 1 && i <= steps) {
                            canMove = false;
                            break;
                        }
                        if (!map.isActive() && i <= steps) {
                            canMove = false;
                            break;
                        }
                    }
                    break;
                case LEFT:
                    i = 1;
                    while (i <= steps) {
                        position.setCol(position.getCol() - 1);
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        totalSteps++;
                        i++;
                        if (position.getCol() == 0 && i <= steps) {
                            canMove = false;
                            break;
                        }
                        if (!map.isActive() && i <= steps) {
                            canMove = false;
                            break;
                        }
                    }
                    break;
                case RIGHT:
                    i = 1;
                    while (i <= steps) {
                        position.setCol(position.getCol() + 1);
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        totalSteps++;
                        i++;
                        if (position.getCol() == map.getColumns() - 1 && i <= steps) {
                            canMove = false;
                            break;
                        }
                        if (!map.isActive() && i <= steps) {
                            canMove = false;
                            break;
                        }
                    }
                    break;
            }
        }
        this.steps = this.steps + totalSteps;
        return canMove;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id == p.id;
    }

}
