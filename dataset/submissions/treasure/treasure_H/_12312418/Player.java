public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int count=0;
    private int maxStepAllowed;
    public static int[] arr2=new int[200];
    public static int[] arsp=new int[200];
    public int getId() {
        return id;
    }
    public Player(Map map, Position initialPosition){
        int a=count;
this.map=map;
this.position=initialPosition;
this.id=a+1;
count++;
this.maxStepAllowed=-1;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        int a=count;
        this.position=initialPosition;
        this.id=a+1;
        count++;
this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        int a=0;
        if(map.isActive()==false){
            a=-1;
        }
        else if(maxStepAllowed>=0 & arr2[id-1]>=maxStepAllowed){
            a=-1;
        }
else{
    switch(direction) {
            case UP:
for(int i=1;i<=steps;i++){
   if(map.isActive()==false){
       a=-1;
       break;
   }
    if(position.getRow()==0|arr2[id-1]==maxStepAllowed ){
        a=-1;
        break;
    }
    else if(position.getRow()>=1){
        position.setRow(position.getRow()-1);
        this.score=this.score+map.hasTreasure1(position);
        this.steps++;
        arr2[id-1]++;
        arsp[id-1]=score;
        a=1;
    }
}
                break;
        case DOWN:
            for(int i=1;i<=steps;i++){
                if(map.isActive()==false){
                    a=-1;
                    break;
                }
                if(position.getRow()== map.getRows()-1|arr2[id-1]==maxStepAllowed ){
                    a=-1;
                    break;
                }
                else if(position.getRow()< map.getRows()-1){
                    position.setRow(position.getRow()+1);
                    this.score=this.score+map.hasTreasure1(position);
                    this.steps++;
                    arr2[id-1]++;
                    arsp[id-1]=score;
                    a=1;
                }
            }
            break;
        case LEFT:
            for(int i=1;i<=steps;i++){
                if(map.isActive()==false){
                    a=-1;
                    break;
                }
                if(position.getCol()==0|arr2[id-1]==maxStepAllowed ){
                    a=-1;
                    break;
                }
                else if(position.getCol()>=1){
                    position.setCol(position.getCol()-1);
                    this.score=this.score+map.hasTreasure1(position);
                    this.steps++;
                    arr2[id-1]++;
                    arsp[id-1]=score;
                    a=1;
                }
            }
            break;
        case RIGHT:
            for(int i=1;i<=steps;i++){
                if(map.isActive()==false){
                    a=-1;
                    break;
                }
                if(position.getCol()==map.getColumns()-1|arr2[id-1]==maxStepAllowed ){
                    a=-1;
                    break;
                }
                else if(position.getCol()< map.getColumns()){
                    position.setCol(position.getCol()+1);
                    this.score=this.score+map.hasTreasure1(position);
                    this.steps++;
                    arr2[id-1]++;
                    arsp[id-1]=score;
                    a=1;
                }
            }
            break;
        }
}
if(a<=0){
    return false;
}
else{
    return true;
}
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id==p.id;
    }

    public int getSteps() {
        return steps;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
