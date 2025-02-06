
public class Player {
    private final int id;
    static int cnt=0;
    private int score;
    private int steps;
    int maxsteps=Integer.MAX_VALUE;
    private Position position;
    private Map map;
    public void setMap(Map map){
        this.map=map;
    }

    public int getScore() {
        return this.score;
    }
    public int getId(){
        return this.id;
    }
    public Position getPosition(){
        return this.position;
    }
    public int getMaxsteps() {
        return this.maxsteps;
    }

    public int getSteps() {
        return steps;
    }

    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        id=cnt++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxsteps=maxStepAllowed;
        id=cnt++;
    }
    public  boolean move(Direction direction, int steps){
        for(int i=0;i<steps;i++){
            if(this.steps>maxsteps){
                return false;
            }
            if(!map.isActive()){
                return false;
            }
            switch (direction){
                case UP :if(position.getRow()==0){
                    return false;
                };
                position.setRow(position.getRow()-1);
                    break;
                case DOWN :if(position.getRow()==map.getRows()-1)return false;
                    position.setRow(position.getRow()+1);
                    break;
                case LEFT:if(position.getCol()==0){
                    return false;
                }
                    position.setCol(position.getCol()-1);
                    break;
                case RIGHT:if(position.getCol()==map.getColumns()-1) return false;
                    position.setCol(position.getCol()+1);
                    break;
            }
            this.steps++;
            score+=map.hasTreasure(position);
            map.update(position);
        }
        return  true;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if(this.id==p.id){
            return true;
        }else{
            return false;
        }
    }
}
