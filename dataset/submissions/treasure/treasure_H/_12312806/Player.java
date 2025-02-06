public class Player {
    private static int idCounter = 0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private Integer maxStepAllowed;



    public Player(Map map, Position initialPosition) {
        this.id = idCounter++;
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed = null; // No step limit
    }

    public void addScore(){
        if(this.map.treasureExist(position))
        score = score + this.map.hasTreasure(position);
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map, initialPosition); // Calls the other constructor
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

    // Enum for Direction


    public boolean move(Direction direction, int steps) {
        int ste = steps;
        if (!map.getIsActive()) {
            return false;
        }
        if (maxStepAllowed != null && this.steps + steps > maxStepAllowed) {
            steps = maxStepAllowed - this.steps;

        }
        Position newPosition = calculateNewPosition(direction, steps);
        if (newPosition.isOutsideMap(map)) {
            newPosition = position.moveToBoundary(direction, map);
            steps = newPosition.stepsFrom(position);
        }
        if (steps > 0) {
            //this.position = newPosition;
            this.steps += steps;
            for (int i = 1; i <= steps; i++) {
                this.position = calculateNewPosition(direction, 1);
                addScore();

            }
            if (ste > steps)  {return false;}
            return true;
        }
        return false;
    }
    private Position calculateNewPosition(Direction direction, int steps) {
        if (!map.getIsActive()){
            return this.position;
        }
        // Assume Position class has a method to calculate new position based on direction and steps
        return position.calculateNewPosition(direction, steps);
    }
    public boolean equals(Object player){
        return (this == player);
    }
}
