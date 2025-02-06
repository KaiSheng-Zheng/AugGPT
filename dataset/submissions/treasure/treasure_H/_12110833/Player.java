public class Player {
    private final int id;

    private int score; //score; already
    private int steps; //steps; already
    private Position position; //position; already

    private Map map;
    private int maxStepAllowed;

    static int count = 0; //increment;

    public Player(Map map, Position initialPosition){ //constructor: nomaxStep
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.id = ++count; //increment;
        this.maxStepAllowed = -1;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){ //constructor: maxStep
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps){ //move method: direction:updownleftright, steps;
        int moveSteps = 0; //judge
        if(!map.isActive()){
            steps = -1;
        }
        if(map.isActive()){ //isActive;
            for(int i = 0; i < steps; ++i){
                if(maxStepAllowed != 0 && map.isActive() &&
                        position.getRow()+direction.getRow() >= 0 && position.getRow()+direction.getRow() < map.getRows() &&
                        position.getCol()+direction.getCol() >= 0 && position.getCol()+direction.getCol() < map.getColumns()){ //true condition
                    this.steps++;
                    moveSteps ++;

                    position.setRow(position.getRow()+direction.getRow());
                    position.setCol(position.getCol()+direction.getCol());

                    if(map.hasTreasure(position) > 0){
                        score += map.hasTreasure(position);
                        map.update(position);
                    }

                    maxStepAllowed--;
                }
                else{
                    continue;
                }
            }
        }

        if(moveSteps == steps){
            return true;
        } else {
            return false;
        }

    }

    public boolean equals(Object player){
        Player targetPlayer = (Player) player;
        return (this.id == ((Player) player).id);
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
