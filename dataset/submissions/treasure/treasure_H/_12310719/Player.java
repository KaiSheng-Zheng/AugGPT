public class Player {
    public static int next=0;
    private final int id=next;

    public void setScore(int score) {
        this.score = score;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    private int score;

    public int getScore() {
        return score;
    }

    private int steps;

    public void setSteps(int steps) {
        this.steps = steps;
    }

    private Position pos;

    public int getSteps() {
        return steps;
    }

    private Map map;

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public Map getMap() {
        return map;
    }

    public Position getPosition() {
        return pos;
    }

    private int maxStepAllowed;
    public Player(Map map, Position initialPos){
        next++;
        this.map=map;
        this.pos=initialPos;
    }
    public Player(Map map, Position initialPos, int maxStepAllowed){
        next++;
        this.map=map;
        this.pos=initialPos;
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
            for(int i=0;i<steps;i++){
                if(map.isActive()==false){
                    return false;
                }
                else {
                    //System.out.println(555);
                if((this.steps+1)>maxStepAllowed&&maxStepAllowed!=0){
                    //System.out.println(666);
                    //System.out.println(0);
                    return false;
                }
                else {
                    switch (direction) {
                        case UP:
                            if(pos.getRow()==0){
                                return false;
                            }
                            pos.setRow(pos.getRow() - 1);
                            break;
                        case DOWN:
                            if(pos.getRow()==map.getRows()-1){
                                return false;
                            }
                            pos.setRow((pos.getRow()) + 1);
                            break;
                        case LEFT:
                            if(pos.getCol()==0){
                                return false;
                            }
                            pos.setCol(pos.getCol() - 1);
                            break;
                        case RIGHT:
                            if(pos.getCol()==map.getColumns()-1){
                                return false;
                            }
                            pos.setCol(pos.getCol() + 1);
                            //System.out.println(999);
                            break;
                    }
                    if (pos.getRow() < 0) {
                        pos.setRow((pos.getRow()) + 1);
                        //setSteps(this.steps+i-1);
                        return false;
                    } else if (pos.getRow() > map.getRows()-1) {
                        pos.setRow(pos.getRow() - 1);
                        //setSteps(this.steps+i-1);
                        return false;
                    } else if (pos.getCol() < 0) {
                        pos.setCol(pos.getCol() + 1);
                        //setSteps(this.steps+i-1);
                        return false;
                    } else if (pos.getCol() > map.getColumns()-1) {
                        pos.setCol(pos.getCol() - 1);
                        //setSteps(this.steps+i-1);
                        return false;
                    } else setSteps(this.steps + 1);
                    score += map.hasTreasure(pos);
                    if (map.hasTreasure(pos) != 0) {
                        map.update(pos);
                    }
                }
                }
            }
            return true;
    }
    public boolean equals(Object player){
        Player player1=(Player) player;
        if(this.id==player1.id)return true;
        else return false;
    }



}
