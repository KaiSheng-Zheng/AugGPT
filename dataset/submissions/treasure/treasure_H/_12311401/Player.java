public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed=-1;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.steps = 0;
        this.score = 0;
        this.id = IDGeneration.idGenerate();
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.steps = 0;
        this.score = 0;
        this.maxStepAllowed = maxStepAllowed;
        this.id = IDGeneration.idGenerate();
    }

    public void move(Direction direction, Position position) {
        switch (direction) {
            case UP:
                position.setRow(position.getRow() - 1);
                break;
            case DOWN:
                position.setRow(position.getRow() + 1);
                break;
            case LEFT:
                position.setCol(position.getCol() - 1);
                break;
            case RIGHT:
                position.setCol(position.getCol() + 1);
                break;
        }
        this.steps++;
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
        if (!map.isActive()) {
            return false;
        } else {
            if (this.inEdge(direction)) {
                int judge = 1;
                for (int i = 0; i < steps && (this.steps < this.maxStepAllowed||this.maxStepAllowed==-1) ; i++) {
                    judge=0;
                    this.move(direction, this.position);
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(position);
                    if (steps - i > 1 && ((!this.inEdge(direction))||this.maxStepAllowed - this.steps == 0 || !map.isActive())) {
                        judge = 1;
                        break;
                    }
                }
                return judge != 1;
            } else return false;
        }
    }

    public boolean equals(Object player) {
        Player player1=(Player) player;
        return player1.getId()==this.getId();
    }

    public boolean inEdge(Direction direction) {
        int row=this.position.getRow();
        int col=this.position.getCol();
        switch (direction) {
            case UP:
                row--;
                break;
            case DOWN:
                row++;
                break;
            case LEFT:
                col--;
                break;
            case RIGHT:
                col++;
                break;
        }
        return row >=0 && col >= 0
                && row <= map.getRows() - 1 && col <= map.getColumns() - 1;
    }
}
