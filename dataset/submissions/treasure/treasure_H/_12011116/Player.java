public class Player {

    private static int idCounter = 0;

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        id = ++ idCounter;
        this.maxStepAllowed = -1;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map, initialPosition);
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        for ( int i = 0; i < steps; i ++ ) {
            if ( !map.isActive() ) return false;
            int y = position.getRow(), x = position.getCol();

            if ( direction.equals(Direction.UP) ) y --;
            else if ( direction.equals(Direction.DOWN) ) y ++;
            else if ( direction.equals(Direction.LEFT) ) x --;
            else x ++;

            if ( x < 0 || x >= map.getColumns() || y < 0 || y >= map.getRows() ) return false;
            if ( maxStepAllowed >= 0 && this.steps + 1 > maxStepAllowed ) return false;

            this.steps ++;
            position = new Position(y, x);

            int t = map.hasTreasure(position);
            if ( t > 0 ) {
                score += t;
                map.update(position);
            }
        }
        return true;
    }

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

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }
}
