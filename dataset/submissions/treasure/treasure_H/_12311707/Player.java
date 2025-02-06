public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    private static int playerCnt;
    public Player(Map map,Position initialPosition){
        this.id=++playerCnt;
        this.position=initialPosition;
        this.score=this.steps=0;
        this.map=map;
        this.maxStepAllowed=2147483647;
        this.score+=this.map.hasTreasure(this.position);
        this.map.update(this.position);
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.id=++playerCnt;
        this.position=initialPosition;
        this.score=this.steps=0;
        this.map=map;
        this.maxStepAllowed=maxStepAllowed;
        this.score+=this.map.hasTreasure(this.position);
        this.map.update(this.position);
    }
    public int getId(){return this.id;}
    public int getScore(){return this.score;}
    public int getSteps(){return this.steps;}
    public Position getPosition(){return this.position;}
    public boolean move(Direction direction,int steps){
//        System.out.println("Moving.");
        if(!this.map.isActive())return false;
//        System.out.println("Moving!");
        switch (direction){
            case UP:{
                int limit=Math.min(this.position.getRow(),this.maxStepAllowed-this.steps);
                if(limit<steps){
                    for(int i=limit;i>0;--i){
                        this.position.setRow(this.position.getRow()-1);
                        this.score+=this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                        ++this.steps;
                        if(!this.map.isActive())break;
                    }
//                    System.out.println("fuck:"+this.getSteps());
                    return false;
                }
                for(int i=steps;i>0;--i){
                    this.position.setRow(this.position.getRow()-1);
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                    ++this.steps;
                    if(!this.map.isActive())break;
                }
//                System.out.println("fuck:"+this.getSteps());
                return true;
            }
            case DOWN:{
                int limit=Math.min(this.map.getRows()-1-this.position.getRow(),this.maxStepAllowed-this.steps);
                if(limit<steps){
                    for(int i=limit;i>0;--i){
                        this.position.setRow(this.position.getRow()+1);
                        this.score+=this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                        ++this.steps;
                        if(!this.map.isActive())break;
                    }
//                    System.out.println("fuck:"+this.getSteps());
                    return false;
                }
                for(int i=steps;i>0;--i){
                    this.position.setRow(this.position.getRow()+1);
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                    ++this.steps;
                    if(!this.map.isActive())break;
                }
//                System.out.println("fuck:"+this.getSteps());
                return true;
            }
            case LEFT:{
                int limit=Math.min(this.position.getCol(),this.maxStepAllowed-this.steps);
                if(limit<steps){
                    for(int i=limit;i>0;--i){
                        this.position.setCol(this.position.getCol()-1);
                        this.score+=this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                        ++this.steps;
                        if(!this.map.isActive())break;
                    }
//                    System.out.println("fuck:"+this.getSteps());
                    return false;
                }
                for(int i=steps;i>0;--i){
                    this.position.setCol(this.position.getCol()-1);
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                    ++this.steps;
                    if(!this.map.isActive())break;
                }
//                System.out.println("fuck:"+this.getSteps());
                return true;
            }
            case RIGHT:{
                int limit=Math.min(this.map.getColumns()-1-this.position.getCol(),this.maxStepAllowed-this.steps);
                if(limit<steps){
                    for(int i=limit;i>0;--i){
                        this.position.setCol(this.position.getCol()+1);
                        this.score+=this.map.hasTreasure(this.position);
                        this.map.update(this.position);
                        ++this.steps;
                        if(!this.map.isActive())break;
                    }
//                    System.out.println("fuck:"+this.getSteps());
                    return false;
                }
                for(int i=steps;i>0;--i){
                    this.position.setCol(this.position.getCol()+1);
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                    ++this.steps;
                    if(!this.map.isActive())break;
                }
//                System.out.println("fuck:"+this.getSteps());
                return true;
            }
            default:return false;
        }
    }
    public boolean equals(Object player){
        if(this==player)return true;
        return (player instanceof Player aPlayer)
                && (this.id==aPlayer.id);
    }
}