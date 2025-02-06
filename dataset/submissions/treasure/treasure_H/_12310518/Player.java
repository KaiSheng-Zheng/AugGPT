public class Player{
    private final int id=count;
    static int count=0;
    private int score = 0;
    private int steps;
    private final int maxStepAllowed;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        steps = 0;
        maxStepAllowed = Integer.MAX_VALUE;
        count++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        steps = 0;
        count++;
    }

    public boolean move(Direction direction, int steps) {
        Direction D1=Direction.UP;
        Direction D2=Direction.DOWN;
        Direction D3=Direction.LEFT;
        Direction D4=Direction.RIGHT;

        for (int i = 0; i < steps; i++) {
            if (map.isActive()){
                if (direction.equals(D1)){
                    position.setRow(position.getRow()-1);
                }
                if (direction.equals(D2)){
                    position.setRow(position.getRow()+1);
                }
                if (direction.equals(D3)){
                    position.setCol(position.getCol()-1);
                }
                if (direction.equals(D4)){
                    position.setCol(position.getCol()+1);
                }
                if (position.getRow()<0){
                    position.setRow(position.getRow()+1);
                    return false;
                }else if (position.getRow()> map.getRows()-1){
                    position.setRow(position.getRow()-1);
                    return false;
                }else if (position.getCol()<0){
                    position.setCol(position.getCol()+1);
                    return false;
                }else if (position.getCol()> map.getColumns()-1){
                    position.setCol(position.getCol()-1);
                    return false;
                } else if (this.steps >= maxStepAllowed) {
                    if (direction.equals(D1)){
                        position.setRow(position.getRow()+1);
                    }
                    if (direction.equals(D2)){
                        position.setRow(position.getRow()-1);
                    }
                    if (direction.equals(D3)){
                        position.setCol(position.getCol()+1);
                    }
                    if (direction.equals(D4)){
                        position.setCol(position.getCol()-1);
                    }
                    return false;
                } else {
                    this.steps++;
                }
                Treasure[] treasures= map.getTreasures().clone();
                for (int j = 0; j < map.getTreasures().length; j++) {
                    if (position.equals(treasures[j].getPosition())){
                        score += map.hasTreasure(treasures[j].getPosition());
                        map.update(treasures[j].getPosition());
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        if (player instanceof Player) {
            Player player1 = (Player) player;
            if (player1.id==id){
                return true;
            }
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public int getSteps() {
        return steps;
    }
}
