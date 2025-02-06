public class Player {
    private static int count = 1;
    private final int id;
    private int score;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxStepAllowed=100000;

    public int getId() {
        return id;
    }


    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        id = count;
        count++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        id = count;
        count++;
    }

    public boolean move(Direction direction,int steps){
       int row=position.getRow();
       int col=position.getCol();
       boolean flag =false;
       switch (direction){
           case UP:{row=position.getRow()-steps;break;}
           case DOWN:{row=position.getRow()+steps;break;}
           case LEFT:{col=position.getCol()-steps;break;}
           case RIGHT:{col=position.getCol()+steps;break;}
       }
       if (map.isActive()&& steps<maxStepAllowed){
         //  
//           position.setRow(row);
//           position.setCol(col);
           steps+=1;

         switch (direction){
             case UP :{
                 for (int i = 0; i < steps; i++) {
                     position.setRow(position.getRow()-1);

                   score=score+ map.hasTreasure(position); map.update(position);
                 }
             break;}
             case DOWN :{
                 for (int i = 0; i < steps; i++) {
                     position.setRow(position.getRow()+1);
                   score=score+ map.hasTreasure(position); map.update(position);
                 }
             break;}
             case LEFT :{
                 for (int i = 0; i < steps; i++) {
                     position.setCol(position.getCol()-1);
                   score=score+ map.hasTreasure(position); map.update(position);
                 }
             break;}
             case RIGHT :{
                 for (int i = 0; i < steps; i++) {
                     position.setCol(position.getCol()-1);
                   score=score+ map.hasTreasure(position); map.update(position);
                 }
             break;}

         }if(row>=0&&row<map.getRows()&&col>=0&&col< map.getColumns())flag= true;
          if(row<0)position.setRow(0);
          if(col<0)position.setCol(0);
          if(row> map.getRows()-1)position.setRow(map.getRows()-1);
          if(col> map.getColumns()-1)position.setCol(map.getColumns()-1);
       }
       return flag;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if(id==((Player)player).id){return true;}
        else return false;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }
}
