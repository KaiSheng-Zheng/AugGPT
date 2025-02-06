public class Player {

    private static int cnt = 0;
    private final int id = ++Player.cnt;
    private int score = 0;
    private int steps = 0;

    private int maxStepAllowed =-1;
    private Position position;
    private Map map;

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }

    public Player(Map map,Position initialPos) {
        this.map = map;
        this.position = initialPos;
    }

    public Player(Map map, Position initialPos, int maxStepAllowed){
        this.map = map;
        this.position = initialPos;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps){
        boolean ret = false;
        if (!this.map.isActive()) {
            return false;
        }

        int rol = this.map.getRows();
        int col = this.map.getColumns();
        int uRol = this.position.getRow();
        int uCol = this.position.getCol();

        switch (direction){
            case UP:
                if((maxStepAllowed>0&&getSteps()==this.maxStepAllowed)|| uRol==0||maxStepAllowed==0){
                    break;
                }else{
                    boolean limitFlag = true;
                    if(maxStepAllowed>0){
                        int limitedSteps = this.maxStepAllowed - getSteps();
                        if(limitedSteps<steps){
                            limitFlag = false;
                        }
                        steps = Math.min(limitedSteps, steps);
                    }
                    if(uRol-steps>=0){
                        ret = limitFlag;
                        this.position.setRow(uRol-steps);
                    }else{
                        this.position.setRow(0);
                    }
                    int cnt = 0;
                    for(int i=uRol-1;cnt<steps&&i>=0;i--){
                        cnt++;
                        int treasure = this.map.hasTreasure(new Position(i,uCol));
                        if(treasure>0){
                            this.score+=treasure;
                            this.map.update(new Position(i,uCol));
                        }
                    }
                    this.setSteps(this.getSteps()+cnt);
                }
                break;
            case DOWN:
                if((maxStepAllowed>0&&getSteps()==this.maxStepAllowed)|| uRol==rol-1||maxStepAllowed==0){
                    break;
                }else{
                    boolean limitFlag = true;
                    if(maxStepAllowed>0){
                        int limitedSteps = this.maxStepAllowed - getSteps();
                        if(limitedSteps<steps){
                            limitFlag = false;
                        }
                        steps = Math.min(limitedSteps, steps);
                    }
                    if(uRol+steps<=rol-1){
                        ret = limitFlag;
                        this.position.setRow(uRol+steps);
                    }else{
                        this.position.setRow(rol-1);
                    }
                    int cnt = 0;
                    for(int i=uRol+1;cnt<steps&&i<rol;i++){
                        cnt++;
                        int treasure = this.map.hasTreasure(new Position(i,uCol));
                        if(treasure>0){
                            this.score+=treasure;
                            this.map.update(new Position(i,uCol));
                        }
                    }
                    this.setSteps(this.getSteps()+cnt);
                }
                break;
            case LEFT:
                if((maxStepAllowed>0&&getSteps()==this.maxStepAllowed)|| uCol==0||maxStepAllowed==0){
                    break;
                }else{
                    boolean limitFlag = true;
                    if(maxStepAllowed>0){
                        int limitedSteps = this.maxStepAllowed - getSteps();
                        if(limitedSteps<steps){
                            limitFlag = false;
                        }
                        steps = Math.min(limitedSteps, steps);
                    }
                    if(uCol-steps>=0){
                        ret = limitFlag;
                        this.position.setCol(uCol-steps);
                    }else{
                        this.position.setCol(0);
                    }
                    int cnt = 0;
                    for(int i=uCol-1;cnt<steps&&i>=0;i--){
                        cnt++;
                        int treasure = this.map.hasTreasure(new Position(uRol,i));
                        if(treasure>0){
                            this.score+=treasure;
                            this.map.update(new Position(uRol,i));
                        }
                    }
                    this.setSteps(this.getSteps()+cnt);
                }
                break;
            case RIGHT:
                if((maxStepAllowed>0&&getSteps()==this.maxStepAllowed)|| uCol==col-1||maxStepAllowed==0){
                    break;
                }else{
                    boolean limitFlag = true;
                    if(maxStepAllowed>0){
                        int limitedSteps = this.maxStepAllowed - getSteps();
                        if(limitedSteps<steps){
                            limitFlag = false;
                        }
                        steps = Math.min(limitedSteps, steps);
                    }

                    if(uCol+steps<=col-1){
                        ret = limitFlag;
                        this.position.setCol(uCol+steps);
                    }else{
                        this.position.setCol(col-1);
                    }
                    int cnt = 0;
                    for(int i=uCol+1;cnt<steps&&i<col;i++){
                        cnt++;
                        int treasure = this.map.hasTreasure(new Position(uRol,i));
                        if(treasure>0){
                            this.score+=treasure;
                            this.map.update(new Position(uRol,i));
                        }
                    }
                    this.setSteps(this.getSteps()+cnt);
                }
                break;
            default:
                System.out.println("error");
        }

        return ret;
    }

    public boolean equals(Object player){
        Player otherP = (Player)player;
        return this.getId()==otherP.getId();
    }
}