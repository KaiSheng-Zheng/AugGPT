public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition) {
        this.id = PlayerIdGenerator.generateId();
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = PlayerIdGenerator.generateId();
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        // Set max steps allowed for the player
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
        // Implement move logic
        return true; // Placeholder return value
    }

    public boolean equals(Object player) {
        if (this == player)
            return true;
        if (player == null || getClass() != player.getClass())
            return false;
        Player p = (Player) player;
        return id == p.id;
    }
}