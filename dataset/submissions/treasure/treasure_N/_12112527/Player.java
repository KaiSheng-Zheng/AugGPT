

public class Player {
    private final int id;
    private  int score;
    private  int steps=0;
    private Position position;

    private Map map;
    public int maxStepAllowed = 999;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position =initialPosition;
        id = initialPosition.getCol()*initialPosition.getRow()+2*initialPosition.getRow();
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position = initialPosition;
        id = initialPosition.getCol()*initialPosition.getRow()+2*initialPosition.getRow();
        this.maxStepAllowed = maxStepAllowed;
    }

    public int getId() {
        return this.id;
    }

    public  int getScore() {
        return score;
    }

    public  int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }

    public Map getMap() {
        return map;
    }

    public  int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public  void setScore(int score) {
        this.score = score;
    }

    public  void setSteps(int steps) {
        this.steps = steps;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public  void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps){
        if (direction.equals(Direction.DOWN)){
            for (int i = 0;i<steps;i++){
                if (!map.isActive()){
                    return false;
                }
                if (this.getMaxStepAllowed()<1){
                    return false;
                }
                if (this.getPosition().getRow()+1>map.getRows()){
                    return false;
                }else {
                    Position s = new Position(this.getPosition().getRow()+1,this.getPosition().getCol());
                    this.setPosition(s);
                    int a = this.getScore();
                    this.setScore(map.hasTreasure(s)+a);
                    this.setSteps(this.getSteps()+1);
                    map.update(s);
                    this.setMaxStepAllowed(this.getMaxStepAllowed()-1);
                }
            }
            return true;
        }
        if (direction.equals(Direction.UP)){
            for (int i = 0;i<steps;i++){
                if (!map.isActive()){
                    return false;
                }
                if (this.getMaxStepAllowed()<1){
                    return false;
                }
                if (this.getPosition().getRow()-1<0){
                    return false;
                }else {
                    Position s = new Position(this.getPosition().getRow()-1,this.getPosition().getCol());
                    this.setPosition(s);
                    int a = this.getScore();
                    this.setScore(map.hasTreasure(s)+a);
                    this.setSteps(this.getSteps()+1);
                    map.update(s);
                    this.setMaxStepAllowed(this.getMaxStepAllowed()-1);
                }
            }
            return true;
        }
        if (direction.equals(Direction.RIGHT)){
            for (int i = 0;i<steps;i++){
                if (!map.isActive()){
                    return false;
                }
                if (this.getMaxStepAllowed()<1){
                    return false;
                }
                if (this.getPosition().getCol()+1>map.getColumns()){
                    return false;
                }else {
                    Position s = new Position(this.getPosition().getRow(),this.getPosition().getCol()+1);
                    this.setPosition(s);
                    int a = this.getScore();
                    this.setScore(map.hasTreasure(s)+a);
                    this.setSteps(this.getSteps()+1);
                    map.update(s);
                    this.setMaxStepAllowed(this.getMaxStepAllowed()-1);
                }
            }
            return true;
        }
        if (direction.equals(Direction.LEFT)){
            for (int i = 0;i<steps;i++){
                if (!map.isActive()){
                    return false;
                }
                if (this.getMaxStepAllowed()<1){
                    return false;
                }
                if (this.getPosition().getCol()-1<0){
                    return false;
                }else {
                    Position s = new Position(this.getPosition().getRow(),this.getPosition().getCol()-1);
                    this.setPosition(s);
                    int a = this.getScore();
                    this.setScore(map.hasTreasure(s)+a);
                    this.setSteps(this.getSteps()+1);
                    map.update(s);
                    this.setMaxStepAllowed(this.getMaxStepAllowed()-1);
                }
            }
            return true;
        }
        return false;

    }
    public boolean equals(Object player){
        if (player instanceof Player){
            return this.id== ((Player) player).getId();
        }
        return false;
    }

}
