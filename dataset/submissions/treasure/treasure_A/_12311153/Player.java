public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private  int maxSteps;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter() {
        Player.counter = 0;
    }

    public static int counter;

    public Player(Map map,Position initialposition) {
        this.position = initialposition;
        this.map = map;
        counter++;
        this.id=counter;
        this.maxSteps=-1;
    }
    public Player(Map map,Position initialposition,int maxStepAllowed) {
        this.position = initialposition;
        this.map = map;
        counter++;
        this.id=counter;
        this.maxSteps=maxStepAllowed;
    }
    public Player(Player player1){
        this.position=player1.getPosition();
        this.id= player1.getId();
        this.map=player1.getMap();
        this.maxSteps=player1.getMaxSteps();
        this.position=player1.getPosition();
        this.score=player1.getScore();
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public Map getMap() {
        return map;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }

    public boolean move(Direction direction, int steps){
        int s=steps;
       if (map.isActive()){
            if (getMaxSteps()==-1){
                if (isOutBoundary(direction)){
                    return false;
                }else {
                    while (map.isActive()&&s>0&&!isOutBoundary(direction)){
                        getPosition().setCol(getPosition().getCol()+direction.getCol());
                        getPosition().setRow(getPosition().getRow()+direction.getRow());
                        getPoint(position);
                        s--;
                    }
                    setSteps(this.getSteps()+steps-s);
                    if (s==0){
                        return true;
                    }else return false;
                }
            }else if (getMaxSteps()!=0){
                if (steps<maxSteps){
                    if (isOutBoundary(direction)){
                        return false;
                    }else{
                        while (map.isActive()&&s>0&&!isOutBoundary(direction)&&getSteps()<getMaxSteps()){
                            getPosition().setCol(getPosition().getCol()+direction.getCol());
                            getPosition().setRow(getPosition().getRow()+direction.getRow());
                            getPoint(position);
                            setSteps(getSteps()+1);
                            s--;
                        }
                        if (s==0){
                            return true;
                        }else return false;

                    }


                }

            }
       }
        return false;
    }

    public boolean isOutBoundary(Direction direction){
        if (getPosition().getRow()==0&&direction.equals(Direction.UP)){
            return true;
        } else if (getPosition().getRow()==map.getRows()&&direction.equals(Direction.DOWN)) {
            return true;
            
        }else if (getPosition().getCol()==0&&direction.equals(Direction.LEFT)){
            return true;
        }else if (getPosition().getCol()==map.getColumns()&&direction.equals(Direction.RIGHT)){
            return true;
        }
return false;

    }

    public void getPoint(Position p){
        int point=map.hasTreasure(p);
        setScore(point+this.score);
        if (point!=0){
            map.update(p);

        }

         }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean equals(Object player){
        Player p =(Player) player;
        if (this.id==p.getId()){
            return true;
        }
        return false;
    }
}
