
public class Player {
    private static int nextId = 1;
    private final int id;

    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed=-1;
    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    //int n=0;
    int n=0;
    public Player(Map map, Position initialPos, int maxStepAllowed){
        this.id=nextId++;
        this.position =initialPos;
        this.map=map;
        this.maxStepAllowed=maxStepAllowed;
    }
    public Player(Map map, Position initialPos){
        this.id=nextId++;
        this.position =initialPos ;
        this.map = map;
    }
    int newRow=0;
    int newCol=0;
    int recordrow=0;
    int recordcol=0;
    int recordstep=0;
    int f=0;
    int e=0;
    boolean judge=false;
    public boolean move(Direction direction, int steps){
        if(!judge){
            if(!map.isActive()){
                return false;
            }
        }

        if(n==0){
            newRow = position.getRow();
            newCol = position.getCol();
        }
        outer:
        for(int j=0;j<steps;j++){
            switch (direction) {
                case UP:
                    newRow --;
                    if(newRow<0){
                        newRow++;
                        if(judge){
                            this.steps=recordstep;
                            position.setRow(recordrow);
                            position.setCol(recordcol);
                        }
                        return false;
                        //break outer;
                    }
                    break;
                case DOWN:
                    newRow ++;

                    if(newRow>map.getRows()-1){
                        newRow--;
                        if(judge){
                            this.steps=recordstep;
                            position.setRow(recordrow);
                            position.setCol(recordcol);
                        }
                        return false;
                        //break outer;
                    }
                    break;
                case LEFT:
                    newCol --;
                    if(newCol<0){
                        newCol++;
                        if(judge){
                            this.steps=recordstep;
                            position.setRow(recordrow);
                            position.setCol(recordcol);
                        }
                        return false;
                        //break outer;
                    }
                    break;
                case RIGHT:
                    newCol ++;
                    if(newCol>map.getColumns()-1){
                        newCol--;
                        if(judge){
                            this.steps=recordstep;
                            position.setRow(recordrow);
                            position.setCol(recordcol);
                        }
                        return false;
                        //break outer;
                    }
                    break;
            } if(getMaxStepAllowed()>=0){
                if(this.steps>=getMaxStepAllowed()){
                    this.steps=getMaxStepAllowed();
                    if(map.hasTreasure(position)!=0){
                        score += map.hasTreasure(position);
                    }
                    return false;

                }
            }
            position.setCol(newCol);
            position.setRow(newRow);
            if(map.hasTreasure(position)!=0) {
                score += map.hasTreasure(position);
                map.update(position);
                if (!judge) {
                    if (!map.isActive()) {
                        this.steps++;
                        recordstep=this.steps;
                        recordrow=position.getRow();
                        recordcol=position.getCol();
                        judge=true;
                        //break;
                    }
                }

            }
            this.steps++;
        }
        if(judge){
            if(position.getRow()!=recordrow||position.getCol()!=recordcol){
                this.steps=recordstep;
                position.setRow(recordrow);
                position.setCol(recordcol);
                return false;
            }
        }
        if(judge){
            this.steps=recordstep;
            position.setRow(recordrow);
            position.setCol(recordcol);
        }

           if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
              return false;
          }
          n++;

          return true;
    }
    public boolean equals(Object player){
        Player player1=(Player) player;
        if(player1.getId()==id){
            return true;
        }else {
            return false;
        }
    }
}
        /*Player.java
        Map.java
        GameSystem.java
        Position.java
        Treasure.java*/