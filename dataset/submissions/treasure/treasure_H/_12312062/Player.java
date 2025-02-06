public class Player {

    static int count = 0;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;

    int maxStepAllowed;

    public Player(Map map, Position initialPos) {
        this.position = initialPos;
        this.map = map;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
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

    public Player(Map map, Position initialPos, int maxStepAllowed) {
        this.position = initialPos;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ++count;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) return false;
        if(maxStepAllowed==0)return false;
        int newRow = position.getRow();
        int newCol = position.getCol();
        for (int i = 0; i < steps; i++) {
            switch (direction) {
                case UP:
                    newRow--;
                    break;
                case DOWN:
                    newRow++;
                    break;
                case LEFT:
                    newCol--;
                    break;
                case RIGHT:
                    newCol++;
                    break;
            }

            if (!map.isActive()) {
                this.steps += i;
                return false;
            }
            // Check if the new position is within the map boundaries
            if (!isValidMove(newRow, newCol)) {
                this.steps += i;
                return false;
            }

            // Check for treasure at the new position


            if (this.steps + i >= maxStepAllowed) {
                int actualSteps = Math.min(steps, maxStepAllowed > 0 ? maxStepAllowed - this.steps : steps);
                this.steps += actualSteps;
                return false;
            }
            int treasureScore = map.hasTreasure(new Position(newRow, newCol));
            if (treasureScore > 0) {
                score += treasureScore;
                map.update(new Position(newRow, newCol)); // Remove the treasure from the map
            }
            position.setRow(newRow);
            position.setCol(newCol);

        }

        // Check if the player exceeds the maxStepAllowed


        int actualSteps = Math.min(steps, maxStepAllowed > 0 ? maxStepAllowed - this.steps : steps);
        position.setRow(newRow);
        position.setCol(newCol);
        this.steps += actualSteps;
        return true;

    }

    public boolean equals(Object player) {
        Player player1 = (Player) player;
        return this.id == player1.getId();
    }

    private boolean isValidMove(int newRow, int newCol) {
        return newRow >= 0 && newRow < map.getRows() && newCol >= 0 && newCol < map.getColumns();
    }


    public int compareTo(Player o) {
        if (score != o.getScore()) {
            return score - o.getScore();
        } else return steps - o.getSteps();


    }


    @Override
    public String toString() {
        return super.toString();
    }



    public void setPosition(Position position) {
        this.position = position;
    }
}




