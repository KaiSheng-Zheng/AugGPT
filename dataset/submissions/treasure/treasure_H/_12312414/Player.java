public class Player {
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = -1;
    private static int count = 0;

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (maxStepAllowed != -1){
            for (int i = 0; i < steps; i++) {
                if (this.steps == maxStepAllowed){
                    return false;
                }
                if (this.getMap().isActive()) {
                    switch (direction) {
                        case UP -> {
                            if (this.position.getRow() - 1 >= 0) {
                                this.position.setRow(this.position.getRow() - 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                        case DOWN -> {
                            if (this.position.getRow() + 1 < map.getRows()) {
                                this.position.setRow(this.position.getRow() + 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                        case LEFT -> {
                            if (this.position.getCol() - 1 >= 0) {
                                this.position.setCol(this.position.getCol() - 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                        case RIGHT -> {
                            if (this.position.getCol() + 1 < map.getColumns()) {
                                this.position.setCol(this.position.getCol() + 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                    }
                }
            }
        }else {
            for (int i = 0; i < steps; i++) {
                if (this.getMap().isActive()) {
                    switch (direction) {
                        case UP -> {
                            if (this.position.getRow() - 1 >= 0) {
                                this.position.setRow(this.position.getRow() - 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                        case DOWN -> {
                            if (this.position.getRow() + 1 < map.getRows()) {
                                this.position.setRow(this.position.getRow() + 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                        case LEFT -> {
                            if (this.position.getCol() - 1 >= 0) {
                                this.position.setCol(this.position.getCol() - 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                        case RIGHT -> {
                            if (this.position.getCol() + 1 < map.getColumns()) {
                                this.position.setCol(this.position.getCol() + 1);
                                this.score += map.hasTreasure(this.position);
                                map.update(this.position);
                                this.steps++;
                                if (!map.isActive()) {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        Player player1 = (Player) player;
        if (this.getId() == player1.getId()) {
            return true;
        } else {
            return false;
        }
    }

    public Player(Map map, Position initialPosition) {
        this.position = initialPosition;
        this.map = map;
        this.id = count;
        count++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
        this.id = count;
        count++;
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

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }
}
