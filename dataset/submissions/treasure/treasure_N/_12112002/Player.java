public class Player {

    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    static int count=0;


    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position=initialPosition;
        this.maxStepAllowed=-1;
        this.id=++count;
    }


    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        this.id=++count;
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
        int m;

        for(m=0;m<steps;m++){

            if(map.isActive()==false){
                return false;
            }

            if(maxStepAllowed!=-1&&this.steps+1>maxStepAllowed){
                return false;
            }

            if(direction==Direction.UP) {
                if(position.getRow()-1<0){
                    return false;
                }else{
                    position.setRow(position.getRow()-1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }

            if(direction==Direction.DOWN) {
                if(position.getRow()+1>=map.getRows()){
                    return false;
                }else{
                    position.setRow(position.getRow()+1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }


            if(direction==Direction.RIGHT) {
                if(position.getCol()+1>= map.getColumns()){
                    return false;
                }else{
                    position.setCol(position.getCol()+1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }

            if(direction==Direction.LEFT) {
                if(position.getCol()-1<0){
                    return false;
                }else{
                    position.setCol(position.getCol()-1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }
        }
        if(m==steps){
            return true;
        }else {
            return false;
        }
    }


    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id == p.id;
    }

}
