public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
    }

    static int count = 0;

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        // Calculate the new position based on the direction and steps
        Position newPosition = position.calculateNewPosition(direction, steps, map);

        // Check if the new position is valid in the map
        if (map.isValidPosition(newPosition.getRow(), newPosition.getCol())) {
            // Update the player's position
            position = newPosition;

            // Check if there is a treasure at the new position
            int treasureIndex = map.hasTreasure(position);
            if (treasureIndex != -1) {
                // Update the player's score based on the treasure found
                Treasure treasure = map.getTreasures()[treasureIndex];
                score += treasure.getScore();
                // Update the player's steps based on the steps taken
                this.steps += steps;
                map.update(position);
            }
            // Update the remaining steps allowed
            maxStepAllowed -= steps;

            return true;
        } else {
            return false;
        }
    }




    @Override
    public boolean equals(Object player) {
        if (this == player) {
            return true;
        }
        if (player == null || getClass() != player.getClass()) {
            return false;
        }
        Player p = (Player) player;
        return id == p.id;
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
