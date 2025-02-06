
public class Player {
    private static int times=0;
    private final int id=times;
    private int score;
    private int steps;
    private int maxStepAllowed=Integer.MAX_VALUE;
    private Position position;
    private Map map;

    public Player(Map map,Position initialPosition){
        this.position = initialPosition;
        this.map = map;
        this.score = 0;
        this.steps = 0;
        times++;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.map = map;
        this.score = 0;
        this.steps = 0;
        times++;
    }
    public void setPosition(Position position){
        this.position = position;
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
    public boolean move(Direction direction,int steps){
        if(!map.isActive()){
            return false;
        }
        if(this.steps>=maxStepAllowed){
            return false;
        }
        switch (direction){
            case UP:
                for(int i=0;i<steps;i++)
                {
                    if(position.getRow()-1>=0){
                        if(this.steps==maxStepAllowed){
                            return false;
                        }
                        if(!map.isActive()){
                            return false;
                        }
                        position.setRow(position.getRow()-1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        this.steps++;
                    }else{
                        return false;
                    }

                }
                return true;
            case DOWN:
                for(int i=0;i<steps;i++)
                {
                    if(position.getRow()+1<=map.getRows()-1){
                        if(this.steps==maxStepAllowed){
                            return false;
                        }
                        if(!map.isActive()){
                            return false;
                        }
                        position.setRow(position.getRow()+1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        this.steps++;
                    }else{
                        return false;
                    }

                }
                return true;
            case LEFT:
                for(int i=0;i<steps;i++)
                {
                    if(position.getCol()-1>=0){
                        if(this.steps==maxStepAllowed){
                            return false;
                        }
                        if(!map.isActive()){
                            return false;
                        }
                        position.setCol(position.getCol()-1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        this.steps++;
                    }else{
                        return false;
                    }

                }
                return true;
            case RIGHT:
                for(int i=0;i<steps;i++)
                {
                    if(position.getCol()+1<=map.getColumns()-1){
                        if(this.steps==maxStepAllowed){
                            return false;
                        }
                        if(!map.isActive()){
                            return false;
                        }
                        position.setCol(position.getCol()+1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        this.steps++;
                    }else{
                        return false;
                    }

                }
                return true;
        }
        return false;
    }
    public boolean equals(Object player){
        return id==((Player)player).getId();
    }
    public String toString(){
        return String.format("(%d,%d)",position.getRow(),position.getCol());
    }
}
