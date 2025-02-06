enum Direction{
    UP,DOWN,LEFT,RIGHT;
}
public class Player {
    static private int count = 0;
    private final int id;
    private int score =0;
    private int steps= 0;
    private int maxStepallowed = 99999;
    private Position position;
    private Map map;
    public Player(Map map, Position initialPosition){
        count++;
        this.map= map;
        this.position = initialPosition;
        this.id = count;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        count++;
        this.map= map;
        this.position = initialPosition;
        this.maxStepallowed = maxStepAllowed;
        this.id = count;
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

    public int getMaxStepallowed() {
        return maxStepallowed;
    }

    public Position getPosition() {
        return position;
    }
    public boolean move(Direction direction, int steps){
        if (this.map.isActive()){
            if (direction.equals(Direction.UP) &&position.getRow()!=0) {
                
                int i = 0;
                for (;this.map.isActive()&& position.getRow() > 0 &&this.steps<maxStepallowed && i<steps ; i++) {
                    position.setRow(position.getRow()-1);
                    this.steps++;
                    score+=map.getTreasure(position);
                }
                return (i > 0 && i==steps);
            }

            if (direction.equals(Direction.DOWN) &&position.getRow()!=map.getRows()) {
                
                int i = 0;
                for (; this.map.isActive()&&position.getRow() <map.getRows()-1 &&this.steps<maxStepallowed && i<steps ; i++) {
                    position.setRow(position.getRow()+1);
                    this.steps++;
                    score+=map.getTreasure(position);
                }
                return (i > 0 && i==steps);
            }

            if (direction.equals(Direction.LEFT) &&position.getCol()!=0) {
                
                int i = 0;
                for (;this.map.isActive()&& position.getCol() >0 &&this.steps<maxStepallowed && i<steps ; i++) {
                    position.setCol(position.getCol()-1);
                    this.steps++;
                    score+=map.getTreasure(position);
                }
                return (i > 0 && i==steps);
            }

            if (direction.equals(Direction.RIGHT) &&position.getCol()!=map.getColumns()) {
                
                int i = 0;
                for (; this.map.isActive()&&position.getCol() <map.getColumns()-1 &&this.steps<maxStepallowed && i<steps ; ) {
                    position.setCol(position.getCol()+1);
                    this.steps++;
                    score+=map.getTreasure(position);
                    i++;
                }
                return (i > 0 && i==steps);
            }else return false;
        }
        return false;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if (this.id == p.id){
            return true;
        }
        return false;
    }
}
