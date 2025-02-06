
public class Player {
    private final int id;
    private static int idNew;
    private int score;
    public int getSteps() {
        return steps;
    }

    private int steps;
    private Position position;

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
    public int getId() {
        return id;
    }

    private final Map map;
    private int maxStepAllowed=999999;

    public Player(Map map,Position position){
        this.map=map;
        this.position=position;
        id=idNew;
        idNew+=3;

    }
    public Player(Map map,Position position,int maxStepAllowed){
        this.map=map;
        this.position=position;
        this.maxStepAllowed=maxStepAllowed;
        id=idNew;
        idNew+=3;
    }
    public boolean move(Direction direction,int steps) { 
        boolean output=true;
        
         for(int i=1;i<=steps;i++) {
             if (map.isActive())
             {
                if(this.steps<maxStepAllowed){
                 if (direction==Direction.DOWN){
                     if(position.getRow()+1==map.getRows() ){
                         output=false;
                     }
                     else{
                         position.down();
                         score+=map.hasTreasure(position);
                         map.update(position);
                         this.steps++;
                     }
                 }
                 if (direction==Direction.UP){
                     if(position.getRow()-1==-1 ){
                         output=false;
                     }
                     else{
                         position.up();
                         score+=map.hasTreasure(position);
                         map.update(position);
                         this.steps++;
                     }
                 }
                 if (direction==Direction.LEFT){
                        if(position.getCol()-1==-1 ){
                            output=false;
                        }
                        else{
                            position.left();
                            score+=map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                        }
                 }
                    if (direction==Direction.RIGHT){
                        if(position.getCol()+1== map.getColumns() ){
                            output=false;
                        }
                        else{
                            position.right();
                            score+=map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                        }
                    }

                }else{
                    output=false;}
             }
             else {
                 output = false;
                 break;
             }
         }

         return output;
    }

         public boolean equals(Object play){
        Player player=(Player) play;
        return player.id==id;
    }

}
