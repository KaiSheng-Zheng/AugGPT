public class Player {
    private static int count = 0;
    private final int id;
    private int score = 0;
    private int stepsRemained = -1;
    private int steps = 0;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition) {
        id = count++;
        this.map = map;
        //position = new Position(initialPosition);
        position = initialPosition;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        id = count++;
        this.map = map;
        //position = new Position(initialPosition);
        position = initialPosition;
        stepsRemained = maxStepAllowed;
    }
    /*
    public boolean equals(Player player) {
        return player.id == id;
    }

    public boolean equals(Object Unknown) {
        return false;
    }
    */

    public boolean equals(Object player) {
        return ((Player)player).getId() == getId();
    }

    public void gainScore(int score) {
        this.score += score;
    }

    public int getId() {
        return id;
    }

    public boolean move(Direction direction, int steps) {
        int t;
        if (this.stepsRemained < 0) {
            t = map.moveAndCollect(this, position, direction, steps);
        }
        else {
            if (steps > this.stepsRemained) {
                t = map.moveAndCollect(this, position, direction, this.stepsRemained);
                this.steps += this.stepsRemained - t;
                this.stepsRemained = t;
                return false;
            }
            t = map.moveAndCollect(this, position, direction, steps);
            this.stepsRemained -= steps - t;
        }
        this.steps += steps - t;
        return t == 0;
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
