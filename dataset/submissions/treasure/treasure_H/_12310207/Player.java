public class Player {
    private final int id;
    private  int score;
    private int steps;
    private Position position;
    private  Map map;
    private int maxStepAllowed;
    private boolean cao=false;
    public static int ID=0;

    public Player(Map map,Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        ID++;
        this.id=ID;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        this.cao=true;
        ID++;
        this.id=ID;
    }
    public boolean move(Direction direction,int steps){
        boolean flag1=true;
        boolean flag2=false;
       switch (direction){
           case RIGHT -> {
               for (int i = 0; i < steps; i++) {
                   if (!map.isActive()){
                       flag2=true;
                       break;
                   }
                   if (cao&&this.steps==maxStepAllowed){
                       flag1=false;
                   }if (this.position.getCol()+1==map.getColumns()||!map.isActive()){
                       flag1=false;
                   }
                   if (flag1){
                       this.steps=this.steps+1;
                       this.position.setCol(this.position.getCol()+1);
                       score=score+map.hasTreasure(this.position);
                       map.update(this.position);
                   }
               }break;

           }
           case LEFT -> {
               for (int i = 0; i < steps; i++) {
                   if (!map.isActive()){
                       flag2 = true;
                       break;
                   }
                   if (cao && this.steps == maxStepAllowed){
                       flag1 = false;
                   }
                   if (this.position.getCol() == 0 || !map.isActive()) {
                       flag1 = false;
                   }
                   if (flag1) {
                       this.steps = this.steps+1;
                       this.position.setCol(this.position.getCol() - 1);
                       score = score + map.hasTreasure(this.position);
                       map.update(this.position);
                   }
               }
               break;
           }case DOWN -> {
               for (int i = 0; i < steps; i++) {
                   if (!map.isActive()){
                       flag2= true;
                       break;
                   }
                   if (cao && this.steps == maxStepAllowed){
                       flag1 = false;
                   }
                   if (this.position.getRow()+1 ==map.getRows() || !map.isActive()) {
                       flag1 = false;
                   }
                   if (flag1) {
                       this.steps = this.steps+1;
                       this.position.setRow(this.position.getRow() + 1);
                       score = map.hasTreasure(this.position) + score;
                       map.update(this.position);
                   }
               }
               break;
           }case UP -> {
               for (int i = 0; i < steps; i++) {
                   if (!map.isActive()){
                       flag2 = true;
                       break;
                   }
                   if (cao && this.steps == maxStepAllowed){
                       flag1 = false;
                   }
                   if (this.position.getRow() == 0 || !map.isActive()){
                       flag1 = false;
                   }
                   if (flag1){
                       this.steps = this.steps+1;
                       this.position.setRow(this.position.getRow()-1);
                       score = score + map.hasTreasure(this.position);
                       map.update(this.position);
                   }
               }
               break;
           }
       }
        if (flag2){return false;}
        else {return flag1;}
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.id == this.id){return true;}
        else {return false;}
    }


    public Player(int id) {
        this.id = id;
    }

    public Player(int id, int score, int steps, Position position, Map map) {
        this.id = id;
        this.score = score;
        this.steps = steps;
        this.position = position;
        this.map = map;
    }

    public int getId() {
        return this.id;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String toString() {
        return "Player{id = " + id + ", score = " + score + ", steps = " + steps + ", position = " + position + ", map = " + map + "}";
    }
}
