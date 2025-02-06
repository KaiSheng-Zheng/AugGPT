public class Player {
    private static int counter = 0;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private final Map map;
    private int maxStepsAllowed = Integer.MAX_VALUE;

    public Player(Map map, Position initialPosition) {
        this.id = counter++;
        this.position = initialPosition;
        this.map = map;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map, initialPosition);
        this.maxStepsAllowed = maxStepAllowed;
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
        if (!map.isActive() ) {
            return false;
        }
        while(steps!=0) {
            Position newPosition = new Position(getPosition().getRow(), getPosition().getCol());

            switch (direction) {
                case LEFT:
                    newPosition.setCol(newPosition.getCol() - 1);
                    break;
                case RIGHT:
                    newPosition.setCol(newPosition.getCol() + 1);
                    break;
                case UP:
                    newPosition.setRow(newPosition.getRow() - 1);
                    break;
                case DOWN:
                    newPosition.setRow(newPosition.getRow() + 1);
                    break;
            }

            if (!map.isWithinBounds(newPosition)||maxStepsAllowed==0) {
                return false;
            }

            position = newPosition;
            this.steps += 1;
            steps--;maxStepsAllowed--;
            if (map.hasTreasure(position) != 0) {
                score += map.hasTreasure(position);
                map.update(position);
            }
            if (!map.isActive()) return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Player player = (Player) obj;
        return id == player.id;
    }
}
