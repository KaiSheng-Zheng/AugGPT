
public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    private static int count=0;
    public Player(Map map,Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        int max=Integer.MAX_VALUE;
        this.maxStepAllowed=max;
        count++;
        this.id=count;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        count++;
        this.id=count;
    }
    public int getId(){
        return id;
    }
    public int getScore(){
        return score;
    }
    public  int getSteps(){
        return steps;
    }
    public  void setScore(){}
    public Position getPosition(){
        return position;
    }
    public boolean move(Direction direction,int steps){
        if(map.isActive()){
            switch (direction){
                case UP:
                    int count1=0;
                    for(int i=0;i<steps;i++){
                        if(position.getRow()==0||this.steps==maxStepAllowed){
                            return false;
                        }
                        position.setRow(position.getRow()-1);
                        this.steps++;
                        count1++;
                        this.score=score+map.hasTreasure(position);
                        map.update(position);
                        if((steps==maxStepAllowed||position.getRow()==0||
                                (!map.isActive()))&&steps>count1){
                            return false;
                        }
                    }
                    return true;
                case DOWN:
                    int count2=0;
                    for(int i=0;i<steps;i++){

                        if(position.getRow()==map.getRows()-1||this.steps==maxStepAllowed){
                            return false;
                        }
                        position.setRow(position.getRow()+1);
                        this.steps++;
                        count2++;
                        this.score=score+map.hasTreasure(position);
                        map.update(position);
                        if((steps==maxStepAllowed||position.getRow()==
                                map.getRows()||(!map.isActive()))&&steps>count2){
                            return false;
                        }
                    }
                    return true;
                case LEFT:
                    int count3=0;
                    for(int i=0;i<steps;i++){

                        if(position.getCol()==0||this.steps==maxStepAllowed){
                            return false;
                        }
                        position.setCol(position.getCol()-1);
                        this.steps++;
                        count3++;
                        this.score=score+map.hasTreasure(position);
                        map.update(position);
                        if((steps==maxStepAllowed||position.getCol()==0||
                                (!map.isActive()))&&steps>count3){
                            return false;
                        }
                    }
                    return true;
                default:
                    int count4=0;
                    for(int i=0;i<steps;i++){

                        if(position.getCol()==map.getColumns()-1||this.steps==maxStepAllowed){
                            return false;
                        }
                        position.setCol(position.getCol()+1);
                        this.steps++;
                        count4++;
                        this.score=score+map.hasTreasure(position);
                        map.update(position);
                        if((this.steps==maxStepAllowed||position.getCol()==
                            map.getColumns()||(!map.isActive()))&&steps>count4){
                            return false;
                        }
                    }
                    return true;
            }
        }else{
            return false;
        }
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        if(p.getId()==this.getId()){
            return true;
        }else{
            return false;
        }
    }
}
