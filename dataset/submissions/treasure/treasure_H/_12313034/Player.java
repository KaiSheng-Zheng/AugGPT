public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxSteps = Integer.MAX_VALUE;

    static int count = 0;

    public Player(Map map,Position initialPosition){
        this.id = ++count;
        this.map = map;
        this.position = initialPosition;
    }

    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.id = ++count;
        this.map = map;
        this.position = initialPosition;
        this.maxSteps = maxStepAllowed;
    }

    public int getId(){return this.id;}
    public int getScore(){return this.score;}

    public int getSteps() {
        return this.steps;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean move(Direction direction,int steps){
        return switch (direction) {
            case UP -> {
                while (steps > 0) {
                    steps--;
                    if (this.position.getRow() - 1 < 0) yield false;
                    if (this.steps + 1 > this.maxSteps) yield false;
                    if (!this.map.isActive()) yield false;

                    this.steps +=1;
                    this.position.setRow(this.position.getRow() - 1);
                    this.score += this.map.hasTreasure(this.getPosition());
                    this.map.update(this.getPosition());
                }
                yield true;
            }
            case DOWN -> {
                while (steps > 0) {
                    steps--;
                    if (this.position.getRow() + 1 > this.map.getRows()-1) yield false;
                    if (this.steps + 1 > this.maxSteps) yield false;
                    if (!this.map.isActive()) yield false;

                    this.steps +=1;
                    this.position.setRow(this.position.getRow() + 1);
                    this.score += this.map.hasTreasure(this.getPosition());
                    this.map.update(this.getPosition());
                }
                yield true;
            }
            case LEFT -> {
                while (steps > 0) {
                    steps--;
                    if (this.position.getCol() - 1 < 0) yield false;
                    if (this.steps + 1 > this.maxSteps) yield false;
                    if (!this.map.isActive()) yield false;

                    this.steps +=1;
                    this.position.setCol(this.position.getCol() - 1);
                    this.score += this.map.hasTreasure(this.getPosition());
                    this.map.update(this.getPosition());
                }
                yield true;
            }
            case RIGHT -> {
                while (steps > 0) {
                    steps--;
                    if (this.position.getCol() + 1 > this.map.getColumns()-1) yield false;
                    if (this.steps + 1 > this.maxSteps) yield false;
                    if (!this.map.isActive()) yield false;

                    this.steps +=1;
                    this.position.setCol(this.position.getCol() + 1);
                    this.score += this.map.hasTreasure(this.getPosition());
                    this.map.update(this.getPosition());
                }
                yield true;
            }
        };
    }

    public boolean equals(Object player){
        Player player1 = (Player) player;
        return this.id == player1.id;
    }

}
