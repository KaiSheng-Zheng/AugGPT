

public class Player {
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    static int cnt=0;
    private int maxStepAllowed;
    public Player(Map map, Position initialPosition){
        cnt++;
        this.id=cnt;
        this.map=map;
        this.steps=0;
        this.score=0;
        this.maxStepAllowed=-1;
        this.position=initialPosition;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        cnt++;
        this.id=cnt;
        this.position=initialPosition;
        this.score=0;
        this.map=map;
        this.maxStepAllowed=maxStepAllowed;
        this.steps=0;
    }



    public boolean move(Direction direction, int steps){
        if (!map.isActive()||maxStepAllowed == 0){
            return false;
        }
        if(direction.equals(Direction.UP)){
            for (int i = 1; i < steps+1; i++) {
                if (this.position.getRow() - 1 < 0){
                    return false;
                }else{
                    position.setRow(position.getRow() -1);
                    this.steps+=1;
                    maxStepAllowed-=1;
                    this.score+=map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||maxStepAllowed == 0){
                        if(i==steps){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return true;
        } else if (direction.equals(Direction.DOWN)) {
            for (int i = 1; i < steps+1; i++) {
                if (this.position.getRow() + 1 >= this.map.getRows()){
                    return false;
                }else {
                    this.position.setRow(this.position.getRow() + 1);
                    this.steps+=1;
                    maxStepAllowed-=1;
                    score += map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||maxStepAllowed == 0){
                        if(i==steps){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }return true;
        }else if (direction.equals(Direction.LEFT)){
            for (int i = 1; i < steps+1; i++) {
                if (this.position.getCol() - 1 < 0){
                    return false;
                }else {
                    this.position.setCol(this.position.getCol() - 1);
                    this.steps+=1;
                    maxStepAllowed-=1;
                    score += map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||maxStepAllowed == 0){
                        if(i==steps){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return true;
        }else if (direction.equals(Direction.RIGHT)){
            for (int i = 1; i < steps+1; i++) {
                if (this.position.getCol() + 1 >= this.map.getColumns()) {
                    return false;
                }else{
                    this.position.setCol(this.position.getCol() + 1);
                    maxStepAllowed-=1;
                    this.steps+=1;
                    this.score += map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||maxStepAllowed == 0){
                        if(i==steps){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return true;
    }

    public int getId() {
        return id;
    }
    public Position getPosition() {
        return position;
    }

    public boolean equals(Object player){
        if (player instanceof Player pl &&this.id == pl.id ) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }
}
