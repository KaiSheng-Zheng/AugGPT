class Player {
    private final int id;
    private int score=0;
    private int steps;
    private Position position;
    private Map map;
    private static int theID=0;
    private int maxStepAllowed;

    public static void setTheID(int inputID){
        theID=inputID;
    }

    public static int getTheID(){
        return theID;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player(Map map, Position initialPosition){
        theID+=1;
        id=theID;
        this.map=map;
        this.position=initialPosition;
        maxStepAllowed=2147483647;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public int getId() {
        return id;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        theID+=1;
        id=theID;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
    }



    public boolean move(Direction direction, int steps){
        if(maxStepAllowed<=0){
            return false;
        }
        switch(direction) {
            // must be unqualified name of the enum constant
            case UP:
                for (int n=0;n<steps;n++){
                    if(maxStepAllowed<=0){
                        return false;
                    }
                    if(!(map.isActive())){
                        return false;
                    }
                    if(position.getRow()-1<0){

                        return false;
                    }
                    position.setRow(position.getRow()-1);
                    this.steps+=1;
                    score+=map.hasTreasure(position);
                    map.update(position);
                    maxStepAllowed--;
                }

                return true;

            case DOWN:
                for (int n=0;n<steps;n++){
                    if(maxStepAllowed<=0){
                        return false;
                    }
                    if(!(map.isActive())){

                        return false;
                    }
                    if(position.getRow()+1>map.getRows()-1){

                        return false;
                    }
                    position.setRow(position.getRow()+1);
                    this.steps+=1;
                    score+=map.hasTreasure(position);
                    map.update(position);
                    maxStepAllowed--;
                }

                return true;

            case LEFT:
                for (int n=0;n<steps;n++){
                    if(maxStepAllowed<=0){
                        return false;
                    }
                    if(!(map.isActive())){
                        return false;
                    }
                    if(position.getCol()-1<0){

                        return false;
                    }
                    position.setCol(position.getCol()-1);
                    this.steps+=1;
                    score+=map.hasTreasure(position);
                    map.update(position);
                    maxStepAllowed--;
                }

                return true;

            case RIGHT:
                for (int n=0;n<steps;n++){
                    if(maxStepAllowed<=0){
                        return false;
                    }
                    if(!(map.isActive())){
                        return false;
                    }
                    if(position.getCol()+1>map.getColumns()-1){

                        return false;
                    }
                    position.setCol(position.getCol()+1);
                    this.steps+=1;
                    score+=map.hasTreasure(position);
                    map.update(position);
                    maxStepAllowed--;
                }

                return true;

        }
        return false;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if(this.id==p.id){
            return true;
        }
        else {
            return false;
        }
    }
    public void stepnum(){
        System.out.println(steps);
    }
    public void playerPos(){
        System.out.printf("%d,%d\n",this.position.getRow(),this.position.getCol());
    }

}
