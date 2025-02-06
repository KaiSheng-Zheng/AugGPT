public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxstep=Integer.MAX_VALUE;
    private static int a=1;


    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.id=a;
        a++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxstep=maxStepAllowed;
        this.id=a;
        a++;
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
    public void setScore(int a){
        this.score=a;
    }
    public Position getPosition(){
        return position;
    }
    public boolean move(Direction direction, int steps){
        for(int i=0;i<steps;i++){
            if(this.steps==maxstep){
                return false;
            }
            if(!map.isActive()){
                return  false;
            }
            switch (direction){
                case UP -> {
                    if(position.getrow()==0){
                        return  false;
                    }
                    position.setrow(position.getrow()-1);
                }
                case DOWN -> {
                    if(position.getrow()==map.getrows()){
                        return false;
                    }
                    position.setrow(position.getrow()+1);
                }
                case LEFT -> {
                    if(position.getcol()==0){
                        return false;
                    }
                    position.setcol(position.getcol()-1);
                }
                case RIGHT -> {
                    if(position.getcol()==map.getcols()){
                        return  false;
                    }
                    position.setcol(position.getcol()+1);
                }
            }
            setScore(this.score+ map.hasTreasure(position));
            map.update(position);
            this.steps++;
        }
            return true;
        }

    public boolean equals(Object player){
        Player p = (Player) player;
        if(p.getId()==id){
            return true;
        }
        else{
            return false;
        }

    }
}