public class Player {
    private final int id;
    private int score;
    private Position position;
    private Map map;
    private int steps;
    private static int tempplayerid=1;
    private int Maxsteps=2147483647;
    private int stepsTaken=0;

    public Player(Map map, Position initialPosition){
        id=tempplayerid;
        tempplayerid+=1;
        this.position=initialPosition;
        this.map=map;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id=tempplayerid;
        tempplayerid+=1;
        this.map=map;
        this.position=initialPosition;
        Maxsteps=maxStepAllowed;
    }
    public boolean move(Direction direction,int steps){
        return move(direction,steps,1);
    }
    public boolean move(Direction direction, int steps,int aaaa){
        if(map.isActive()){
            if (steps==0) return true;
            if (Maxsteps==0) return false;
            switch (direction) {
                case LEFT: {
                    while (steps > 0&Maxsteps>0&map.isActive()) {
                        if (position.getCol()-1 >= 0) {
                            position.setCol(position.getCol() - 1);
                            steps--;
                            Maxsteps--;
                            stepsTaken++;
                        }else {
                            return false;
                        }
                        score+=map.hasTreasure(this.position,1);
                    }
                    if (steps==0) {
                        return true;
                    }else {
                        return false;
                    }
                }
                case RIGHT:{
                    while (steps > 0&Maxsteps>0&map.isActive()) {
                        if (position.getCol()+1 < map.getColumns()) {
                            position.setCol(position.getCol() + 1);
                            steps--;
                            Maxsteps--;
                            stepsTaken++;
                        }else {
                            return false;
                        }
                        score+=map.hasTreasure(this.position,1);
                    }
                    if (steps==0) {
                        return true;
                    }else {
                        return false;
                    }
                }
                case UP:{
                    while (steps > 0&Maxsteps>0&map.isActive()) {
                        if (position.getRow()-1 >= 0) {
                            position.setRow(position.getRow() - 1);
                            steps--;
                            Maxsteps--;
                            stepsTaken++;
                        }else {
                            return false;
                        }
                        score+=map.hasTreasure(this.position,1);
                    }
                    if (steps==0) {
                        return true;
                    }else {
                        return false;
                    }
                }
                case DOWN:{
                    while (steps > 0&Maxsteps>0&map.isActive()) {
                        if (position.getRow()+1 < map.getRows()) {
                            position.setRow(position.getRow() + 1);
                            steps--;
                            Maxsteps--;
                            stepsTaken++;
                        }else {
                            return false;
                        }
                        score+=map.hasTreasure(this.position,1);
                    }
                    if (steps==0) {
                        return true;
                    }else {
                        return false;
                    }
                }
                default:return true;
            }
        }  else {
            return false;
        }
    }
    public boolean equals(Object player){
        if (player instanceof Player){
            Player tempP=(Player)player;
            return equals(tempP);
        }else return false;
    }
    public boolean equals(Player tempP){
        if (tempP.getId() == this.id){
         return true;
        } else return false;
    }
    public int getId(){
        return id;
    }
    public int getScore(){
        return score;
    }
    public int getSteps(){
        return stepsTaken;
    }
    public Position getPosition(){
        return position;
    }
}