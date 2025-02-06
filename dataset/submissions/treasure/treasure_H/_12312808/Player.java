public class Player {

    private final int id = this.hashCode();
    private int remainingSteps = 2147483647;
    private int score;
    private int steps;
    private final Position position;
    private final Map map;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        position = initialPosition;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        position = initialPosition;
        this.remainingSteps = maxStepAllowed;
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
        if (!map.isActive()) {
            return false;
        }
        switch (direction) {
            case DOWN:
                for (int i = 0; i < steps; i++) {
                    if (position.getRow() + 1 <= map.getRows() - 1
                            && remainingSteps > 0
                            && map.isActive()) {
                        position.setRow(position.getRow() + 1);
                        score += map.update(position);
                        remainingSteps--;
                        this.steps++;
                    } else {
                        return false;
                    }
                }
                break;
            case UP:
                for (int i = 0; i < steps; i++) {
                    if (position.getRow() - 1 >= 0
                            && remainingSteps > 0
                            && map.isActive()) {
                        position.setRow(position.getRow() - 1);
                        score += map.update(position);
                        remainingSteps--;
                        this.steps++;
                    } else {
                        return false;
                    }
                }
                break;
            case LEFT:
                for (int i = 0; i < steps; i++) {
                    if (position.getCol() - 1 >= 0
                            && remainingSteps > 0
                            && map.isActive()) {
                        position.setCol(position.getCol() - 1);
                        score += map.update(position);
                        remainingSteps--;
                        this.steps++;
                    } else {
                        return false;
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i < steps; i++) {
                    if (position.getCol() + 1 <= map.getColumns() - 1
                            && remainingSteps > 0
                            && map.isActive()) {
                        position.setCol(position.getCol() + 1);
                        score += map.update(position);
                        remainingSteps--;
                        this.steps++;
                    } else {
                        return false;
                    }
                }
        }
        System.out.println("Position after movement is " + position);
        return true;
    }

    public boolean equals(Object player) {
        Player p = (Player)player;
        return this.id == p.id;
    }

}
