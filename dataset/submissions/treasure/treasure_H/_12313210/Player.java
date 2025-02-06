

public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int playerCounter = 0;
    int maxStepAllowed=2147483647;

    public Player(Map mapPosition ,Position position) {
        playerCounter++;
        this.position = position;
        this.map = mapPosition;
        id=playerCounter;
        this.steps=0;
        this.score=0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        playerCounter++;
        this.position = initialPosition;
        this.map = map;
        id=playerCounter;
        this.maxStepAllowed=maxStepAllowed;
        this.steps=0;
        this.score=0;
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
        switch (direction) {
            case UP:
                for (int i = 0; i < steps; i++) {
                    if(!map.isActive()){
                        return  false;
                    }else{
                        if(this.steps>=this.maxStepAllowed){
                            return false;
                        }else {
                            if(this.position.getRow()==0){
                                return false;
                            }else {
                                this.steps++;
                                this.position.setRow(this.position.getRow()-1);
                                this.score+= map.hasTreasure(this.position);
                                map.update(this.position);
                            }
                        }
                    }
                }
                return true;
            case DOWN:
                for (int i = 0; i < steps; i++) {
                    if(!map.isActive()){
                        return  false;
                    }else{
                        if(this.steps>=this.maxStepAllowed){
                            return false;
                        }else {
                            if(this.position.getRow()==map.getRows()-1){
                                return false;
                            }else {
                                this.steps++;
                                this.position.setRow(this.position.getRow()+1);
                                this.score+= map.hasTreasure(this.position);
                                map.update(this.position);
                            }
                        }
                    }
                }
                return true;
            case LEFT:
                for (int i = 0; i < steps; i++) {
                    if(!map.isActive()){
                        return  false;
                    }else{
                        if(this.steps>=this.maxStepAllowed){
                            return false;
                        }else {
                            if(this.position.getCol()==0){
                                return false;
                            }else {
                                this.steps++;
                                this.position.setCol(this.position.getCol()-1);
                                this.score+= map.hasTreasure(this.position);
                                map.update(this.position);
                            }
                        }
                    }
                }
                return true;
            case RIGHT:
                for (int i = 0; i < steps; i++) {
                    if(!map.isActive()){
                        return  false;
                    }else{
                        if(this.steps>=this.maxStepAllowed){
                            return false;
                        }else {
                            if(this.position.getCol()==map.getColumns()-1){
                                return false;
                            }else {
                                this.steps++;
                                this.position.setCol(this.position.getCol()+1);
                                this.score+= map.hasTreasure(this.position);
                                map.update(this.position);
                            }
                        }
                    }
                }
                return true;
            default:
                return false;
        }
    }
    public boolean equals(Object player) {
        if (!(player instanceof Player)) {
            return false;
        }
        Player otherPlayer = (Player) player;
        return this.id == otherPlayer.id;
    }
}
