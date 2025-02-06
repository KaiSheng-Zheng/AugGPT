

public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int steps1;

    public Player( Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = generatePlayerId();
        this.steps1=Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = generatePlayerId();
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.steps1 = maxStepAllowed;
    }

    private static int playerCount = 0;

    private static int generatePlayerId() {
        return ++playerCount;
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
        if (steps1 == 0) return false;
        for (int i = 0; i < steps; i++) {
            if (!map.isActive() ||this.steps>=steps1) {
                return false;
            }
            int newRow1 = position.getRow();
            int newCol1 = position.getCol();
            int newRow = newRow1;
            int newCol = newCol1;

            switch (direction) {
                case UP:
                    newRow = newRow1 - 1;
                    break;
                case DOWN:
                    newRow = newRow1 + 1;
                    break;
                case LEFT:
                    newCol = newCol1 - 1;
                    break;
                case RIGHT:
                    newCol = newCol1 + 1;
                    break;
            }
            if (newRow<0||newRow>= map.getRows()||newCol<0||newCol>=map.getColumns()){
                return false;
            }
            Position newPosition = new Position(newRow, newCol);
            int treasureScore = map.hasTreasure(newPosition);
            score += treasureScore;
            map.update(newPosition);
            position=newPosition;
            this.steps++;
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
}