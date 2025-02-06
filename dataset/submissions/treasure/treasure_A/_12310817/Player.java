public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxStepAllowed=-1;
    static int cnt=0;
    public Player(Map map, Position initialPosition){
        this.map=map;position=initialPosition;
        cnt++;id=cnt;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;position=initialPosition;this.maxStepAllowed=maxStepAllowed;
        cnt++;id=cnt;
    }
    public int getId(){
        return id;
    }
    public int getScore(){
        return score;
    }
    public int getSteps() {
        return steps;
    }
    public Position getPosition() {
        return position;
    }
    public boolean move(Direction direction, int steps){
        if(!map.isActive()){
            return false;
        }

        if(position.getRow()+direction.getRowStep()<0||position.getRow()+direction.getRowStep()>=map.getRows()||position.getCol()+direction.getColStep()<0||position.getCol()+direction.getColStep()>=map.getColumns()){
            return false;
        }

        if(this.steps==maxStepAllowed){
            return false;
        }

        if(position.getRow()+direction.getRowStep()*steps<0||position.getRow()+direction.getRowStep()*steps>=map.getRows()||position.getCol()+direction.getColStep()*steps<0||position.getCol()+direction.getColStep()*steps>=map.getColumns()){
            for(int i=0;i<steps;i++){
                if(map.isActive()&&!(position.getRow()+direction.getRowStep()<0||position.getRow()+direction.getRowStep()>=map.getRows()||position.getCol()+direction.getColStep()<0||position.getCol()+direction.getColStep()>=map.getColumns())){
                    int r=position.getRow();int c=position.getCol();
                    position.setRow(r+=direction.getRowStep());position.setCol(c+=direction.getColStep());
                    score+=map.hasTreasure(position);
                    if(map.hasTreasure(position)!=0){
                        map.update(position);
                    }
                    this.steps++;
                    if(this.steps==maxStepAllowed||!map.isActive()){
                        return false;
                    }
                }
            }
            return false;
        }

        for(int i=0;i<steps;i++){
            int r=position.getRow();int c=position.getCol();
            position.setRow(r+=direction.getRowStep());position.setCol(c+=direction.getColStep());
            score+=map.hasTreasure(position);
            if(map.hasTreasure(position)!=0){
                map.update(position);
            }
            this.steps++;
            if(this.steps==maxStepAllowed||!map.isActive()){
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player p=(Player)player;
        return p.getId()==this.id;
    }
}