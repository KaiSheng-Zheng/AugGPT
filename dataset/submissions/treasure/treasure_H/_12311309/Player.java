public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int count=0;

    public Player( Map map,Position initialPosition) {
        this.map = map;
        this.position=initialPosition;
        this.id=++count;
        this.maxStepAllowed=-1;
        score=0;
        steps=0;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.id=++count;
        this.maxStepAllowed=maxStepAllowed;
        score=0;
        steps=0;
    }
    public boolean move(Direction direction, int steps){
        if(map.isActive()){
            if(maxStepAllowed>=0){
            if(this.steps<maxStepAllowed) {
            int steps1=this.steps + steps;
                if (steps1<= maxStepAllowed) {
                    switch (direction){
                        case UP :
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                                if(position.getRow()-1>=0){
                                    int r1=position.getRow();
                                    position.setRow(r1-1);
                                score+= map.hasTreasure(position);
                                map.update(position);
                                this.steps+=1;}else return false;
                            }else return false;}
                            return true;
                        case DOWN:
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                            if(position.getRow()+1<map.getRows()){
                                int r1=position.getRow();
                                position.setRow(r1+1);
                                score+= map.hasTreasure(position);
                                map.update(position);
                                this.steps+=1;}else return false;
                            }else return false;}
                         return true;
                        case LEFT:
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                                if(position.getCol()-1>=0){
                            int c1=position.getCol();
                            position.setCol(c1-1);
                            score+= map.hasTreasure(position);
                            map.update(position);
                            this.steps+=1;}else return false;
                        }else return false;}
                            return true;
                        case RIGHT:
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                                if(position.getCol()+1<map.getColumns()){
                                    int c1=position.getCol();
                                    position.setCol(c1+1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            return true;
                    }
                }else {
                    int steps2=maxStepAllowed-this.steps;
                    switch (direction){
                        case UP :
                            for(int i=0;i<steps2;i++){
                                if(map.isActive()){
                                if(position.getRow()-1>=0){
                                    int r1=position.getRow();
                                    position.setRow(r1-1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            break;
                        case DOWN:
                            for(int i=0;i<steps2;i++){
                                if(map.isActive()){
                                if(position.getRow()+1<map.getRows()){
                                    int r1=position.getRow();
                                    position.setRow(r1+1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            break;
                        case LEFT:
                            for(int i=0;i<steps2;i++){
                                if(map.isActive()){
                                if(position.getCol()-1>=0){
                                    int c1=position.getCol();
                                    position.setCol(c1-1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                           break;
                        case RIGHT:
                            for(int i=0;i<steps2;i++){
                                if(map.isActive()){
                                if(position.getCol()+1<map.getColumns()){
                                    int c1=position.getCol();
                                    position.setCol(c1+1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            break;
                    }return false;
                }
            }else return false;
            }else {
                    switch (direction){
                        case UP :
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                                if(position.getRow()-1>=0){
                                    int r1=position.getRow();
                                    position.setRow(r1-1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            return true;
                        case DOWN:
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                                if(position.getRow()+1<map.getRows()){
                                    int r1=position.getRow();
                                    position.setRow(r1+1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            return true;
                        case LEFT:
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                                if(position.getCol()-1>=0){
                                    int c1=position.getCol();
                                    position.setCol(c1-1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            return true;
                        case RIGHT:
                            for(int i=0;i<steps;i++){
                                if(map.isActive()){
                                if(position.getCol()+1<map.getColumns()){
                                    int c1=position.getCol();
                                    position.setCol(c1+1);
                                    score+= map.hasTreasure(position);
                                    map.update(position);
                                    this.steps+=1;}else return false;
                                }else return false;}
                            return true;
                    }
            }
        }
        return false;
    }
    public boolean equals(Object player){
Player p=(Player) player;
return this.id==p.id;
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
        return steps;
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
}
