public class Player {
    private final int id = 10000 ;

    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map, initialPosition);
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

    public void reset() {
        this.score = 0;
        this.steps = 0;
        this.position = new Position(0, 0);
    }


    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }

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


            if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
                return false;
            }
            this.position = new Position(newRow, newCol);
            this.steps++;

            if (this.steps == maxStepAllowed) {
                return false;
            }


            int treasureScore = map.hasTreasure(this.position);
            if (treasureScore > 0) {
                this.score += treasureScore;
                map.update(this.position);
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object player) {
        Player p = (Player) player;
        if(this.id ==p.getId()){
            return true;
        };
        return false;}

}