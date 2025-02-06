public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxSteoAllowed;
    private int c=0;

    public Player(Map map, Position initialPosition){
        this.map = map;
        position = initialPosition;
        score = 0;
        steps = 0;
        id = ++c;

    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        position = initialPosition;
        score = 0;
        steps = 0;
        this.maxSteoAllowed = maxStepAllowed;
        id = ++c;
    }

    public  boolean move(Direction direction, int steps){
        for(int i = 0; i < steps; i++){
            if(!map.isActive()){
                return false;
            }else {
                if(this.steps < maxSteoAllowed){
                    this.steps += 1;
                    switch (direction){
                        case UP :
                            if(position.getRow() !=0){
                                position = new Position(position.getRow()-1,position.getCol());
                                break;
                            }else {
                                return false;
                            }
                        case DOWN:
                            if(position.getRow() != map.getRows()){
                                position = new Position(position.getRow()+1,position.getCol());
                                break;
                            }else {
                                return false;
                            }

                        case LEFT:
                            if(position.getCol() != 0){
                                position = new Position(position.getRow(),position.getCol()-1);
                                break;
                            }else {
                                return false;
                            }

                        case RIGHT:
                            if(position.getCol() != map.getColumns()){
                                position = new Position(position.getRow(), position.getCol()+steps);
                                break;
                            }else {
                                return false;
                            }
                    }

                }
                else {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.getId()==getId()){
            return true;
        }else {
            return false;
        }
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public int getSteps() {
        return steps;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
