public class Player {
    private static int cnt = 0;
    private final int id;
    private int score;
    private int steps;
    private Position position;

    private final int maxStepAllowed;
    private Map map;

    public Player(Map map, Position position) {
        this.position = position;
        this.map = map;
        this.id = ++cnt;
        this.score = 0;
        this.steps = 0;
        this.maxStepAllowed = -1;
    }

    public Player(Map map, Position position, int maxStepAllowed) {
        this.position = position;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ++cnt;
        this.score = 0;
        this.steps = 0;
    }

    public boolean move(Direction direction, int steps) {
        int drow,dcol;
        drow = dcol = 0;
        switch(direction) {
            case UP -> drow = -1;
            case DOWN -> drow = 1;
            case LEFT -> dcol = -1;
            case RIGHT -> dcol = 1;
        }
        boolean isEffect = true;
        while(steps-- > 0) {
            if(this.steps == this.maxStepAllowed||!this.map.isActive()) return false;
            this.position.setRow(this.position.getRow() + drow);
            this.position.setCol(this.position.getCol() + dcol);
            if(this.position.getRow() >= this.map.getRows()) {
                this.position.setRow(this.map.getRows() - 1);
                isEffect = false;
            }
            if(this.position.getRow() < 0) {
                this.position.setRow(0);
                isEffect = false;
            }
            if(this.position.getCol() >= this.map.getColumns()) {
                this.position.setCol(this.map.getColumns() - 1);
                isEffect = false;
            }
            if(this.position.getCol() < 0) {
                this.position.setCol(0);
                isEffect = false;
            }
            int sc = this.map.hasTreasure(this.position);
            this.score += sc;
            if(sc > 0) this.map.update(this.position);
            if(!isEffect) break;
            this.steps++;
        }
        return isEffect;
    }

    public boolean equals(Object player) {
        if(player == this) return true;
        if(player instanceof Player pl) {
            return pl.id == this.id;
        }
        return false;
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
