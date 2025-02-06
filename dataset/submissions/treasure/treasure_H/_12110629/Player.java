public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPos){
        this.id=(int)(1+Math.random()*10000);
        this.map=map;
        this.position=initialPos;
    }
    public Player(Map map, Position initialPos, int maxStepAllowed){
        this.id=(int)(1+Math.random()*10000);
        this.map=map;
        this.position=initialPos;
        this.steps=maxStepAllowed;
    }

    public boolean move(Direction direction, int steps){
        if(!this.map.isActive()){
            return  false;
        }
        if(steps>this.map.getColumns() || steps>this.map.getRows()){
            return false;
        }
        if(steps>this.steps){
            return false;
        }
        switch (direction) {
            case UP:
                position.setRow(position.getRow() - steps);
                break;
            case DOWN:
                position.setRow(position.getRow() + steps);
                break;
            case LEFT:
                position.setCol(position.getCol() - steps);
                break;
            case RIGHT:
                position.setCol(position.getCol() + steps);
                break;
        }

        this.steps += steps;

        if (position.getRow() < 0 || position.getRow() >= map.getRows() || position.getCol() < 0 || position.getCol() >= map.getColumns()) {
            return false;
        }
        return true;

    }

    public boolean equals(Object player){
        Player player1 = (Player) player;
        if(this.id==player1.id) {
            return true;
        }
        return false;
    }


    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}