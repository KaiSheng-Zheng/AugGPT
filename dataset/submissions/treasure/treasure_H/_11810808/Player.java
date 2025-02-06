public class Player {

    private final int id;
    private int score = 0;
    private int steps = 0;
    private int maxStepAllowed = 2147483647;
    private Position position;
    private Map map;
    static int count = 0;

    public Player(Map map, Position initialPosition){
        id = count;
        this.map = map;
        this.position = initialPosition;
        count++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id = count;
        this.map = map;
        this.position = initialPosition;
        count++;
        this.maxStepAllowed = maxStepAllowed;
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

    public boolean move(Direction direction, int steps){
        boolean judgement = true;
        if(!this.map.isActive()){
            judgement = false;
        } else if(this.steps + steps > maxStepAllowed){
            judgement = false;
        } else {
            switch (direction){
                case UP:
                    if(steps<=position.getRow()) {
                        position.setRow(position.getRow() - steps);
                        this.steps = this.steps + steps;
                    }else{
                        position.setRow(0);
                        this.steps = this.steps + position.getRow();
                        judgement = false;
                    }
                    break;
                case DOWN:
                    if(steps<map.getRows()-position.getRow()){
                        position.setRow(position.getRow()+steps);
                        this.steps = this.steps + steps;
                    }else{
                        position.setRow(map.getRows() - 1);
                        this.steps = this.steps + map.getRows() - 1 - position.getRow();
                        judgement = false;
                    }
                    break;
                case LEFT:
                    if(steps<=position.getCol()){
                        position.setCol(position.getCol()-steps);
                        this.steps = this.steps + steps;
                    }else {
                        position.setCol(0);
                        this.steps = this.steps + map.getColumns() ;
                        judgement = false;
                    }
                    break;
                case RIGHT:
                    if(steps<map.getColumns()-position.getCol()){
                        position.setCol(position.getCol()+steps);
                        this.steps = this.steps + steps;
                    }else {
                        position.setCol(position.getCol() - 1);
                        this.steps = this.steps + map.getColumns() - 1 - position.getCol();
                        judgement = false;
                    }
                    break;
            }
        }
        return judgement;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id == p.id;
    }
}