public class Player {
    private final int id;
    private static int idCounter = 0;
    private int totalStep;

    private int flag;

    public int getTotalStep() {
        return totalStep;
    }

    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return totalStep;
    }

    public Position getPosition() {
        return position;
    }


    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = idCounter++;
        flag = 0;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = idCounter++;
        flag = 1;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        } else {
            return nextPosition(direction, steps);
        }
    }


    public boolean equals(Object player) {
        Player p = (Player) player;

        return this.id == p.id;
    }


    public boolean nextPosition(Direction direction, int steps) {
        boolean ret = true;

        for (int i = 0; i < steps; i++)
            if ((totalStep == maxStepAllowed && flag == 1) || !map.isActive()) {
                ret = false;
            } else {
                Position nextPosition = new Position(position.getRow(), position.getCol());
                switch (direction) {
                    case RIGHT -> {
                        nextPosition.setCol(nextPosition.getCol() + 1);
                    }
                    case DOWN -> {
                        nextPosition.setRow(nextPosition.getRow() + 1);
                    }
                    case UP -> {
                        nextPosition.setRow(nextPosition.getRow() - 1);
                    }
                    case LEFT -> {
                        nextPosition.setCol(nextPosition.getCol() - 1);
                    }
                }
                if (nextPosition.getCol() >= 0 && nextPosition.getCol() < map.getColumns() &&
                        nextPosition.getRow() >= 0 && nextPosition.getRow() < map.getRows()) {
                    position = new Position(nextPosition.getRow(), nextPosition.getCol());
                    score += map.hasTreasure(position);
                    map.update(position);
                    totalStep++;
                } else ret = false;
            }

        return ret;
    }


}
