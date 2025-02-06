public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int count = 0;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        maxStepAllowed = 1000000000;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }
    public int addScore(Position position) {
        int updatedScore = this.score;
        Treasure[] treasures = map.getTreasures();

        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                updatedScore += treasures[i].getScore();
            }
        }
        return updatedScore;
    }


    public boolean move(Direction direction, int steps) {
        for (int i = 0; i < steps; i++) {
            if (!map.isActive() || this.steps >= maxStepAllowed)
                return false;

            int newRow = position.getRow();
            int newCol = position.getCol();

            switch (direction) {
                case UP:
                    if (newRow > 0) {
                        newRow--;
                    } else {
                        return false;
                    }
                    break;
                case DOWN:
                    if (newRow < map.getRows() - 1) {
                        newRow++;
                    } else {
                        return false;
                    }
                    break;
                case LEFT:
                    if (newCol > 0) {
                        newCol--;
                    } else {
                        return false;
                    }
                    break;
                case RIGHT:
                    if (newCol < map.getColumns() - 1) {
                        newCol++;
                    } else {
                        return false;
                    }
                    break;
            }

            Position newPosition = new Position(newRow, newCol);
            this.position = newPosition;
            this.steps++;
            score = addScore(newPosition);
            map.update(newPosition);
        }
        return true;
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
