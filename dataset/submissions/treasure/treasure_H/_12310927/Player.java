public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private final int maxStepAllowed;
    public static int player=0;

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

    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        maxStepAllowed=-1;
        score=0; steps=0;
        id=++player;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        score=0; steps=0;
        id=++player;
    }
    public boolean move(Direction direction, int steps){
            for(int flag=1;flag<=steps;flag++){
                if(!map.isActive()){
                    return false;
                }else {
                    if (this.steps == maxStepAllowed) {
                        return false;
                    } else {
                        switch (direction) {
                            case UP:
                                if (!(this.position.getRow() == 0)) {
                                    this.position.setRow(this.position.getRow() - 1);
                                    if (map.hasTreasure(this.position) != 0) {
                                        score += map.hasTreasure(this.position);
                                        map.update(this.position);
                                    }
                                    this.steps++;
                                    break;
                                } else {
                                    return false;
                                }
                            case DOWN:
                                if (!(this.position.getRow() == map.getRows() - 1)) {
                                    this.position.setRow(this.position.getRow() + 1);
                                    if (map.hasTreasure(this.position) != 0) {
                                        score += map.hasTreasure(this.position);
                                        map.update(this.position);
                                    }
                                    this.steps++;
                                    break;
                                } else {
                                    return false;
                                }
                            case LEFT:
                                if (!(this.position.getCol() == 0)) {
                                    this.position.setCol(this.position.getCol() - 1);
                                    if (map.hasTreasure(this.position) != 0) {
                                        score += map.hasTreasure(this.position);
                                        map.update(this.position);
                                    }
                                    this.steps++;
                                    break;
                                } else {
                                    return false;
                                }
                            case RIGHT:
                                if (!(this.position.getCol() == map.getColumns() - 1)) {
                                    this.position.setCol(this.position.getCol() + 1);
                                    if (map.hasTreasure(this.position) != 0) {
                                        score += map.hasTreasure(this.position);
                                        map.update(this.position);
                                    }
                                    this.steps++;
                                    break;
                                } else {
                                    return false;
                                }
                        }
                    }
                }
            }
            return true;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        if(getId()==p.getId()){
            return true;
        }else {
            return false;
        }
    }
}