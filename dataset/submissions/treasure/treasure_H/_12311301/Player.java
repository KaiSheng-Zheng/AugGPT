public class Player {
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;

    private int maxStep;

    private static int counter = 0;

    public Player(Map map, Position initialPosition) {
        this.id = ++counter;
        this.map = map;
        this.position = initialPosition;
        this.maxStep = -1;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = ++counter;
        this.map = map;
        this.position = initialPosition;
        this.maxStep = maxStepAllowed;
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
        switch (direction) {
            case LEFT:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) {
                        return false;
                    } else if (position.getCol() == 0) {
                        return false;
                    } else if (maxStep != -1 && this.steps == this.maxStep) {
                        return false;
                    } else {
                        this.steps++;
                        int temp = position.getCol()-1;
                        position.setCol(temp);
                        int tempPoint = this.map.hasTreasure(position);
                        if(tempPoint != 0) {
                            score += tempPoint;
                            map.update(position);
                        }
                    }
                }
                return true;
            case RIGHT:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) {
                        return false;
                    } else if (position.getCol() == map.getColumns() - 1) {
                        return false;
                    } else if (maxStep != -1 && this.steps == this.maxStep) {
                        return false;
                    } else {
                        this.steps++;
                        int temp = position.getCol()+1;
                        position.setCol(temp);
                        int tempPoint = this.map.hasTreasure(position);
                        if(tempPoint != 0) {
                            score += tempPoint;
                            map.update(position);
                        }
                    }
                }
                return true;
            case UP:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) {
                        return false;
                    } else if (position.getRow() == 0) {
                        return false;
                    } else if (maxStep != -1 && this.steps == this.maxStep) {
                        return false;
                    } else {
                        this.steps++;
                        int temp = position.getRow()-1;
                        position.setRow(temp);
                        int tempPoint = this.map.hasTreasure(position);
                        if(tempPoint != 0) {
                            score += tempPoint;
                            map.update(position);
                        }
                    }
                }
                return true;
            case DOWN:
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()) {
                        return false;
                    } else if (position.getRow() == map.getRows() - 1) {
                        return false;
                    } else if (maxStep != -1 && this.steps == this.maxStep) {
                        return false;
                    } else {
                        this.steps++;
                        int temp = position.getRow()+1;
                        position.setRow(temp);
                        int tempPoint = this.map.hasTreasure(position);
                        if(tempPoint != 0) {
                            score += tempPoint;
                            map.update(position);
                        }
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object player) {
        Player targetPlayer = (Player) player;
        return targetPlayer.getId() == this.getId();
    }


}