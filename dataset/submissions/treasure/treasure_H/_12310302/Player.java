public class Player {
    public static int ids=0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int max;
    public Player(Map map, Position initialPosition){
        this.map=map;this.position=initialPosition;this.max=Integer.MAX_VALUE;id=ids;ids++;this.steps=0;this.score=0;
        //System.out.println(this.id);
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;this.position=initialPosition;this.max=maxStepAllowed;id=ids;ids++;this.steps=0;this.score=0;
        //System.out.println(this.id);
    }
    public int getId(){
        return this.id;
    }
    public int getScore(){
        return this.score;
    }
    public int getSteps(){
        return this.steps;
    }
    public int getMax(){
        return this.max;
    }
    public Position getPosition(){
        return this.position;
    }
    public boolean move(Direction direction, int step){
        for(int i=0;i<step;i++){
            if(this.map.isActive()&&this.steps<max){
                switch(direction){
                    case UP:{
                        if(this.position.getRow()>0){
                            this.position.setRow(this.position.getRow()-1);
                            this.score+=this.map.hasTreasure(this.position);
                            this.map.update(this.position);
                            this.steps++;
                        }
                        else{
                            return false;
                        }
                        break;
                    }
                    case DOWN:{
                        if(this.position.getRow()<this.map.getRows()-1){
                            this.position.setRow(this.position.getRow()+1);
                            this.score+=this.map.hasTreasure(this.position);
                            this.map.update(this.position);
                            this.steps++;
                        }
                        else{
                            return false;
                        }
                        break;
                    }
                    case LEFT:{
                        if(this.position.getCol()>0){
                            this.position.setCol(this.position.getCol()-1);
                            this.score+=this.map.hasTreasure(this.position);
                            this.map.update(this.position);
                            this.steps++;
                        }
                        else{
                            return false;
                        }
                        break;
                    }
                    case RIGHT:{
                        if(this.position.getCol()<this.map.getColumns()-1){
                            this.position.setCol(this.position.getCol()+1);
                            this.score+=this.map.hasTreasure(this.position);
                            this.map.update(this.position);
                            this.steps++;
                        }
                        else{
                            return false;
                        }
                        break;
                    }
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player pll=(Player) player;
        return pll.id==this.id;
    }
}