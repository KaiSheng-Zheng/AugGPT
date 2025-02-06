public class Player {
    private final int id;
    public static int num;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed=999999999;
    private int count=0;


    public Player(Map map, Position initialPosition) {
        this.position = initialPosition;
        this.map = map;
        this.id=++num;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        this.id=++num;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return count;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        for (int i = 0; i < steps; i++) {
            if(!map.isActive()||count>=maxStepAllowed){
                return false;
            }else{
                switch (direction){
                    case LEFT:{
                        if(this.position.getCol()==0){
                            return false;
                        }
                       else{ this.position.setCol(this.position.getCol()-1);
                           count++;
                           this.setScore(this.getScore()+ map.hasTreasure(this.position));
                            if(map.hasTreasure(this.position)!=0){
                                map.update(this.position);
                            }
                           break;
                       }
                    }
                    case RIGHT:{
                        if(this.position.getCol()==map.getColumns()-1){
                            return false;
                        }
                       else{ this.position.setCol(this.position.getCol()+1);
                            count++;
                            this.setScore(this.getScore()+ map.hasTreasure(this.position));
                            if(map.hasTreasure(this.position)!=0){
                                map.update(this.position);
                            }
                           break;
                       }
                    }
                    case UP:{
                        if(this.position.getRow()==0){
                            return false;
                        }
                       else{ this.position.setRow(this.position.getRow()-1);
                            count++;
                            this.setScore(this.getScore()+ map.hasTreasure(this.position));
                            if(map.hasTreasure(this.position)!=0){
                                map.update(this.position);
                            }
                           break;
                       }
                    }
                    case DOWN:{
                        if(this.position.getRow()==map.getRows()-1){
                            return false;
                        }
                       else{ this.position.setRow(this.position.getRow()+1);
                            count++;
                            this.setScore(this.getScore()+ map.hasTreasure(this.position));
                            if(map.hasTreasure(this.position)!=0){
                                map.update(this.position);
                            }
                           break;
                       }
                    }
                }
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id==p.id;
    }
}
