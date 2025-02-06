public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private final int maxStepAllowd;
    public static int n = 1;
    private boolean isActive = true;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowd = 10000000;
        this.id = n;
        n++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowd = maxStepAllowed;
        this.id = n;
        n++;
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
        for (int i = 0; i < steps; i++) {
            if (!map.isActive()) {           //map is inactive
                return false;
            }
            if(this.steps == maxStepAllowd){            //player can't move anymore
                return false;
            }
            switch (direction){
                case LEFT:
                    if (this.position.getCol() - 1 < 0){
                        return false;
                    }
                    this.position.setCol(this.position.getCol() - 1);
                    break;
                case RIGHT:
                    if (this.position.getCol() + 1 > map.getColumns() - 1){
                        return false;
                    }
                    this.position.setCol(this.position.getCol() + 1);
                    break;
                case DOWN:
                    if (this.position.getRow() + 1 > map.getRows() - 1){
                        return false;
                    }
                    this.position.setRow(this.position.getRow() + 1);
                    break;
                case UP:
                    if (this.position.getRow() - 1 < 0){
                        return false;
                    }
                    this.position.setRow(this.position.getRow() - 1);
                    break;
            }
            this.steps++;
            score += map.hasTreasure(this.position);
            map.update(this.position);
        }
        return true;
    }

    public boolean equals(Object player) {
        if (this.id == ((Player) player).getId()) {
            return true;
        } else {
            return false;
        }
    }
}
