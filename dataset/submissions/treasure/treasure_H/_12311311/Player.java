public class Player {
    private final int id;
    private int score;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    private static int counter = 0;

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        counter++;
        this.id = counter;
        this.maxStepAllowed = 65535;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed =maxStepAllowed;
        counter++;
        this.id = counter;
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

    public boolean move(Direction direction, int steps){
        for (int i = 0; i < steps; i++) {
            if (!map.isActive()){
                return false;
            }else if ((this.steps + 1) > maxStepAllowed){
                return false;
            }else if (direction == Direction.UP && position.getRow()- 1 < 0){
                return false;
            }else if (direction == Direction.DOWN && position.getRow()+1 > map.getRows()-1){
                return false;
            }else if (direction == Direction.LEFT && position.getCol()-1 < 0){
                return false;
            }else if (direction == Direction.RIGHT && position.getCol()+1 > map.getColumns()-1){
                return false;
            }else {
                if (direction == Direction.UP){
                    position.setRow(position.getRow() - 1);
                }else if (direction == Direction.DOWN){
                    position.setRow(position.getRow() + 1);
                }else if (direction == Direction.LEFT){
                    position.setCol(position.getCol() - 1);
                }else {
                    position.setCol(position.getCol() + 1);
                }
                this.score += map.hasTreasure(position);
                map.update(position);
                this.steps ++;
            }
        }
        return true;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.id == this.id){
            return true;
        }else {
            return false;
        }
    }
}