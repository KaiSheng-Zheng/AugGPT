public class Player {
    private final int id;
    private int score;
    private int steps=0;
    private Position position;
    private Map map;
    static int count = 0;
    private int maxStepAllowed;

    public Player(Map map, Position initialPos) {
        this.map = map;
        this.position = initialPos;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPos, int maxStepAllowed) {
        this.map = map;
        this.position = initialPos;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        boolean move = true;
        if (!map.isActive()) return false;
        if(steps > this.maxStepAllowed){
            move = false;
        }
        for (int i = 0; i < steps; i++) {
            if (map.getStoreTreasures().size()==0){
                move = false;
                break;
            }
            if (this.maxStepAllowed > 0) {
                this.position.setRow(this.position.getRow() + direction.getRow());
                if (this.position.getRow() > map.getRows() - 1) {
                    this.position.setRow(map.getRows() - 1);
                    move = false;
                    break;
                }
                if (this.position.getRow() < 0) {
                    this.position.setRow(0);
                    move = false;
                    break;
                }
                this.position.setCol(this.position.getCol() + direction.getCol());
                if (this.position.getCol() > map.getColumns() - 1) {
                    this.position.setCol(map.getColumns() - 1);
                    move = false;
                    break;
                }
                if (this.position.getCol() < 0) {
                    this.position.setCol(0);
                    move = false;
                    break;
                }
                this.maxStepAllowed--;
                this.steps++;
                if (map.hasTreasure(this.position)>0){
                    this.score+=map.hasTreasure(this.position);
                    map.update(this.position);
                }
            }
        }
        return move;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return this.id == p.id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                '}';
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

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }
}