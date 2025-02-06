public class Player {

    private static  int numberOfPlayer=0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    public Player(Map map, Position initialPosition){
        numberOfPlayer++;
        this.id=numberOfPlayer;
        this.map=map;
        this.position=initialPosition;
        score=0;
        steps=0;
        maxStepAllowed=-1;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        numberOfPlayer++;
        this.id=numberOfPlayer;
        this.map=map;
        this.position=initialPosition;
        score=0;
        steps=0;
        this.maxStepAllowed=maxStepAllowed;
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
    public boolean move(Direction direction, int steps){
        int temp = this.steps;
        int m=0;
        for (int i = 0; i < steps; i++) {
            if(map.isActive()){
                if (maxStepAllowed<0||temp + i+1 <= maxStepAllowed) {
                    if(position.getRow() + direction.getAddRow()>=0&&position.getRow() + direction.getAddRow()<=map.getRows()-1&&position.getCol() + direction.getAddCol()>=0&&position.getCol() + direction.getAddCol()<=map.getColumns()-1) {
                        this.position.setRow(position.getRow() + direction.getAddRow());
                        this.position.setCol(position.getCol() + direction.getAddCol());

                        score+=map.hasTreasure(position);
                        map.update(position);
                       m++;

                    }else {
                        break;
                    }

                } else {
                    break;
                }
            } else {
                break;
            }
        }

        this.steps+=m;

        if(m==steps){
            return true;
        }else {
            return false;
        }

    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if(this.id==p.getId()){
            return true;
        }else{
            return false;
        }
    }
}

