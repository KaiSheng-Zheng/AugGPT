public class Player {
    private static int nextId = 1;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    public Player(Map map, Position initialPos){
        this.id = nextId++;
        this.map = map;
        this.position = initialPos;
    }
    public Player(Map map, Position initialPos, int maxStepAllowed){
        this.id = nextId++;
        this.map = map;
        this.position = initialPos;
        this.maxStepAllowed = maxStepAllowed;
    }
    public boolean move(Direction direction, int steps) {
    // Validate if the player can move in the specified direction
    int newRow = position.getRow();
    int newCol = position.getCol();

    switch (direction) {
        case UP:
            newRow -= steps;
            break;
        case DOWN:
            newRow += steps;
            break;
        case LEFT:
            newCol -= steps;
            break;
        case RIGHT:
            newCol += steps;
            break;
    }

    // Check if the new position is within the map boundaries
    if (isValidMove(newRow, newCol)) {
        // Update player's position
        position = new Position(newRow, newCol);

        // Update total steps taken
        steps += steps;
        return true;
    }
    return false;
    }

    private boolean isValidMove(int newRow, int newCol) {
    return newRow >= 0 && newRow < map.getRows() && newCol >= 0 && newCol < map.getColumns();
    }
    public boolean equals(Object player){
        Player otherPlayer = (Player) player;
        return this.id == otherPlayer.id;
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
}
