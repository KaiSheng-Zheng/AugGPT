public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private  int maxStepAllowed;
    static int count=0;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=-1;
        count+=1;
        id=count;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        count+=1;
        id=count;
    }
    public int getId(){
        return id;
    }
    public int getScore(){
        return score;
    }
    public int getSteps(){
        return steps;
    }
    public Position getPosition(){
        return position;
    }
    public boolean move(Direction direction, int steps) {
        boolean a = true;

            if (maxStepAllowed <= steps&maxStepAllowed>=0) {
                a = false;
                steps = maxStepAllowed;
            }
        if (!map.isActive()) {
            return false;
        }
            switch (direction) {
                case RIGHT -> { // must be unqualified name of the enum constant
                    for (int i = 0; i < steps; i++) {
                        if (position.getCol() + 1 < map.getCol()) {
                            position.setCol(position.getCol() + 1);
                            maxStepAllowed-=1;
                            this.steps+=1;
                            score += map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                if(maxStepAllowed>0|i!=steps-1){
                                    a=false;
                                }
                                break;
                            }
                        } else {
                            a = false;
                        }
                    }
                    break;
                }
                case LEFT -> {
                    for (int i = 0; i < steps; i++) {
                        if (position.getCol() - 1 >= 0) {
                            position.setCol(position.getCol() - 1);
                            maxStepAllowed-=1;
                            this.steps+=1;
                            score += map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                if(maxStepAllowed>0|i!=steps-1){
                                    a=false;
                                }
                                break;
                            }
                        } else {
                            a = false;
                        }
                    }
                    break;
                }
                case DOWN -> {
                    for (int i = 0; i < steps; i++) {
                        if (position.getRow() + 1 < map.getRow()) {
                            position.setRow(position.getRow() + 1);
                            maxStepAllowed-=1;
                            this.steps+=1;
                            score += map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                if(maxStepAllowed>0|i!=steps-1){
                                    a=false;
                                }
                                break;
                            }
                        } else {
                            a = false;
                        }
                    }
                    break;
                }
                case UP -> {
                    for (int i = 0; i < steps; i++) {
                        if (position.getRow() - 1 >= 0) {
                            position.setRow(position.getRow() - 1);
                            maxStepAllowed-=1;
                            this.steps+=1;
                            score += map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                if(maxStepAllowed>0|i!=steps-1){
                                    a=false;
                                }
                                break;
                            }
                        } else {
                            a = false;
                        }
                    }
                    break;
                }
            }
            return a;
        }
    public boolean equals(Object player){
        Player p=(Player) player;
        return p.getId()==this.id;
    }
}
