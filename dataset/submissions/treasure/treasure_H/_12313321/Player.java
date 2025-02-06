public class Player {
    private final int id;
    public static int counter10=1;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStep;
    public Player(Map map, Position initialPosition){
        this.id=counter10++;
        this.map=map;
        this.position=initialPosition;
        this.maxStep=2000000000;
        this.steps=0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id=counter10++;
        this.map=map;
        this.position=initialPosition;
        this.maxStep=maxStepAllowed;
        this.steps=0;
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
    public int getMaxStep() {
        return maxStep;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public boolean move(Direction direction, int steps){
        int p;
        if(map.isActive()) {
            switch (direction) {
                case UP:
                    p = 0;
                    for (int cou = 0; cou < steps; cou++) {
                        if (this.getSteps() < this.getMaxStep() && this.position.getRow() > 0) {
                            this.position.setRow(this.position.getRow() - 1);
                            this.setSteps(this.getSteps() + 1);
                            p++;
                            this.setScore(this.getScore() + map.hasTreasure(this.position));
                            map.update(this.position);
                            if(!map.isActive()) break;
                        }
                    }
                    return p == steps;
                case DOWN:
                    p = 0;
                    for (int cou = 0; cou < steps; cou++) {
                        if (this.getSteps() < this.getMaxStep() && this.position.getRow() < this.map.getRows()) {
                            this.position.setRow(this.position.getRow() + 1);
                            this.setSteps(this.getSteps() + 1);
                            p++;
                            this.setScore(this.getScore() + map.hasTreasure(this.position));
                            map.update(this.position);
                            if(!map.isActive()) break;
                        }
                    }
                    return p == steps;
                case LEFT:
                    p = 0;
                    for (int cou = 0; cou < steps; cou++) {
                        if (this.getSteps() < this.getMaxStep() && this.position.getCol() > 0) {
                            this.position.setCol(this.position.getCol() - 1);
                            this.setSteps(this.getSteps() + 1);
                            p++;
                            this.setScore(this.getScore() + map.hasTreasure(this.position));
                            map.update(this.position);
                            if(!map.isActive()) break;
                        }
                    }
                    return p == steps;
                case RIGHT:
                    p = 0;
                    for (int cou = 0; cou < steps; cou++) {
                        if (this.getSteps() < this.getMaxStep() && this.position.getCol() < this.map.getColumns()) {
                            this.position.setCol(this.position.getCol() + 1);
                            this.setSteps(this.getSteps() + 1);
                            p++;
                            this.setScore(this.getScore() + map.hasTreasure(this.position));
                            map.update(this.position);
                            if(!map.isActive()) break;
                        }
                    }
                    return p == steps;
            }
        }
        return false;
    }
    public boolean equals(Object player){
        Player a=(Player) player;
        return this.id==a.getId();
    }
    public String toString()
    {
        return "id="+this.id+" pos="+this.position.getRow()+","+this.position.getCol()+" steps="+this.steps+" score="+this.score;
    }
}
