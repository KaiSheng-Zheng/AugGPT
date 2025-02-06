public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    private int maxStepAllowed;

    public int getMaxStepAllowed(){
        return maxStepAllowed;
    }

    private static int i=0;

    public int getId(){
        return id;
    }
    public int getScore(){
        return score;
    }

    public void setScore(int A) {
        score = score+A;
    }

    public int getSteps(){
        return steps;
    }


    public void setSteps(int A){
        steps=steps+A;
    }
    public Position getPosition(){
        return position;
    }

    public Player(Map map,Position initialPosition){
        i++;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=10000000;
        id=i;
    }

    public Player(Map map,Position initialPosition,int maxStepAllowed){
        i++;
        this.map=map;
        this.position=initialPosition;
        id=i;
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction,int steps){
        if(!map.isActive()){
            return false;
        }else if(direction==Direction.UP&&getPosition().getRow()==0){
            return false;
        }else if(direction==Direction.DOWN&&getPosition().getRow()== map.getRows()){
            return false;
        }else if(direction==Direction.LEFT&&getPosition().getCol()==0){
            return false;
        }else if(direction==Direction.RIGHT&&getPosition().getCol()==map.getColumns()){
            return false;//cannot move at all
        }else {
            if(direction==Direction.UP){
                if(getPosition().getRow()==0){
                    return false;
                }
                if(getSteps()>=getMaxStepAllowed()){
                    return false;
                }
                if(!map.isActive()){
                    return false;
                }
                int A=map.hasTreasure(position);
                setScore(A);
                if(A!=0){
                    map.update(position);
                }
                for(int i=0;i<steps;i++){
                    getPosition().setRow(-1);
                    int B=map.hasTreasure(position);
                    setScore(B);
                    setSteps(1);
                    if(B!=0) {
                        map.update(position);
                    }
                    if(!map.isActive()){
                        return false;
                    }
                    if(getSteps()>=getMaxStepAllowed()){
                        return false;
                    }
                    if(getPosition().getRow()==0&&i!=steps-1){
                        return false;
                    }
                }
                return true;
            }else if(direction==Direction.DOWN){
                if(getPosition().getRow()== map.getRows()-1){
                    return false;
                }
                if(getSteps()>=getMaxStepAllowed()){
                    return false;
                }
                if(!map.isActive()){
                    return false;
                }
                int A=map.hasTreasure(position);
                setScore(A);
                if(A!=0){
                    map.update(position);
                }
                for(int i=0;i<steps;i++){
                    getPosition().setRow(1);
                    int B=map.hasTreasure(position);
                    setScore(B);
                    setSteps(1);
                    if(B!=0) {
                        map.update(position);
                    }
                    if(!map.isActive()){
                        return false;
                    }
                    if(getSteps()>=getMaxStepAllowed()){
                        return false;
                    }
                    if(getPosition().getRow()==map.getRows()-1&&i!=steps-1){
                        return false;
                    }
                }
                return true;
            }else if(direction==Direction.LEFT){
                if(getPosition().getCol()==0){
                    return false;
                }
                if(getSteps()>=getMaxStepAllowed()){
                    return false;
                }
                if(!map.isActive()){
                    return false;
                }
                int A=map.hasTreasure(position);
                setScore(A);
                if(A!=0){
                    map.update(position);
                }
                for(int i=0;i<steps;i++){
                    getPosition().setCol(-1);
                    int b=map.hasTreasure(position);
                    setScore(b);
                    setSteps(1);
                    if(b!=0) {
                        map.update(position);
                    }
                    if(!map.isActive()){
                        return false;
                    }
                    if(getSteps()>=getMaxStepAllowed()){
                        return false;
                    }
                    if(getPosition().getCol()==0&&i!=steps-1){
                        return false;
                    }
                }
                return true;
            }else{
                if(getPosition().getCol()==map.getColumns()-1){
                    return false;
                }
                if(getSteps()>=getMaxStepAllowed()){
                    return false;
                }
                if(!map.isActive()){
                    return false;
                }
                int A=map.hasTreasure(position);
                setScore(A);
                if(A!=0){
                    map.update(position);
                }
                for(int i=0;i<steps;i++){
                    getPosition().setCol(1);
                    int b=map.hasTreasure(position);
                    setScore(b);
                    setSteps(1);
                    if(b!=0) {
                        map.update(position);
                    }
                    if(!map.isActive()){
                        return false;
                    }
                    if(getSteps()>=getMaxStepAllowed()){
                        return false;
                    }
                    if(getPosition().getCol()== map.getColumns()-1&&i!=steps-1){
                        return false;
                    }

                }
                return true;
            }
        }
    }
    public boolean equals(Object player){
        Player B=(Player) player;
        if(this.getId()==B.getId()){
            return true;
        }else return false;
    }
}
