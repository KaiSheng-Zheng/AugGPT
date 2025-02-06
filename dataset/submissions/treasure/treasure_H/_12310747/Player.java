public class Player {
    private final int id;
    private static int count=1;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxStepAllowed=-1;

    public Player(Map map, Position initialPosition){
        this.map=map;
        position=new Position(initialPosition.getRow(),initialPosition.getCol());
        id=count;
        count++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        position=new Position(initialPosition.getRow(),initialPosition.getCol());
        this.maxStepAllowed=maxStepAllowed;
        id=count;
        count++;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }
    public Position getPosition(){
        return position;
    }

    public boolean move(Direction direction, int steps){
        boolean f=true;
        int canstep=-1;
        if (!map.getIsActive()){
            return false;
        }

            if (maxStepAllowed!=-1){
                if (this.steps+steps<=maxStepAllowed){
                    canstep=steps;
                }else {
                    canstep=maxStepAllowed-this.steps;
                    f=false;
                }
            }


            if (maxStepAllowed==-1){
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()){
                        return false;
                    }
                    int beforerow=position.getRow();
                    int beforecol=position.getCol();
                    int afterrow;
                    int aftercol;
                    int realstep=1;
                    switch (direction){
                        case UP :
                            afterrow=beforerow-1;
                            if (afterrow<0){
                                position.setRow(0);
                                f=false;
                                realstep=0;
                                break;
                            }else {
                                position.setRow(afterrow);
                            }
                            break;
                        case DOWN:
                            afterrow=beforerow+1;
                            if (afterrow>(map.getRows()-1)){
                                position.setRow(map.getRows()-1);
                                f=false;
                                realstep= 0;
                                break;
                            }else {
                                position.setRow(afterrow);
                            }
                            break;
                        case LEFT:
                            aftercol=beforecol-1;
                            if (aftercol<0){
                                position.setCol(0);
                                f=false;
                                realstep=0;
                                break;
                            }else {
                                position.setCol(aftercol);
                            }
                            break;
                        case RIGHT:
                            aftercol=beforecol+1;
                            if (aftercol>(map.getColumns()-1)){
                                position.setCol(map.getColumns()-1);
                                f=false;
                                realstep=0;
                                break;
                            }else {
                                position.setCol(aftercol);
                            }
                            break;
                    }
                    this.steps+=realstep;
                    this.score+= map.hasTreasure(this.position);
                    map.update(this.position);
                }

            }else {
                for (int i = 0; i < canstep; i++) {
                    if (!map.isActive()){
                        return false;
                    }
                    int beforerow=position.getRow();
                    int beforecol=position.getCol();
                    int afterrow;
                    int aftercol;
                    int realstep=1;
                    switch (direction){
                        case UP :
                            afterrow=beforerow-1;
                            if (afterrow<0){
                                position.setRow(0);
                                f=false;
                                realstep=0;
                                break;
                            }else {
                                position.setRow(afterrow);
                            }
                            break;
                        case DOWN:
                            afterrow=beforerow+1;
                            if (afterrow>(map.getRows()-1)){
                                position.setRow(map.getRows()-1);
                                f=false;
                                realstep= 0;
                                break;
                            }else {
                                position.setRow(afterrow);
                            }
                            break;
                        case LEFT:
                            aftercol=beforecol-1;
                            if (aftercol<0){
                                position.setCol(0);
                                f=false;
                                realstep=0;
                                break;
                            }else {
                                position.setCol(aftercol);
                            }
                            break;
                        case RIGHT:
                            aftercol=beforecol+1;
                            if (aftercol>(map.getColumns()-1)){
                                position.setCol(map.getColumns()-1);
                                f=false;
                                realstep=0;
                                break;
                            }else {
                                position.setCol(aftercol);
                            }
                            break;
                    }
                    this.steps+=realstep;
                    this.score+= map.hasTreasure(this.position);
                    map.update(this.position);
                }

            }




        return f;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        boolean f=false;
        if (id==p.getId()){
            f=true;
        }
        return f;
    }
}