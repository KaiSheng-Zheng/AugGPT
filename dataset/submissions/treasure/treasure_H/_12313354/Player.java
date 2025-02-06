public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int  maxStepAllowed;
    static int count = 0;
    int toSteps = 0;

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
        this.score =0;
        this.steps =0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
        this.score =0;
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
        }
        if (!map.isValidPosition(position)) {
            return false;
        }
        if(position.getCol() == 0 && direction ==Direction.LEFT ){
            return false ;
        }
        if(position.getCol() == map.getColumns() -1&& direction ==Direction.RIGHT ){
            return false ;
        }
        if(position.getRow() == 0 && direction ==Direction.UP ){
            return false ;
        }
        if(position.getRow() ==map.getRows()-1 && direction ==Direction.DOWN ){
            return false ;
        }
        if (!map.isValidPosition(position)) {
            return false;
        }
        int remainingSteps = steps ;
        if(steps  > maxStepAllowed-this.steps  ){
            remainingSteps =maxStepAllowed-this.steps;
        }
        while (remainingSteps > 0) {

            Position newPosition = calculateNewPosition(direction);
            if (!map.isValidPosition(newPosition)) {
                return false;
            }

            position = newPosition;
            score +=map.hasTreasure(position);
            map.update(position) ;
            this.steps ++;
            remainingSteps--;
            if (!map.isActive()) {
                break;
            }
        }
        if (maxStepAllowed != 0 && toSteps  >= maxStepAllowed) {
            return false;
        }
        return true;
    }


    private Position calculateNewPosition(Direction direction){
        int newRow = position.getRow();
        int newColumn = position.getCol();

        switch(direction){
            case UP:
                newRow--;
                break;
            case DOWN:
                newRow++;
                break;
            case LEFT:
                newColumn--;
                break;
            case RIGHT:
                newColumn++;
                break;
        }
        if(newRow < 0){
            newRow = 0;
        }
        if(newColumn  < 0){
            newColumn  = 0;
        }
        if(newRow >map.getRows()-1 ){
            newRow =map.getRows()-1;
        }
        if(newRow >map.getRows()-1 ){
            newRow =map.getRows()-1;
        }
        return new Position(newRow, newColumn);
    }

    public boolean equals(Object player) {
        if (player instanceof Player) {
            Player p = (Player) player;
            return this.id == p.getId();
        }
        return false;
    }
}